package com.springboot.admin.controller;


import com.springboot.admin.common.util.Result;
import com.springboot.admin.model.User;
import com.springboot.admin.service.UserService;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

@RestController
@Slf4j
@Validated//开启hibernate-validator校验
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("getCountsByCache")
    public Result getCountsByCache() throws Exception {
        return Result.success(stringRedisTemplate.opsForValue().get("USER_COUNTS"));
    }


    @PostMapping("add")
    @ApiOperation(value = "新增用户",response = Result.class,notes = "请注意非空字段")
    public Result addUser(@RequestBody @Validated User user) {
        return userService.add(user);
    }



    @PostMapping("deleteById")
    @ApiOperation(value = "删除用户",response = Result.class,notes = "该操作为逻辑删除，且传参为用户实体")
    public Result deleteUser(@RequestBody User user){
        return userService.delete(user);
    }

    /*
     * 测试hibernate-validator校验
     * 简单类型的校验
     * */
    @PostMapping("testDelete")
    public String delete(@RequestBody @NotNull(message = "用户id不能为空")  Integer id){
        System.out.println("delete..." + id);
        return "delete success";
    }



}
