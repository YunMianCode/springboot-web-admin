package com.springboot.admin.controller;


import com.springboot.admin.service.UserService;
import com.sun.tools.sjavac.comp.PubapiVisitor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController("testJenkins")
public class TestController {

    @Resource
    private UserService userService;

    @GetMapping("getCounts")
    public int getCounts() throws Exception {
        return userService.getCounts();
    }

}
