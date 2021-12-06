package com.springboot.admin.common.exception;


import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "用户数量超过上限")
public class UserTooManyException extends RuntimeException{

    public UserTooManyException(){

    }

    public UserTooManyException(String message) {
        super(message);
    }

}
