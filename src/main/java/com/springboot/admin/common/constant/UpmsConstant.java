package com.springboot.admin.common.constant;

/**
 * @ClassName Constant
 * @Description 系统通用参数
 * @Author yinzx
 * @Date 2020/1/2 14:24
 * @Version 1.0
 **/
public class UpmsConstant {

    /**
     * 安全相关
     */
    public static final String JWT_SIGN_KEY = "iframe";
    /**
     * token请求头名称
     */
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_BEARER = "Bearer ";

    /**
     * 项目redis key前缀
     */
    public static final String REDIS_KEY_PREFIX = "NXWLT:";

    /**
     * 自动生成编码前缀-系统部门
     */
    public final static String SYSTEM_DEPT = "SD_";

    /**
     * 自动生成编码前缀-系统菜单
     */
    public final static String SYSTEM_API = "BA_";

    /**
     * 自动生成编码前缀-系统角色
     */
    public final static String SYSTEM_ROLE = "SR_";

    /**
     * 自动生成编码前缀-系统用户
     */
    public final static String SYSTEM_USER = "SU_";

    /**
     * 自动生成编码前缀-系统版本
     */
    public final static String SYSTEM_VERSION = "SV_";

    /**
     * 自动生成编码前缀-系统租户
     */
    public final static String SYSTEM_TENANCY = "ST_";

    /**
     * 自动生成编码前缀-图书馆
     */
    public final static String LIBRARY_INFO = "LIB_";

    /**
     * 自动生成编码前缀-网吧
     */
    public final static String INTERNET_BAR_INFO = "NET_";

    /**
     * 自动生成编码前缀-文保所
     */
    public final static String CULTURAL_INFO = "CUL_";

    /**
     * 自动生成编码前缀-文化馆
     */
    public final static String CULTURAL_CENTRE_INFO = "CEN_";

    /**
     * 自动生成编码前缀-KTV
     */
    public final static String DANCE_TAINMENT = "DT_";
    /**
     * 自动生成编码前缀-酒店
     */
    public final static String HOTEL_INFO = "HI_";
    /**
     * 自动生成编码前缀-图书馆
     */
    public final static String AGENCY_INFO = "AG_";

    /**
     * 自动生成编码前缀-景区
     */
    public final static String SCENIC_INFO = "SI_";
    /**
     * 自动生成编码前缀-体育馆
     */
    public final static String STADIUM_INFO = "STA_";
    /**
     * 自动生成编码前缀-体育馆
     */
    public final static String TOILET_INFO = "TI_";
    /**
     * 自动生成编码前缀-问题
     */
    public final static String QUESTION_INFO = "QT_";
    /**
     * 自动生成编码前缀-景区村
     */
    public final static String VILLAGE_INFO = "SV_";
    /**
     * 景区编码-景区编码
     */
    public final static String  SCENIC_CODE= "SCENIC_CODE";
    /**
     * 区域编码-南浔域
     */
    public final static String  NAN_XUN_DOMAIN= "330503";
    /**
     * 区域编码-湖州市南浔古镇景区
     */
    public final static String NAN_XUN_AREA = "33050301";
    /**
     * 区域编码-善琏湖笔小镇景区
     */
    public final static String SHANG_LIAN_AREA = "33050302";
    /**
     * 区域编码-石淙蚕意花海景区
     */
    public final static String SHI_ZONG_AREA = "33050303";
    /**
     * 区域编码-福荫童心小镇景区
     */
    public final static String FU_YIN_AREA = "33050304";
    /**
     * 区域编码-港廊古村落景区
     */
    public final static String GANG_LANG_AREA = "33050305";
    /**
     * 区域编码-菱湖古镇景区
     */
    public final static String LING_HU_AREA = "33050306";
    /**
     * 区域编码-获港古村景区
     */
    public final static String DI_GANG_AREA = "33050307";
    /**
     * 区域编码-息塘景区
     */
    public final static String XI_TANG_AREA = "33050308";
    /**
     * 区域编码-民当景区
     */
    public final static String MIN_DANG_AREA = "33050309";
    /**
     * 区域编码-茎步景区
     */
    public final static String SHE_BU_AREA = "33050310";



    public static class CacheKey {
        /**
         * 登录尝试次数
         */
        public static final String ATTEMPTS_FORM = "NXWLT:WEB:ATTEMPTS_%s";

        /**
         * 登录失败锁定的key
         */
        public static final String ATTLOCK_FORM = "NXWLT:WEB:ATTLOCK_%s";

        /**
         * 修改密码原密码错误锁定的key
         */
        public static final String ATT_EDIT_PWD_LOCK_FORM = "NXWLT:WEB:EDITPWDLOCK_%s";

        /**
         * 登录成功的token
         */
        public static final String ACCESS_TOKEN_FORM = "NXWLT:WEB:ACCESS_TOKEN_FORM_%s";

        /**
         * 用户登录权限
         */
        public static final String PERMISSION_USER_API = "NXWLT:WEB:PERMISSION_USER_API_%s";
    }


    /**
     * md5加密前缀
     */
    public static final String PREFIX_MD5 = "YunMian_";

    // 数据库数据状态 -- 有效
    public static final String IS_VALID_YES = "1";

    // 数据库数据状态 -- 无效
    public static final String IS_VALID_NO = "0";

    /**
     * 保存在redis中的弱密码key
     */
    public static final String REDIS_PASS_VERIFY_KEY = "NXWLT:PASSWORD_VERIFY_KEY";

    /**
     * 平台图片验证码
     */
    public static final String REDIS_PICTURE_VALIDATE_CODE = "NXWLT:VISITOR_PICTURE_CODE:";

    /**
     * 图片验证码失效时间 s
     */
    public static final Integer PICTURE_VALIDATE_CODE_EXPIRY_TIME = 120;

    /**
     * 响应成功 {@value}
     */
    public static final Integer SUCCESS_ = 0;

    /**
     * 响应失败 {@value}
     */
    public static final Integer FAIL_ = 1;


    /**
     * 上传文件成功
     */
    public static final String UPLOAD_FILE_SUCCESS = "上传文件成功";

    /**
     * 上传文件失败
     */
    public static final String UPLOAD_FILE_FAIL = "上传文件失败";

    /**
     * 下载文件成功
     */
    public static final String DOWNLOAD_FILE_SUCCESS = "下载文件成功";

    /**
     * 下载文件失败
     */
    public static final String DOWNLOAD_FILE_FAIL = "下载文件失败";

    /**
     * 下载文件不存在
     */
    public static final String DOWNLOAD_FILE_NOT_EXIST = "下载文件不存在";

    /**
     * 上传的文件不能大于10M
     */
    public static final String UPLOAD_FILE_SIZE_LIMIT = "上传文件失败【文件大小不能超过256MB】";


    //最大上传文件的大小
    public static final String MAX_SIZE = "256MB";

    /**
     * 删除文件失败
     */
    public static final String DELETE_FILE_FAIL = "删除文件失败";

    /**
     * 删除文件成功
     */
    public static final String DELETE_FILE_SUCCESS = "删除文件成功";

    /**
     * 缓存过期时间-30分钟
     * {@value}
     */
    public final static int REDIS_TIME_OUT_30MINUTES = 1800;

    /**
     * 缓存过期时间-24小时
     * {@value}
     */
    public final static int REDIS_TIME_OUT_24HOURS = 86400;

    /**
     * 止付业务所属银行字段在数据字典的type
     */
    public final static String BELONGS_BANK_TYPE = "BELONGS_BANK_TYPE";

    /**
     * 数据字典文件表类型
     */
    public final static String BIZ_FILE_TYPE = "BIZ_FILE_TYPE";

    /**
     * 数据字典地址类型
     */
    public final static String COMMUNITY_LEVEL = "COMMUNITY_LEVEL";
    /**
     * 数据字典地址类型(图书馆类型)
     */
    public final static String LIBRARY_TYPE = "LIBRARY_TYPE";

    /**
     * 数据字典事件类型
     */
    public final static String MULTIPLE_EVENT_TYPE = "MULTIPLE_EVENT_TYPE";

    /**
     * 模板目录
     */
    public final static String TEMPLATE_DIRECTORY = "/templates";


    public static class ZZDCacheKey {
        /**
         * 登录成功的token
         */
        public static final String ACCESS_TOKEN_FORM = "NXWLT:ZZD:ACCESS_TOKEN_FORM_%s";

    }


    /**
     * davp获取tookne缓存key
     */
    public final static String DAVP_TOKEN = REDIS_KEY_PREFIX + "DAVP_TOKEN";

    /**
     * 省外客流来源近1周，近1月，近1年；长三角1周占比
     */
    public final static String LATELY_WEAK = REDIS_KEY_PREFIX + "LATELY_WEAK";
    public final static String LATELY_MONTH = REDIS_KEY_PREFIX + "LATELY_MONTH";
    public final static String LATELY_YEAR = REDIS_KEY_PREFIX + "LATELY_YEAR";
    public final static String LATELY_WEAK_CSJ = REDIS_KEY_PREFIX + "LATELY_WEAK_CSJ";

    /**
     * 当日累计客流缓存key
     */
    public final static String TODAY_PASSENGER_FLOW = REDIS_KEY_PREFIX + "TODAY_PASSENGER_FLOW";
    /**
     * 全域实时客流缓存key
     */
    public final static String ALL_DOMAIN_REALTIME_PASSENGER_FLOW = REDIS_KEY_PREFIX + "ALL_DOMAIN_REALTIME_PASSENGER_FLOW";
    /**
     * 十个景区的实时key-
     */
    public final static String NAN_XUN_AREA_REALTIME = REDIS_KEY_PREFIX + "NAN_XUN_AREA_REALTIME";
    /**
     * 十个景区的实时key-
     */
    public final static String SHANG_LIAN_AREA_REALTIME = REDIS_KEY_PREFIX + "SHANG_LIAN_AREA_REALTIME";
    /**
     * 十个景区的实时key-
     */
    public final static String SHI_ZONG_AREA_REALTIME = REDIS_KEY_PREFIX + "SHI_ZONG_AREA_REALTIME";
    /**
     * 十个景区的实时key-
     */
    public final static String FU_YIN_AREA_REALTIME = REDIS_KEY_PREFIX + "FU_YIN_AREA_REALTIME";
    /**
     * 十个景区的实时key-
     */
    public final static String GANG_LANG_AREA_REALTIME = REDIS_KEY_PREFIX + "GANG_LANG_AREA_REALTIME";
    /**
     * 十个景区的实时key-
     */
    public final static String LING_HU_AREA_REALTIME = REDIS_KEY_PREFIX + "LING_HU_AREA_REALTIME";
    /**
     * 十个景区的实时key-
     */
    public final static String DI_GANG_AREA_REALTIME = REDIS_KEY_PREFIX + "DI_GANG_AREA_REALTIME";
    /**
     * 十个景区的实时key-
     */
    public final static String XI_TANG_AREA_REALTIME = REDIS_KEY_PREFIX + "XI_TANG_AREA_REALTIME";
    /**
     * 十个景区的实时key-
     */
    public final static String MIN_DANG_AREA_REALTIME = REDIS_KEY_PREFIX + "MIN_DANG_AREA_REALTIME";
    /**
     * 十个景区的实时key-
     */
    public final static String SHE_BU_AREA_REALTIME = REDIS_KEY_PREFIX + "SHE_BU_AREA_REALTIME";

    /**
     * 十个景区的实时客流统计-10个实时景区和key
     */
    public final static String TEN_SCENIC_REALTIME = REDIS_KEY_PREFIX + "TEN_SCENIC_REALTIME";
    /**
     * 景区实时客流（10个景区和）的key
     */
    public final static String TEN_SCENIC_REALTIME_TOTAL = REDIS_KEY_PREFIX + "TEN_SCENIC_REALTIME_TOTAL";
    /**
     * 景区实时客流整点趋势（10个景区和）的key
     */
    public final static String TEN_SCENIC_REALTIME_TREND = REDIS_KEY_PREFIX + "TEN_SCENIC_REALTIME_TREND";





    /**
     * 十个景区的整点统计-湖州市南浔古镇景区key
     */
    public final static String NAN_XUN_AREA_WHOLE_TIME = REDIS_KEY_PREFIX + NAN_XUN_AREA;
    /**
     * 十个景区的整点统计-善琏湖笔小镇景区key
     */
    public final static String SHANG_LIAN_AREA_WHOLE_TIME = REDIS_KEY_PREFIX + SHANG_LIAN_AREA;
    /**
     * 十个景区的整点统计-石淙蚕意花海景区key
     */
    public final static String SHI_ZONG_AREA_WHOLE_TIME = REDIS_KEY_PREFIX + SHI_ZONG_AREA;
    /**
     * 十个景区的整点统计-福荫童心小镇景区key
     */
    public final static String FU_YIN_AREA_WHOLE_TIME = REDIS_KEY_PREFIX + FU_YIN_AREA;
    /**
     * 十个景区的整点统计-港廊古村落景区key
     */
    public final static String GANG_LANG_AREA_WHOLE_TIME = REDIS_KEY_PREFIX + GANG_LANG_AREA;
    /**
     * 十个景区的整点统计-菱湖古镇景区key
     */
    public final static String LING_HU_AREA_WHOLE_TIME = REDIS_KEY_PREFIX + LING_HU_AREA;
    /**
     * 十个景区的整点统计-获港古村景区key
     */
    public final static String DI_GANG_AREA_WHOLE_TIME = REDIS_KEY_PREFIX + DI_GANG_AREA;
    /**
     * 十个景区的整点统计-息塘景区key
     */
    public final static String XI_TANG_AREA_WHOLE_TIME = REDIS_KEY_PREFIX + XI_TANG_AREA;
    /**
     * 十个景区的整点统计-民当景区key
     */
    public final static String MIN_DANG_AREA_WHOLE_TIME = REDIS_KEY_PREFIX + MIN_DANG_AREA;
    /**
     * 十个景区的整点统计-茎步景区key
     */
    public final static String SHE_BU_AREA_WHOLE_TIME = REDIS_KEY_PREFIX + SHE_BU_AREA;


    /**
     * 当日累计客流缓存key 南浔全域
     */
    public final static String NAN_XUN_DOMAIN_TODAY_FLOW = REDIS_KEY_PREFIX + "NAN_XUN_DOMAIN_TODAY_FLOW";
    /**
     * 当日累计客流缓存key 湖州市南浔古镇景区
     */
    public final static String NAN_XUN_AREA_TODAY_FLOW = REDIS_KEY_PREFIX + "NAN_XUN_AREA_TODAY_FLOW";
    /**
     * 当日累计客流缓存key 善琏湖笔小镇景区
     */
    public final static String SHANG_LIAN_AREA_TODAY_FLOW = REDIS_KEY_PREFIX + "SHANG_LIAN_AREA_TODAY_FLOW";
    /**
     * 当日累计客流缓存key 石淙蚕意花海景区
     */
    public final static String SHI_ZONG_AREA_TODAY_FLOW = REDIS_KEY_PREFIX + "SHI_ZONG_AREA_TODAY_FLOW";
    /**
     * 当日累计客流缓存key 福荫童心小镇景区
     */
    public final static String FU_YIN_AREA_TODAY_FLOW = REDIS_KEY_PREFIX + "FU_YIN_AREA_TODAY_FLOW";
    /**
     * 当日累计客流缓存key 港廊古村落景区
     */
    public final static String GANG_LANG_AREA_TODAY_FLOW = REDIS_KEY_PREFIX + "GANG_LANG_AREA_TODAY_FLOW";
    /**
     * 当日累计客流缓存key 菱湖古镇景区
     */
    public final static String LING_HU_AREA_TODAY_FLOW = REDIS_KEY_PREFIX + "LING_HU_AREA_TODAY_FLOW";
    /**
     * 当日累计客流缓存key 获港古村景区
     */
    public final static String DI_GANG_AREA_TODAY_FLOW = REDIS_KEY_PREFIX + "DI_GANG_AREA_TODAY_FLOW";
    /**
     * 当日累计客流缓存key 息塘景区
     */
    public final static String XI_TANG_AREA_TODAY_FLOW = REDIS_KEY_PREFIX + "XI_TANG_AREA_TODAY_FLOW";
    /**
     * 当日累计客流缓存key 民当景区
     */
    public final static String MIN_DANG_AREA_TODAY_FLOW = REDIS_KEY_PREFIX + "MIN_DANG_AREA_TODAY_FLOW";
    /**
     * 当日累计客流缓存key 茎步景区
     */
    public final static String SHE_BU_AREA_TODAY_FLOW = REDIS_KEY_PREFIX + "SHE_BU_AREA_TODAY_FLOW";


    /**
     * 酒店过夜人数趋势-近一月key
     */
    public final static String STAY_MONITOR_NEARLY_MONTH = REDIS_KEY_PREFIX + "STAY_MONITOR_NEARLY_MONTH";
    /**
     * 酒店过夜人数趋势-近一年key
     */
    public final static String STAY_MONITOR_NEARLY_YEAR = REDIS_KEY_PREFIX + "STAY_MONITOR_NEARLY_YEAR";

    //昨天客流数据前缀
    public final static String YESTERDAY =REDIS_KEY_PREFIX+"YESTERDAY_";

    /**
     * 近七天客流量趋势 passengerFlowTrendByDay
     */
    public final static String PASSENGER_FLOW_TREND_BY_DAY  =REDIS_KEY_PREFIX+"PASSENGER_FLOW_TREND_BY_DAY";

    /**
     * 全域客流wholeDomain
     */
    public final static String WHOLE_DOMAIN  =REDIS_KEY_PREFIX+"WHOLE_DOMAIN";
    /**
     * 十个景区客流量-年-前缀
     */
    public final static String PASSENGER_FLOW_BY_YEAR  =REDIS_KEY_PREFIX+"PASSENGER_FLOW_BY_YEAR_";
    /**
     * 个景区客流量-月-前缀
     */
    public final static String PASSENGER_FLOW_BY_MONTH  =REDIS_KEY_PREFIX+"PASSENGER_FLOW_BY_MONTH_";
    /**
     * 各年累计人流量peopleNumByYear
     */
    public final static String PEOPLE_NUM_BY_YEAR  =REDIS_KEY_PREFIX+"PEOPLE_NUM_BY_YEAR";

    /**
     * 景区客流统计-本年、当月、今天（十个景区）peopleScenicInfo
     *
     */
    public final static String PEOPLE_SCENIC_INFO  =REDIS_KEY_PREFIX+"PEOPLE_SCENIC_INFO";
    /**
     * 导出数据前缀uploadData
     */
    public final static String UPLOAD_DATA  =REDIS_KEY_PREFIX+"UPLOAD_DATA_";

    /**
     * 全域性别分析
     */
    public final static String SEX_RATIO  =REDIS_KEY_PREFIX+"SEX_RATIO";

    /**
     * 全域年龄分析
     */
    public final static String AGE_RATIO  =REDIS_KEY_PREFIX+"AGE_RATIO";

    /**
     * 全域平均逗留时长
     */
    public final static String WHOLE_DOMAIN_STAY_TIME_AVG  =REDIS_KEY_PREFIX+"WHOLE_DOMAIN_STAY_TIME_AVG";
    /**
     * 全域逗留时长分布
     */
    public final static String WHOLE_DOMAIN_STAY_TIME  =REDIS_KEY_PREFIX+"WHOLE_DOMAIN_STAY_TIME";

    /**
     * 景区年龄分布
     */
    public final static String AGE_RATIO_BY_AREA  =REDIS_KEY_PREFIX+"AGE_RATIO_BY_AREA";
    /**
     * 景区性别比例
     */
    public final static String SEX_RATIO_BY_AREA  =REDIS_KEY_PREFIX+"SEX_RATIO_BY_AREA";

    /**
     * 7天性别比例
     */
    public final static String SEX_RATIO_BY_SEVEN_DAY  =REDIS_KEY_PREFIX+"SEX_RATIO_BY_SEVEN_DAY";
    /**
     * 30天性别比例
     */
    public final static String SEX_RATIO_BY_MONTH  =REDIS_KEY_PREFIX+"SEX_RATIO_BY_MONTH";
    /**
     * 一年性别比例
     */
    public final static String SEX_RATIO_BY_YEAR  =REDIS_KEY_PREFIX+"SEX_RATIO_BY_YEAR";

    /**
     * 7天年龄分布
     */
    public final static String AGE_RATIO_BY_SEVEN_DAY  =REDIS_KEY_PREFIX+"AGE_RATIO_BY_SEVEN_DAY";
    /**
     * 30天年龄分布
     */
    public final static String AGE_RATIO_BY_MONTH  =REDIS_KEY_PREFIX+"AGE_RATIO_BY_MONTH";
    /**
     * 一年年龄分布
     */
    public final static String AGE_RATIO_BY_YEAR  =REDIS_KEY_PREFIX+"AGE_RATIO_BY_YEAR";
    // public final static String LATELY_YEAR = REDIS_KEY_PREFIX + "LATELY_YEAR";
    // public final static String LATELY_WEAK_CSJ = REDIS_KEY_PREFIX + "LATELY_WEAK_CSJ";

    /**
     * 南浔浙政钉jsAPi token (1小时失效)
     */
    public final static String NANXUN_ZZD_JSAPI_TOKEN = REDIS_KEY_PREFIX + "NANXUN_ZZD_JSAPI_TOKEN";
}
