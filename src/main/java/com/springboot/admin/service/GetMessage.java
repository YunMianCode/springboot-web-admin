package com.springboot.admin.service;

import com.springboot.admin.model.User;

public interface GetMessage {

    String getKeyName(User user);

    String getLoginTimeLockKey(User user);

    String getLoginCountFailKey(User user);

}
