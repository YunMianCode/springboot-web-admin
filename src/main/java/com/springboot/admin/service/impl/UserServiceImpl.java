package com.springboot.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.admin.common.code.MD5;
import com.springboot.admin.common.constant.UpmsConstant;
import com.springboot.admin.common.util.Result;
import com.springboot.admin.dao.UserMapper;
import com.springboot.admin.model.User;
import com.springboot.admin.service.UserService;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserServiceImpl userService;

    @Override
    public User getByName(String userName) {
        return baseMapper.getByName(userName);
    }

    @Override
    public boolean isValidatePwd(String password) {
        return false;
    }

    @Override
    public int getCounts() {
        return baseMapper.getCounts();
    }

    @Override
    @Transactional
    public Result add(User user) {
//        int i = 10 / 0;
//        int counts = userService.getCounts();
        String pwd = getPassword(user);
        user.setPassword(pwd);
        User byUsername = userService.getByUsername(user);
        if(byUsername != null){
            return Result.duplicateName();
        }else{
            user.setStatus("1");
            baseMapper.insert(user);
            return Result.success("添加成功");
        }
    }

    @Override
    public Result delete(User user) {
        User olduser = baseMapper.selectById(user.getUserId());
        if(olduser != null){
            olduser.setStatus("0");
            baseMapper.deleteById(olduser);
            return Result.success("删除成功");
        }else{
            return Result.fail("删除失败");
        }
    }

    public String getPassword(User user){
        String pwd = UpmsConstant.PREFIX_MD5 + user.getPassword();
        return MD5.getMD5(pwd);
    }

    public User getByUsername(User user){
        return baseMapper.getByName(user.getUserName());
    }

}
