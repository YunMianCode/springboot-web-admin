package com.springboot.admin.controller;


import com.springboot.admin.common.util.Result;
import com.springboot.admin.model.User;
import com.springboot.admin.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

@RestController
@Validated//开启hibernate-validator校验
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("getCountsByCache")
    public Result getCountsByCache() throws Exception {
        logger.trace("trace...");
        logger.debug("debug...");
        logger.info("info...");
        logger.warn("warn...");
        logger.error("error...");
        return Result.success(stringRedisTemplate.opsForValue().get("USER_COUNTS"));
    }

    @GetMapping("getCounts")
    public Result getCounts() throws Exception {
        return Result.success(userService.getCounts());
    }


    @PostMapping("add")
    @ApiOperation(value = "新增用户", response = Result.class, notes = "请注意非空字段")
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
    public String delete(@RequestBody @NotNull(message = "用户id不能为空") Integer id) {
        System.out.println("delete..." + id);
        return "delete success";
    }

    @PostMapping("testXSS")
    public Result testXSS(@RequestBody User user) {
        logger.info(user.getUserName());
        return Result.success();
    }


}
