package com.springboot.admin.xxl;

import com.springboot.admin.service.UserService;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Slf4j
public class xxlOfUserCount {

    static int count = 0;

    @Resource
    private UserService userService;

    @Resource
    StringRedisTemplate stringRedisTemplate;


    @XxlJob("myXXLOfUserCount")
    public void myXXLOfUserCount() throws Exception {
        int userCounts = userService.getCounts();
        log.info("当前MySQL数据库中用户数量---{}---",userCounts);
        stringRedisTemplate.opsForValue().set("USER_COUNTS",String.valueOf(userCounts));

    }

}
