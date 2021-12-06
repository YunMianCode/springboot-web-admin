package com.springboot.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

//    @Override
//    public User getByLoginName(String loginName) {
//        User user =baseMapper.getByLoginName(loginName);
//        if(user != null){
//            return user;
//        }
//    }

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
        baseMapper.insert(user);
        return Result.success();
    }
}
