//package com.springboot.admin.common.util;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.springboot.admin.common.constant.UpmsConstant;
//import com.springboot.admin.model.DTO.SignLingDTO;
//import com.springboot.admin.model.VO.PassengerFlowTrendVO;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Component;
//
//import java.math.BigDecimal;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//
//@Slf4j
//@Component
//public class TouristsPortraitUtil {
//
//    @Autowired
//    SignalingUtil signalingUtil;
//    @Autowired
//    private RedisTemplate redisTemplate;
//
//    static final int year = Calendar.getInstance().get(Calendar.YEAR);
//    static final int month = new Date().getMonth() + 1;
//    static final int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
//    static final String areaId = "33050301,33050302,33050303,33050304,33050305,33050306,33050307,33050308,33050309,33050310";
//
//
//    /**
//     * 全域旅游逗留时长
//     *
//     * @return
//     */
//    public Result wholeDomainStayTime() {
//        HashMap<String, Object> dataMap = new HashMap<>();
//        int sum = 0;
//        double sumTim = 0;
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
//        Calendar c = Calendar.getInstance();
//        c.setTime(new Date());
//        c.add(Calendar.DAY_OF_MONTH, -1);
//        int nowMonth = c.getTime().getMonth() + 1;
//        for (; nowMonth == month; ) {
//            String dateTime = formatter.format(c.getTime());
//            Result result = signalingUtil.onedayStayTimeDistribution(new SignLingDTO("330503", dateTime, "1"));
//            c.add(Calendar.DAY_OF_MONTH, -1);
//            nowMonth = c.getTime().getMonth() + 1;
//            if (result.getCode() == 0) {
//                JSONArray data = (JSONArray) result.getData();
//                ;
//                for (Object o : data) {
//                    JSONObject obj = (JSONObject) JSON.toJSON(o);
//                    //String name = (String) obj.get("ZB_KEY");
//                    String[] split = editName(obj, sumTim).split(",");
//                    String name = split[0];
//                    if (!"时长不详".equals(name)) {
//                        sumTim = new Double(split[1]);
//                        int num = (int) obj.get("ZB_VALUE");
//                        sum += num;
//                        Integer integer = (Integer) dataMap.get(name);
//                        if (integer == null) {
//                            dataMap.put(name, num);
//                        } else {
//                            dataMap.put(name, integer + num);
//                        }
//                    }
//                }
//
//            }
//
//        }
//        List<PassengerFlowTrendVO> result = new ArrayList<>();
//        PassengerFlowTrendVO passengerFlowTrendVO = new PassengerFlowTrendVO();
//        for (String key : dataMap.keySet()) {
//            passengerFlowTrendVO = new PassengerFlowTrendVO();
//            Integer integer = (Integer) dataMap.get(key);
//            double f1 = new BigDecimal((float) integer / sum * 100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//            dataMap.put(key, f1);
//            passengerFlowTrendVO.setName(key);
//            passengerFlowTrendVO.setSeqGrowthRate(f1 + "");
//            result.add(passengerFlowTrendVO);
//        }
//
//        //全域平均逗留时长
//        double f1 = new BigDecimal(sumTim / sum).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
//        HashMap<String, Object> dataAvg = new HashMap<>();
//        dataAvg.put("平均逗留时长", f1);
//        List<HashMap<String, Object>> dataAvgs = new ArrayList<>();
//        dataAvgs.add(dataAvg);
//        redisTemplate.opsForValue().set(UpmsConstant.WHOLE_DOMAIN_STAY_TIME_AVG, dataAvgs);
//        redisTemplate.opsForValue().set(UpmsConstant.WHOLE_DOMAIN_STAY_TIME, result);
//        return Result.success(result);
//    }
//
//
//    /**
//     * 名字合并
//     *
//     * @param
//     *
//     * @return
//     */
//    public String editName(JSONObject obj, double sumTime) {
//        Map<String, Double> result = new HashMap<>();
//        String name = (String) obj.get("ZB_KEY");
//        int num = (int) obj.get("ZB_VALUE");
//        if ("6-6.5h".equals(name)) {
//            sumTime += num * 6.25;
//            return "8小时以下," + sumTime;
//        } else if ("6.5-7h".equals(name)) {
//            sumTime += num * 6.75;
//            return "8小时以下," + sumTime;
//        } else if ("7-7.5h".equals(name)) {
//            sumTime += num * 7.25;
//            return "8小时以下," + sumTime;
//        } else if ("7.5-8h".equals(name)) {
//            sumTime += num * 7.75;
//            return "10个小时," + sumTime;
//        } else if ("8-8.5h".equals(name)) {
//            sumTime += num * 8.25;
//            return "10个小时," + sumTime;
//        } else if ("8.5-9h".equals(name)) {
//            sumTime += num * 8.75;
//            return "10个小时," + sumTime;
//        } else if ("9-9.5h".equals(name)) {
//            sumTime += num * 9.25;
//            return "10个小时," + sumTime;
//        } else if ("9.5-10h".equals(name)) {
//            sumTime += num * 9.75;
//            return "10个小时," + sumTime;
//        } else if ("10-10.5h".equals(name)) {
//            sumTime += num * 10.25;
//            return "12个小时," + sumTime;
//        } else if ("10.5-11h".equals(name)) {
//            sumTime += num * 10.75;
//            return "12个小时," + sumTime;
//        } else if ("11-11.5h".equals(name)) {
//            sumTime += num * 11.25;
//            return "12个小时," + sumTime;
//        } else if ("11.5-12h".equals(name)) {
//            sumTime += num * 11.75;
//            return "12个小时," + sumTime;
//        } else if ("12-12.5h".equals(name)) {
//            sumTime += num * 12.25;
//            return "14个小时," + sumTime;
//        } else if ("12.5-13h".equals(name)) {
//            sumTime += num * 12.75;
//            return "14个小时," + sumTime;
//        } else if ("13-13.5h".equals(name)) {
//            sumTime += num * 13.25;
//            return "14个小时," + sumTime;
//        } else if ("13.5-14h".equals(name)) {
//            sumTime += num * 13.75;
//            return "14个小时," + sumTime;
//        } else if ("14-14.5h".equals(name)) {
//            sumTime += num * 14.25;
//            return "16个小时," + sumTime;
//        } else if ("14.5-15h".equals(name)) {
//            sumTime += num * 14.75;
//            return "16个小时," + sumTime;
//        } else if ("15-15.5h".equals(name)) {
//            sumTime += num * 15.25;
//            return "16个小时," + sumTime;
//        } else if ("15.5-16h".equals(name)) {
//            sumTime += num * 15.75;
//            return "16个小时," + sumTime;
//        } else if ("16-16.5h".equals(name)) {
//            sumTime += num * 16.25;
//            return "16个小时以上," + sumTime;
//        } else if ("16.5-71h".equals(name)) {
//            sumTime += num * 16.75;
//            return "16个小时以上," + sumTime;
//        } else if ("17-17.5h".equals(name)) {
//            sumTime += num * 17.25;
//            return "16个小时以上," + sumTime;
//        } else if ("17.5-18h".equals(name)) {
//            sumTime += num * 17.75;
//            return "16个小时以上," + sumTime;
//        } else if ("18-18.5h".equals(name)) {
//            sumTime += num * 18.25;
//            return "16个小时以上," + sumTime;
//        } else if ("18.5-19h".equals(name)) {
//            sumTime += num * 18.75;
//            return "16个小时以上," + sumTime;
//        } else if ("19-19.5h".equals(name)) {
//            sumTime += num * 19.25;
//            return "16个小时以上," + sumTime;
//        } else if ("19.5-20h".equals(name)) {
//            sumTime += num * 19.75;
//            return "16个小时以上," + sumTime;
//        }
//        return "时长不详";
//    }
//
//
//}
