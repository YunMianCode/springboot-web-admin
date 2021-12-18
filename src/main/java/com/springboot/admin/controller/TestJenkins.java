package com.springboot.admin.controller;


import com.springboot.admin.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(value = "测试Jenkins")
@RequestMapping("testJenkins")
public class TestJenkins {

    @Resource
    private UserService userService;

    @GetMapping("getCounts")
    @ApiOperation(value = "获取用户User数量")
    public int getCounts() throws Exception {
        return userService.getCounts();
    }

}
