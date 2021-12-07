package com.springboot.admin.service;


import com.springboot.admin.common.util.Result;
import com.springboot.admin.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;


public interface LoginService {

    /**
     * 用户登录
     * @param User
     * @return
     */
    User doLogin(User user);

    /**
     * 验证用户登录的账号和密码
     * @param user
     * @return
     */
    Result login(User user, HttpServletRequest request);


    /**
     * 判断当前的登录用户是否被限制登录
     * @param user
     * @return
     */
    Map<String,Object> loginUserLock(User user);

    /**
     * 登录不成功的操作(密码错误)
     * @param user
     * @return
     */
    Result loginValdate(User user);

    /**
     * 删除登录失败所存入的键值对
     * @param key
     * @return
     */
    Boolean DeleteMemory(String key);

}
