package com.springboot.admin.controller;

import cn.hutool.http.HttpResponse;
import com.springboot.admin.common.util.Result;
import com.springboot.admin.model.User;
import com.springboot.admin.service.LoginService;
import com.springboot.admin.service.impl.GetMessageImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping("system")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private GetMessageImpl getMessage;

    @PostMapping("/login")
    public Result login(@RequestBody User InputUser, HttpSession session) {
        log.info("{}正在尝试登陆",InputUser.getUserName());
        String username = InputUser.getUserName();
        String password = InputUser.getPassword();
        User user = new User(username, password);
        Map<String, Object> map = loginService.loginUserLock(user);   //登录 验证第一层  看用户是否被限制登录
        if ((Boolean) map.get("flag")) {   //如果为true表示被限制登录
            session.setAttribute("isLogin",false);
            return Result.fail("登录失败,因" + username + "超过了限制登录次数,已被禁止登录.还剩" + map.get("lockTime") + "分钟");
        } else {   //表示没有被限制登录   执行 下一步登录逻辑
            User user1 = loginService.doLogin(user);  //执行登录功能
            if (user1 != null) {   //表示密码正确  登录成功
                 //清空对应的所有key
                loginService.DeleteMemory(getMessage.getLoginCountFailKey(user));
                loginService.DeleteMemory(getMessage.getLoginTimeLockKey(user));
                loginService.DeleteMemory(getMessage.getKeyName(user));
                log.info("{}登陆成功",user1.getUserName());
                session.setAttribute("isLogin",true);
                return Result.success("登录成功");
            } else {
                //登录不成功   计入登录此时 等逻辑操作
                session.setAttribute("isLogin",false);
                return loginService.loginValdate(user);
            }
        }

    }

}
