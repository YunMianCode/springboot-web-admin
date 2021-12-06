//package com.springboot.admin.controller;
//
//import com.springboot.admin.common.constant.UpmsConstant;
//import com.springboot.admin.common.util.Result;
//import com.springboot.admin.common.util.TouristsPortraitUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//
//@RestController
//@RequestMapping("touristsPortrait")
//@Slf4j
//@CrossOrigin
//public class TouristsPortraitController {
//    @Autowired
//    TouristsPortraitUtil touristsPortraitUtil;
//    @Autowired
//    private RedisTemplate redisTemplate;
////    @Autowired
////    private BizProvinceTouristSourceService bizProvinceTouristSourceService;
////    @Autowired
////    private BizCityTouristSourceService bizCityTouristSourceService;
//
//    @PostMapping("wholeDomainStayTime")
//    public Result wholeDomainStayTime() {
//        Object o = redisTemplate.opsForValue().get(UpmsConstant.WHOLE_DOMAIN_STAY_TIME);
//        if (o == null) {
//            Result result = touristsPortraitUtil.wholeDomainStayTime();
//            return result;
//        }
//        ArrayList list = (ArrayList) o;
//        return Result.success(list);
//    }
//
//}
