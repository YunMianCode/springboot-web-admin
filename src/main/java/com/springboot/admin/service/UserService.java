package com.springboot.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.admin.common.util.Result;
import com.springboot.admin.model.User;

public interface UserService extends IService<User> {

    User getByName(String userName);

//    User getByLoginName(String loginName);

    boolean isValidatePwd(String password);

    int getCounts() throws Exception;

    Result add(User user);

}
