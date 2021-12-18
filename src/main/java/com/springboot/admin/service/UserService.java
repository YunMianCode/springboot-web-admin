package com.springboot.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.admin.common.util.Result;
import com.springboot.admin.model.User;
import io.swagger.annotations.ApiOperation;

public interface UserService extends IService<User> {

    //根据用户名查找用户
    User getByName(String userName);

//    User getByLoginName(String loginName);

    //判断密码合法性
    boolean isValidatePwd(String password);

    //统计数据库中用户数量
    int getCounts() throws Exception;

    //添加用户
    Result add(User user);

    //删除用户（根据用户Id）
    Result delete(User user);

    //获取密码，用户登录操作检验密码正确性
    String getPassword(User user);

    //根据用户，获取用户
    User getByUsername(User user);

}
