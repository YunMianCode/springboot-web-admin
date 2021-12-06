//package com.springboot.admin.common.util;
//
//
//import cn.hutool.http.HttpException;
//import cn.hutool.http.HttpUtil;
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.springboot.admin.model.DTO.SignLingDTO;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.util.HashMap;
//
//@Slf4j
//@Component
//public class SignalingUtil {
//
//    //1.指定区域的接待游客数量（人次）
//    // @Value("${signling.personNumByArea}")
//    private String personNumByArea = "http://aladdin.zj.chinamobile.com/swldsj/sys/out/stat/count";
//    //2.指定区域的游客性别构成
//    // @Value("${signling.visitorGenderConstructionUrl}")
//    private String visitorGenderConstructionUrl="http://aladdin.zj.chinamobile.com/swldsj/sys/out/stat/gender";
//    //3.指定区域的游客年龄构成
//    // @Value("${signling.visitorAgeConstructionUrl}")
//    private String visitorAgeConstructionUrl="http://aladdin.zj.chinamobile.com/swldsj/sys/out/stat/age";
//    //4.指定区域的一日游游客逗留时长分布
//    // @Value("${signling.onedayStayTimeDistributionUrl}")
//    private String onedayStayTimeDistributionUrl="http://aladdin.zj.chinamobile.com/swldsj/sys/out/stat/oneday/staydura";
//    //5.指定区域的一日游（非本地市）游客逗留时长分布
//    // @Value("${signling.onedayStayTimeDistributionUrl}")
//    private String noLocalOnedayStayTimeDistributionUrl="http://aladdin.zj.chinamobile.com/swldsj/sys/out/stat/nonlocal/oneday/staydura";
//    //6.指定区域的一日游（本地市）游客逗留时长分布
//    // @Value("${signling.localOnedayStayTimeDistributionUrl}")
//    private String localOnedayStayTimeDistributionUrl="http://aladdin.zj.chinamobile.com/swldsj/sys/out/stat/local/oneday/staydura";
//    //7.指定区域的过夜游（非本地市）游客逗留天数分布
//    // @Value("${signling.noLocalVisitorOvernightStayDayDistributionUrl}")
//    private String noLocalVisitorOvernightStayDayDistributionUrl="http://aladdin.zj.chinamobile.com/swldsj/sys/out/stat/nonlocal/overnight/staydays";
//    //8.指定区域的过夜游（本地市）游客逗留天数分布
//    // @Value("${signling.localVisitorOvernightStayDayDistributionUrl}")
//    private String localVisitorOvernightStayDayDistributionUrl="http://aladdin.zj.chinamobile.com/swldsj/sys/out/stat/local/overnight/staydays";
//    //9.指定区域的游客平均逗留天（夜）数
//    // @Value("${signling.visitorStayAvgDayUrl}")
//    private String visitorStayAvgDayUrl="http://aladdin.zj.chinamobile.com/swldsj/sys/out/stat/avgdays";
//    //10.指定区域的过夜游客平均逗留天（夜）数
//    // @Value("${signling.visitorOvernightStayAvgDayUrl}")
//    private String visitorOvernightStayAvgDayUrl="http://aladdin.zj.chinamobile.com/swldsj/sys/out/stat/overnight/avgdays";
//    //11.指定区域的省外一日游客来源TOP10
//    // @Value("${signling.oneDayVisitorSourceUrl}")
//    private String oneDayVisitorSourceUrl="http://aladdin.zj.chinamobile.com/swldsj/sys/out/stat/otherProv/oneday/originProv";
//    //12.指定区域的省外过夜游客来源TOP10
//    // @Value("${signling.overnightVisitorSourceUrl}")
//    private String overnightVisitorSourceUrl="http://aladdin.zj.chinamobile.com/swldsj/sys/out/stat/otherProv/overnight/originProv";
//    //13.指定区域的游客热门过夜地分析
//    // @Value("${signling.overnightVisitorAnalysisUrl}")
//    private String overnightVisitorAnalysisUrl="http://aladdin.zj.chinamobile.com/swldsj/sys/out/stat/sleepingSite";
//    //14.指定区域的实时游客数-5分钟
//    // @Value("${signling.realtimeVisitorNumUrl}")
//    private String realtimeVisitorNumUrl="http://aladdin.zj.chinamobile.com/swldsj/sys/out/R/stat/count";
//    //15.指定区域的当日累计游客数-半小时
//    // @Value("${signling.todayVisitorNumUrl}")
//    private String todayVisitorNumUrl="http://aladdin.zj.chinamobile.com/swldsj/sys/out/stat/accum/count";
//    //16.住宿监测-左2-过夜人数趋势曲线接口
//    //@Value
//    private String overnightTrendCurveUrl="http://aladdin.zj.chinamobile.com/swldsj/sys/out/stat/tourType";
//
//    //17.省内客源地信令接口
//    private String touristSourceProvinceUrl="http://aladdin.zj.chinamobile.com/swldsj/sys/out/stat/prov/originCity";
//    // 应用秘钥
//    @Value("${zhezhengding.appSecret}")
//    private String appSecret;
//
//    /**
//     * 1.指定区域的接待游客数量（人次）
//     * @param signLingDTO
//     * @return
//     */
//    public Integer personNumByArea(SignLingDTO signLingDTO){
//        //组装参数
//        HashMap map=new HashMap<String, String>();
//        map.put("areaId",signLingDTO.getAreaId());
//        map.put("dateTime",signLingDTO.getDateTime());
//        map.put("dayType",signLingDTO.getDayType());
//        String result = null;
//        try {
//            result = HttpUtil.get(personNumByArea, map);
//        } catch (HttpException e) {
//            log.error("personNumByArea :{}",e.getMessage());
//            return 0;
//        }catch (Exception e) {
//            e.printStackTrace();
//            return 0;
//        }
//        if(result == null){
//            return  0;
//        }
//
//        JSONObject json = JSON.parseObject(result);
//        if (!json.getString("responseCode").equals("0")){
//            log.error("查询失败{}",result+map);
//            return 0;
//        }
//        JSONObject responseData = (JSONObject) ((JSONArray) json.get("responseData")).get(0);
//        String count = responseData.getString("COUNT");
//        if(StringUtils.isNotBlank(count)){
//            return Integer.parseInt(count);
//        }
//        return 0;
//    }
//
//    /**
//     * 2.指定区域的游客性别构成
//     * @param signLingDTO
//     *
//     * @return
//     */
//    public Result visitorGenderConstruction(SignLingDTO signLingDTO){
//        HashMap<String,Object> map=new HashMap<>();
//        map.put("areaId",signLingDTO.getAreaId());
//        map.put("dateTime",signLingDTO.getDateTime());
//        map.put("dayType",signLingDTO.getDayType());
//        String reStr = null;
//        try {
//            reStr = HttpUtil.get(visitorGenderConstructionUrl, map,1000*10);
//        }catch (HttpException e) {
//            log.error("visitorGenderConstruction :{}",e.getMessage());
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
//        log.info(object+"返回数据"+map);
//        return Result.success(object);
//    }
//    /**3.指定区域的游客年龄构成
//     * @param signLingDTO
//     *
//     * @return
//     */
//    public Result visitorAgeConstruction(SignLingDTO signLingDTO){
//        HashMap<String,Object> map=new HashMap<>();
//        map.put("areaId",signLingDTO.getAreaId());
//        map.put("dateTime",signLingDTO.getDateTime());
//        map.put("dayType",signLingDTO.getDayType());
//        String reStr = null;
//        try {
//            reStr = HttpUtil.get(visitorAgeConstructionUrl, map,1000*10);
//        }catch (HttpException e) {
//            log.error("visitorAgeConstruction : {}",e.getMessage());
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
//    /**
//     * 4.指定区域的一日游游客逗留时长分布
//     * @param signLingDTO
//     *
//     * @return
//     */
//    public Result onedayStayTimeDistribution(SignLingDTO signLingDTO){
//        HashMap<String,Object> map=new HashMap<>();
//        map.put("areaId",signLingDTO.getAreaId());
//        map.put("dateTime",signLingDTO.getDateTime());
//        map.put("dayType",signLingDTO.getDayType());
//        String reStr = null;
//        try {
//            reStr = HttpUtil.get(onedayStayTimeDistributionUrl, map,1000*10);
//        }catch (HttpException e) {
//            log.error("onedayStayTimeDistribution : {}",e.getMessage());
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
//    /**5.指定区域的一日游（非本地市）游客逗留时长分布
//     * @param signLingDTO
//     *
//     * @return
//     */
//    public JSONObject noLocalOnedayStayTimeDistribution(SignLingDTO signLingDTO){
//        HashMap<String,Object> map=new HashMap<>();
//        map.put("areaId",signLingDTO.getAreaId());
//        map.put("dateTime",signLingDTO.getDateTime());
//        map.put("dayType",signLingDTO.getDayType());
//        String reStr = null;
//        try {
//            reStr = HttpUtil.get(noLocalOnedayStayTimeDistributionUrl, map,1000*10);
//        }catch (HttpException e) {
//            log.error("noLocalOnedayStayTimeDistribution : {}",e.getMessage());
//            return JSON.parseObject(reStr);
//        }catch (Exception e) {
//            e.printStackTrace();
//            return JSON.parseObject(reStr);
//        }
//        JSONObject json = JSON.parseObject(reStr);
//        if (!json.getString("responseCode").equals("0")){
//            log.error("查询失败{}",reStr);
//            return json;
//        }
//        //数据处理>>>>>
//        JSONObject object = json.getJSONArray("responseData").getJSONObject(0);
//        return object;
//    }
//    /**
//     * 6.指定区域的一日游（本地市）游客逗留时长分布
//     * @param signLingDTO
//     *
//     * @return
//     */
//    public JSONObject localOnedayStayTimeDistribution(SignLingDTO signLingDTO){
//        HashMap<String,Object> map=new HashMap<>();
//        map.put("areaId",signLingDTO.getAreaId());
//        map.put("dateTime",signLingDTO.getDateTime());
//        map.put("dayType",signLingDTO.getDayType());
//        String reStr = null;
//        try {
//            reStr = HttpUtil.get(localOnedayStayTimeDistributionUrl, map,1000*10);
//        }catch (HttpException e) {
//            log.error("localOnedayStayTimeDistribution : {}",e.getMessage());
//            return JSON.parseObject(reStr);
//        }catch (Exception e) {
//            e.printStackTrace();
//            return JSON.parseObject(reStr);
//        }
//        JSONObject json = JSON.parseObject(reStr);
//        if (!json.getString("responseCode").equals("0")){
//            log.error("查询失败{}",reStr);
//            return json;
//        }
//        //数据处理>>>>>
//        JSONObject object = json.getJSONArray("responseData").getJSONObject(0);
//        return object;
//    }
//    /**7.指定区域的过夜游（非本地市）游客逗留天数分布
//     * @param signLingDTO
//     *
//     * @return
//     */
//    public JSONObject noLocalVisitorOvernightStayDayDistribution(SignLingDTO signLingDTO){
//        HashMap<String,Object> map=new HashMap<>();
//        map.put("areaId",signLingDTO.getAreaId());
//        map.put("dateTime",signLingDTO.getDateTime());
//        map.put("dayType",signLingDTO.getDayType());
//        String reStr = null;
//        try {
//            reStr = HttpUtil.get(noLocalVisitorOvernightStayDayDistributionUrl, map,1000*10);
//        } catch (HttpException e) {
//            log.error("noLocalVisitorOvernightStayDayDistribution : {}",e.getMessage());
//            return JSON.parseObject(reStr);
//        }catch (Exception e) {
//            e.printStackTrace();
//            return JSON.parseObject(reStr);
//        }
//        JSONObject json = JSON.parseObject(reStr);
//        if (!json.getString("responseCode").equals("0")){
//            log.error("查询失败{}",reStr);
//            return json;
//        }
//        //数据处理>>>>>
//        JSONObject object = json.getJSONArray("responseData").getJSONObject(0);
//        return object;
//    }
//
//    /**
//     * 8.指定区域的过夜游（本地市）游客逗留天数分布
//     * @param signLingDTO
//     *
//     * @return
//     */
//    public JSONObject localVisitorOvernightStayDayDistribution(SignLingDTO signLingDTO){
//        HashMap<String,Object> map=new HashMap<>();
//        map.put("areaId",signLingDTO.getAreaId());
//        map.put("dateTime",signLingDTO.getDateTime());
//        map.put("dayType",signLingDTO.getDayType());
//        String reStr = null;
//        try {
//            reStr = HttpUtil.get(localVisitorOvernightStayDayDistributionUrl, map,1000*10);
//        }catch (HttpException e) {
//            log.error("localVisitorOvernightStayDayDistribution : {}",e.getMessage());
//            return JSON.parseObject(reStr);
//        }catch (Exception e) {
//            e.printStackTrace();
//            return JSON.parseObject(reStr);
//        }
//        JSONObject json = JSON.parseObject(reStr);
//        if (!json.getString("responseCode").equals("0")){
//            log.error("查询失败{}",reStr);
//            return json;
//        }
//        //数据处理>>>>>
//        JSONObject object = json.getJSONArray("responseData").getJSONObject(0);
//        return object;
//    }
//
//
//    /**
//     * 9.指定区域的游客平均逗留天（夜）数
//     * @param signLingDTO
//     *
//     * @return
//     */
//    public Integer visitorStayAvgDay(SignLingDTO signLingDTO){
//        HashMap<String,Object> map=new HashMap<>();
//        map.put("areaId",signLingDTO.getAreaId());
//        map.put("dateTime",signLingDTO.getDateTime());
//        map.put("dayType",signLingDTO.getDayType());
//        String reStr = null;
//        try {
//            reStr = HttpUtil.get(visitorStayAvgDayUrl, map,1000*10);
//        } catch (HttpException e) {
//            log.error("visitorStayAvgDay : {}",e.getMessage());
//            return 0;
//        }catch (Exception e) {
//            e.printStackTrace();
//            return 0;
//        }
//        JSONObject json = JSON.parseObject(reStr);
//        if (!json.getString("responseCode").equals("0")){
//            log.error("查询失败{}",reStr);
//            return 0;
//        }
//        //数据处理>>>>>
//        Integer num = json.getJSONArray("responseData").getJSONObject(0).getInteger("NUM");
//        return num;
//    }
//
//    /**
//     * 10.指定区域的过夜游客平均逗留天（夜）数
//     * @param signLingDTO
//     *
//     * @return
//     */
//    public Integer visitorOvernightStayAvgDay(SignLingDTO signLingDTO){
//        HashMap<String,Object> map=new HashMap<>();
//        map.put("areaId",signLingDTO.getAreaId());
//        map.put("dateTime",signLingDTO.getDateTime());
//        map.put("dayType",signLingDTO.getDayType());
//        String reStr = null;
//        try {
//            reStr = HttpUtil.get(visitorOvernightStayAvgDayUrl, map,1000*10);
//        }catch (HttpException e) {
//            log.error("visitorOvernightStayAvgDay : {}",e.getMessage());
//            return 0;
//        }catch (Exception e) {
//            e.printStackTrace();
//            return 0;
//        }
//        JSONObject json = JSON.parseObject(reStr);
//        if (!json.getString("responseCode").equals("0")){
//            log.error("查询失败{}",reStr);
//            return 0;
//        }
//        //数据处理>>>>>
//        Integer num = json.getJSONArray("responseData").getJSONObject(0).getInteger("NUM");
//        return num;
//
//    }
//
//
//
//    /**
//     * 11.指定区域的省外一日游客来源TOP10
//     * @param signLingDTO
//     *
//     * @return
//     */
//    public JSONObject oneDayVisitorSource(SignLingDTO signLingDTO){
//        HashMap<String,Object> map=new HashMap<>();
//        map.put("areaId",signLingDTO.getAreaId());
//        map.put("dateTime",signLingDTO.getDateTime());
//        map.put("dayType",signLingDTO.getDayType());
//        String reStr = null;
//        try {
//            reStr = HttpUtil.get(oneDayVisitorSourceUrl, map,1000*10);
//        } catch (HttpException e) {
//            log.error("oneDayVisitorSource : {}",e.getMessage());
//            return JSON.parseObject(reStr);
//        }catch (Exception e) {
//            e.printStackTrace();
//            return JSON.parseObject(reStr);
//        }
//        JSONObject json = JSON.parseObject(reStr);
//        if (!json.getString("responseCode").equals("0")){
//            log.warn("省外一日游客来源-查询失败{}",reStr);
//            return json;
//        }
//        log.info("省外一日游客来源:{}",reStr);
//        //数据处理>>>>>
//        return json;
//    }
//
//    /**
//     * 12.指定区域的省外过夜游客来源TOP10
//     * @param signLingDTO
//     *
//     * @return
//     */
//    public JSONObject overnightVisitorSource(SignLingDTO signLingDTO){
//        HashMap<String,Object> map=new HashMap<>();
//        map.put("areaId",signLingDTO.getAreaId());
//        map.put("dateTime",signLingDTO.getDateTime());
//        map.put("dayType",signLingDTO.getDayType());
//        String reStr = HttpUtil.get(overnightVisitorSourceUrl, map,1000*10);
//        JSONObject json = null;
//        try {
//            json = JSON.parseObject(reStr);
//        } catch (HttpException e) {
//            log.error("overnightVisitorSource : {}",e.getMessage());
//            return JSON.parseObject(reStr);
//        }catch (Exception e) {
//            e.printStackTrace();
//            return JSON.parseObject(reStr);
//        }
//        if (!json.getString("responseCode").equals("0")){
//            log.warn("省外过夜游客来源-查询失败 {}",reStr);
//            return json;
//        }
//        log.info("省外过夜游客来源:{}",reStr);
//        //数据处理>>>>>
//        return json;
//    }
//
//    /**
//     * 13.指定区域的游客热门过夜地分析
//     * @param signLingDTO
//     *
//     * @return
//     */
//    public JSONObject overnightVisitorAnalysis(SignLingDTO signLingDTO){
//        HashMap<String,Object> map=new HashMap<>();
//        map.put("areaId",signLingDTO.getAreaId());
//        map.put("dateTime",signLingDTO.getDateTime());
//        map.put("dayType",signLingDTO.getDayType());
//        String reStr = null;
//        try {
//            reStr = HttpUtil.get(overnightVisitorAnalysisUrl, map,1000*10);
//        }catch (HttpException e) {
//            log.error("overnightVisitorAnalysis : {}",e.getMessage());
//            return JSON.parseObject(reStr);
//        }catch (Exception e) {
//            e.printStackTrace();
//            return JSON.parseObject(reStr);
//        }
//        JSONObject json = JSON.parseObject(reStr);
//        if (!json.getString("responseCode").equals("0")){
//            log.error("查询失败{}",reStr);
//            return json;
//        }
//        //数据处理>>>>>
//        JSONObject object = json.getJSONArray("responseData").getJSONObject(0);
//        return object;
//    }
//    /**
//     * 14.	指定区域的实时游客数-5分钟
//     * @param areaId
//     *
//     * @return
//     */
//    public Integer realtimeVisitorNum(String areaId){
//        HashMap<String,Object> map=new HashMap<>();
//        map.put("areaId",areaId);
//        String reStr = null;
//        try {
//            reStr = HttpUtil.get(realtimeVisitorNumUrl, map);
//        }catch (HttpException e) {
//            log.error("realtimeVisitorNum : {}",e.getMessage());
//            return 0;
//        }catch (Exception e) {
//            e.printStackTrace();
//            return 0;
//        }
//        JSONObject json = JSON.parseObject(reStr);
//        if (!json.getString("responseCode").equals("0")){
//            log.error("查询失败{}",reStr);
//            return 0;
//        }
//        //数据处理>>>>>
//        Integer num = json.getJSONArray("responseData").getJSONObject(0).getInteger("NUM");
//        log.info("景区{}实时{}客流数{}", areaId, com.zyjc.base.common.util.DateUtil.getCurrentHourMinuteTime(), num);
//        return num;
//    }
//    /**
//     * 15.指定区域的当日累计游客数-半小时
//     * @param areaId
//     *
//     * @return
//     */
//    public Integer todayVisitorNum(String areaId){
//        HashMap<String,Object> map=new HashMap<>();
//        map.put("areaId",areaId);
//        String reStr = null;
//        try {
//            reStr = HttpUtil.get(todayVisitorNumUrl, map);
//        }catch (HttpException e) {
//            log.error("todayVisitorNum : {}",e.getMessage());
//            return 0;
//        }catch (Exception e) {
//            e.printStackTrace();
//            return 0;
//        }
//        JSONObject json = JSON.parseObject(reStr);
//        if (!json.getString("responseCode").equals("0")){
//            log.error("查询失败{}",reStr);
//            return 0;
//        }
//        //数据处理>>>>>
//        Integer num = json.getJSONArray("responseData").getJSONObject(0).getInteger("NUM");
//        return num;
//    }
//
//    /**
//     * 16.过夜人数趋势
//     * @param
//     *
//     * @return
//     */
//    public JSONObject overnightTrendCurve(SignLingDTO signLingDTO){
//        HashMap<String,Object> map=new HashMap<>();
//        map.put("areaId",signLingDTO.getAreaId());
//        map.put("dateTime",signLingDTO.getDateTime());
//        map.put("dayType",signLingDTO.getDayType());
//        String reStr = null;
//        try {
//            reStr = HttpUtil.get(overnightTrendCurveUrl, map,1000*10);
//        } catch (HttpException e) {
//            log.error("overnightTrendCurve : {}",e.getMessage());
//            return JSON.parseObject(reStr);
//        }catch (Exception e) {
//            e.printStackTrace();
//            return JSON.parseObject(reStr);
//        }
//        JSONObject json = JSON.parseObject(reStr);
//        if (!json.getString("responseCode").equals("0")){
//            log.error("查询失败{}",reStr);
//            return json;
//        }
//        log.info("返回结果： {}",reStr);
//        //数据处理>>>>>
//
//        return json;
//    }
//
//
//    /**?areaId=330503&provId=33&dayType=4&dateTime=202109
//     * 17.省内游客客源地
//     */
//    public JSONObject touristSourceProvince(SignLingDTO signLingDTO){
//        HashMap<String,Object> map=new HashMap<>();
//        map.put("areaId",signLingDTO.getAreaId());
//        map.put("provId","33");
//        map.put("dayType",signLingDTO.getDayType());
//        map.put("dateTime",signLingDTO.getDateTime());
//        String reStr = null;
//        try {
//            reStr = HttpUtil.get(touristSourceProvinceUrl, map,1000*10);
//        }catch (HttpException e) {
//            log.error("touristSourceProvince : {}",e.getMessage());
//            return JSON.parseObject(reStr);
//        }catch (Exception e) {
//            e.printStackTrace();
//            return JSON.parseObject(reStr);
//        }
//        JSONObject json = JSON.parseObject(reStr);
//        if (!json.getString("responseCode").equals("0")){
//            log.error("查询失败{}",reStr);
//            return json;
//        }
//        log.info("返回结果： {}",reStr);
//        //数据处理>>>>>
//        return json;
//    }
//
//    /**
//     * 指定区域的当日累计游客数-半小时
//     * @param signLingDTO
//     * @return
//     */
//    public Integer personNumToday(SignLingDTO signLingDTO){
//        //组装参数
//        HashMap map=new HashMap<String, String>();
//        map.put("areaId",signLingDTO.getAreaId());
//        String result = null;
//        try {
//            result = HttpUtil.get(todayVisitorNumUrl, map);
//        }catch (HttpException e) {
//            log.error("personNumToday : {}",e.getMessage());
//            return 0;
//        }catch (Exception e) {
//            e.printStackTrace();
//            return 0;
//        }
//        if(result == null){
//            return  0;
//        }
//        JSONObject json = JSON.parseObject(result);
//        if (!json.getString("responseCode").equals("0")){
//            log.info("查询失败{}",result);
//            return 0;
//        }
//        JSONObject responseData = (JSONObject) ((JSONArray) json.get("responseData")).get(0);
//        String count = responseData.getString("NUM");
//        if(StringUtils.isNotBlank(count)){
//            return Integer.parseInt(count);
//        }
//        return 0;
//    }
//
//}
