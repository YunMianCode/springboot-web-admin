package com.springboot.admin.controller;


import com.springboot.admin.common.util.Result;
import com.springboot.admin.model.User;
import com.springboot.admin.service.UserService;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("getCounts")
    public Result getCounts() throws Exception {
        return Result.success(stringRedisTemplate.opsForValue().get("USER_COUNTS"));
    }

    @PostMapping("add")
    public Result addUser(@RequestBody User user) {
        return userService.add(user);
    }



}
