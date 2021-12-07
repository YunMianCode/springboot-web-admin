package com.springboot.admin.controller;

import cn.hutool.http.HttpResponse;
import com.springboot.admin.common.util.Result;
import com.springboot.admin.model.User;
import com.springboot.admin.service.LoginService;
import com.springboot.admin.service.UserService;
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

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User InputUser ,HttpServletRequest request) {
        log.info("{}正在尝试登陆",InputUser.getUserName());
        return loginService.login(InputUser,request);
    }

}
