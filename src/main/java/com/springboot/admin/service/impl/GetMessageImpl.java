package com.springboot.admin.service.impl;


import com.springboot.admin.model.User;
import com.springboot.admin.service.GetMessage;
import org.springframework.stereotype.Service;

@Service
public class GetMessageImpl implements GetMessage {

    @Override
    public String getKeyName(User user) {
        return "user:"+user.getUserName();
    }

    @Override
    public String getLoginTimeLockKey(User user) {
        return "user_lock:"+user.getUserName();
    }

    @Override
    public String getLoginCountFailKey(User user) {
        return "user_fail:"+user.getUserName();
    }

}
