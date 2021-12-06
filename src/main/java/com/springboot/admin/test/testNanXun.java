//package com.springboot.admin.test;
//
//import cn.hutool.http.HttpException;
//import cn.hutool.http.HttpUtil;
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.springboot.admin.common.util.Result;
//import com.zyjc.upms.model.dto.SignLingDTO;
//import lombok.extern.slf4j.Slf4j;
//
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.HashMap;
//
//@Slf4j
//public class testNanXun {
//
//    public static void main(String[] args) {
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
//        Calendar c = Calendar.getInstance();
//        c.setTime(new Date());
//        c.add(Calendar.DAY_OF_MONTH, -1);
//        String dateTime = formatter.format(c.getTime());
//        Result result = testNanXun.onedayStayTimeDistribution(new SignLingDTO("330503", dateTime, "1"));
//        System.out.println(result);
//    }
//
//    public static Result onedayStayTimeDistribution(SignLingDTO signLingDTO){
//        String onedayStayTimeDistributionUrl="http://aladdin.zj.chinamobile.com/swldsj/sys/out/stat/oneday/staydura";
//        HashMap<String,Object> map=new HashMap<>();
//        map.put("areaId",signLingDTO.getAreaId());
//        map.put("dateTime",signLingDTO.getDateTime());
//        map.put("dayType",signLingDTO.getDayType());
//        String reStr = null;
//        try {
//            reStr = HttpUtil.get(onedayStayTimeDistributionUrl, map,5000);
//        }catch (HttpException e) {
//            e.printStackTrace();
//            return Result.fail();
//        }catch (Exception e) {
//            e.printStackTrace();
//            return Result.fail();
//        }
//        JSONObject json = JSON.parseObject(reStr);
//        if (!json.getString("responseCode").equals("0")){
//            log.error("查询失败{}",reStr);
//            return Result.fail("查询失败");
//        }
//        //数据处理>>>>>
//        JSONArray object = json.getJSONArray("responseData");
//        return Result.success(object);
//    }
//
//}
