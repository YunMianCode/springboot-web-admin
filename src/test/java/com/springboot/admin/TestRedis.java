package com.springboot.admin;

import com.springboot.admin.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class TestRedis {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    public void getString(){

        User user = new User();
        user.setUserId(12);
        user.setUserName("testRedis");
        user.setPassword("testRedis");
        user.setTel("110");
        user.setStatus("1");

        redisTemplate.opsForValue().set("user",user);
        redisTemplate.opsForValue().set("name","guoan");
        redisTemplate.expire("name",10, TimeUnit.SECONDS);

        System.out.println(redisTemplate.opsForValue().get("user"));

    }

    @Test
    public void test1(){
        Date today = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("HH");
        Integer time = Integer.valueOf(sf.format(today));
        Integer integer =  time;
        List list = new ArrayList();
        while (integer-- > 0){
            list.add(new HashMap<>().put(integer,200));
        }
        System.out.println(list);
    }

}
