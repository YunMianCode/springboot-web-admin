package com.springboot.admin.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.springboot.admin.common.result.Result;
import com.springboot.admin.model.User;
import com.springboot.admin.service.LoginService;
import com.springboot.admin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserService userService;

    @Autowired
    GetMessageImpl getMessage;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    private LoginService loginService;

    @Override
    public User doLogin(User user) {
        String username = user.getUserName();
        String password = userService.getPassword(user);
        /*
         * 非空判断
         */
        if ("null".equals(username) || StringUtils.isBlank(username)) {
            throw new RuntimeException("用户名或密码不能为空！");
        }
        // 代码审计，去掉"null"值判断
        if (StringUtils.isBlank(password)) {
            throw new RuntimeException("用户名或密码不能为空！");
        }
        User dbuser = userService.getByName(username);
        if(dbuser != null) {
            boolean flag = password.equals(dbuser.getPassword());
            if(flag){
                return user;
            }else{
                return null;
            }
        }else {
            return null;
        }

    }

    /**
     * 验证用户是密码是否正确
     *
     * @param user
     * @return
     */
    @Override
    public Result login(User user, HttpServletRequest request) {
        String username = user.getUserName();
        String password = user.getPassword();
        User login_user = new User(username, password);
        HttpSession session = request.getSession();
        Map<String, Object> map = loginService.loginUserLock(login_user);   //登录 验证第一层  看用户是否被限制登录
        if ((Boolean) map.get("flag")) {   //如果为true表示被限制登录
            session.setAttribute("isLogin","false");
            return Result.fail("登录失败,因" + username + "超过了限制登录次数,已被禁止登录.还剩" + map.get("lockTime") + "分钟");
        } else {
            //表示没有被限制登录   执行 下一步登录逻辑
            User user1 = loginService.doLogin(user);
            //执行登录功能
            if (user1 != null) {
                //表示密码正确  登录成功  清空对应的所有key
                loginService.DeleteMemory(getMessage.getLoginCountFailKey(user));
                loginService.DeleteMemory(getMessage.getLoginTimeLockKey(user));
                loginService.DeleteMemory(getMessage.getKeyName(user));
                log.info("{}登陆成功",user1.getUserName());
                session.setAttribute("isLogin","true");
                return Result.success("登录成功");
            } else {
                //登录不成功   计入登录此时 等逻辑操作
                session.setAttribute("isLogin","true");
                return loginService.loginValdate(user);
            }
        }
    }

    /**
     * 判断当前登录的用户是否被限制登录
     * 查询当前key是否存在,如果存在,就被限制,注意:需要给用户做提示:您当前的用户已被限制,还剩多长时间
     * 如果不存在就不被限制
     *
     * @param user
     * @return
     */
    @Override
    public Map<String, Object> loginUserLock(User user) {
        Map<String, Object> map = new HashMap<>();
        if (stringRedisTemplate.hasKey(getMessage.getLoginTimeLockKey(user))) {
            //如果存在就是用户已经输错了密码五次 被锁定了俩小时
            map.put("flag", true);  //表示用户已经被锁定
            map.put("lockTime", stringRedisTemplate.getExpire(getMessage.getLoginTimeLockKey(user), TimeUnit.MINUTES));     //得到被锁定之后还剩下多少时间  以分钟返回
        } else {
            map.put("flag", false);   //flag 为false 表示用户没有被限制
        }
        return map;
    }


    /**
     * 登录失败的相应操作(密码错误)
     *
     * @param user
     * @return
     */

    @Override
    public Result loginValdate(User user) {

        Integer num = 5;
        //记录登录错误次数的key
        String key = getMessage.getLoginCountFailKey(user);
        if (!stringRedisTemplate.hasKey(key)) {   //如果不存在
            //是第一次登录失败 次数为1   userlogincountfile;用户名进行赋值   同时设置失效期2分钟
            stringRedisTemplate.opsForValue().set(key, "1", 5, TimeUnit.MINUTES);
            return Result.fail("登录失败,在5分钟内还允许输入错误" + (num - 1) + "次");
        } else {
            //如果存在
            //查询登录失败次数
            long loginFilCount = Long.parseLong(stringRedisTemplate.opsForValue().get(key));
            if (loginFilCount < (num - 1)) {    //代表当前如果登录次数小于4  意思:还有资格继续进行登录
                //登录次数+1
                stringRedisTemplate.opsForValue().increment(key, 1);
                long secends = stringRedisTemplate.getExpire(key, TimeUnit.SECONDS);  //返回的是秒
                return Result.fail(user.getUserName() + "登录失败,在" + secends + "秒内还允许输入错误" + (num - loginFilCount - 1) + "次");
            } else {
                //超过了指定的登录次数
                String lockkey = getMessage.getLoginTimeLockKey(user);
                stringRedisTemplate.boundValueOps("key");//可以实现绑定某个类型的key
                stringRedisTemplate.opsForValue().set(lockkey, "1", 1, TimeUnit.HOURS);
                return Result.fail("因登录失败此时超过" + num + "次,以对其限制登录1小时");
            }
        }
    }

    @Override
    public Boolean DeleteMemory(String key) {
        try {
            stringRedisTemplate.delete(key);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
