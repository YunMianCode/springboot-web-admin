package com.springboot.admin.controller;

import com.springboot.admin.common.exception.UserTooManyException;
import com.springboot.admin.model.Car;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestExceptionHandlerController {

    @Autowired
    private Car car;

    @GetMapping("/test1")
    @ResponseBody
    @ApiOperation(value = "测试数据异常（数学异常）")
    public int test1(){
        int i = 10 / 0 ;
        return i;
    }

    @GetMapping("test2")
    @ResponseBody
    @ApiOperation(value = "测试自定义异常（用户数量过多）")
    public int test2(){
        int index = 10;
        if(5 < index){
            throw new UserTooManyException();
        }
        return index;
    }

    @GetMapping("/car")
    @ResponseBody
    public int car(){
        return car.getRandomValue();
    }

}
