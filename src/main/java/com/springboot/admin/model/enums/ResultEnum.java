package com.springboot.admin.model.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 返回结果枚举
 *
 * @author zhangshichang
 * @date 2019-01-05 11:39
 */
@Getter
@AllArgsConstructor
public enum ResultEnum {
    /**
     * 成功
     */
    SUCCESS(200, "操作成功"),
    /**
     * 错误
     */
    ERROR(500, "服务器内部错误"),
    /**
     * SSO 登录失败
     */
    SSO_UN_LOGIN(401, "未登录，请登录后重试。"),
    /**
     * 保存失败
     */
    SAVE_FAIL(400, "保存失败"),
    REQUEST_TOO_FAST(400, "小主人, 您操作太快啦~~"),
    SAVE_FAIL_NOT_EXIST(400, "保存失败，该数据可能已被删除"),
    PWD_PATTERN_ERROR(400, "密码长度为8~16位，包括至少1个大写字母，1个小写字母，1个数字，且连续3位不重复也不连续"),
    CANNOT_CHANGE_PERMISSION(400, "不能修改自身权限"),
    /**
     * 删除失败
     */
    DELETE_FAIL(400, "删除失败"),
    /**
     * 删除失败
     */
    DELETE_FAIL_NOT_EXIST(400, "删除失败，该数据可能已被删除"),
    /**
     * 编辑失败
     */
    EDIT_FAIL(400, "编辑失败"),
    /**
     * 编辑失败
     */
    EDIT_FAIL_NOT_EXIST(400, "编辑失败，该数据可能已被删除"),
    /**
     * 免疫卡号已存在
     */
    IMMUNE_NUMBER_IS_EXIST(400, "免疫卡号已存在"),
    /**
     * 免疫卡号不存在
     */
    IMMUNE_NUMBER_NOT_EXIST(400, "免疫卡号不存在"),
    /**
     * 犬牌编号已发放给其他犬
     */
    DOG_TAG_NOT_PROVIDE(400, "犬牌编号已发放给其他犬"),
    /**
     * 犬牌编号已存在
     */
    DOG_TAG_IS_EXIST(400, "犬牌编号已存在"),
    /**
     * 犬牌编号有误
     */
    DOG_TAG_IMMUNE_ERROR(400, "犬牌编号或免疫卡号不存在"),
    /**
     * 芯片号不存在
     */
    DOG_TAG_CHIPNUMBER_NOT(400, "芯片号不存在"),
    /**
     * 芯片号已分配
     */
    DOG_TAG_CHIPNUMBER_NOT_PROVIDE(400, "芯片号已分配"),
    /**
     * 没有该犬牌编号
     */
    DOG_TAG_IMMUNE_NOT(400, "犬牌编号不存在"),
    /**
     * 犬牌号已分配
     */
    DOG_TAG_IMMUNE_NOT_PROVIDE(400, "犬牌号已分配"),
    /**
     * 犬只不存在
     */
    DOG_NOT_EXIST(400, "犬只不存在"),
    /**
     * 执法点名称已存在
     */
    ENFORCEMENT_POINT_NAME_IS_EXIST(400, "执法点名称已存在"),
    /**
     * 文件为空
     */
    FILE_ISNULL(400, "文件为空"),
    /**
     * 图片过大
     */
    FILE_MAX(400, "图片最大为10M"),
    /**
     * 不是图片文件
     */
    FILE_NOT_IMAGE(400, "不是图片文件"),
    /**
     * 图片解析失败
     */
    FILE_FAIL(400, "图片解析失败"),
    /**
     * 参数错误
     */
    PARAM_ERROR(400, "参数错误"),
    /**
     * 上传图片失败
     */
    UPLOAD_FILE_FAIL(400, "上传文件失败"),
    /**
     * 上传图片失败
     */
    UPLOAD_IMG_FAIL(400, "上传图片失败"),
    /**
     * 图片格式错误
     */
    UPLOAD_IMG_TYPE_FAIL(400, "图片格式错误"),
    /**
     * 图片大小限制为500KB
     */
    FILE_IMG_SIZE(400, "图片最大为500KB"),
    /**
     * 密码错误
     */
    PASSWORD_ERROR(400, "密码错误"),
    /**
     * 用户不存在
     */
    USER_NOT_EXIST(400, "账号或密码有误"),
    /**
     * 查询数据为空
     */
    QUERY_NULL(400, "查询数据为空"),
    /**
     * 查询失败
     */
    QUERY_ERROR(400, "查询失败"),
    /**
     * 数据已存在
     */
    NOT_NULL(400, "数据已存在"),
    /**
     * 验证码错误
     */
    VERIFICATION_CODE_ERROR(400, "验证码错误"),

    /**
     * 批量删除失败
     */
    BATCH_DELETION_FAIL(400, "批量删除失败"),
    /**
     * 数据已存在
     */
    DATA_ALREADY_EXISTS(400, "数据已存在"),
    /**
     * 数据不存在
     */
    DATA_DOES_NOT_EXIST(400, "数据不存在"),
    /**
     * 证件号码不能为空
     */
    DATA_CARD_NUMBER_BLANK_NON_ALLOWED(400, "证件号码不能为空"),
    DATA_CARD_NUMBER_FORMAT_ERROR(400, "证件号码格式错误"),
    /**
     * 数据来自其他平台/通道/系统处理
     */
    UNABLE_TO_UPDATE_DATA_FORM_OTHER_CHANNEL(400, "数据来源于其他平台, 不允许编辑"),
    UNABLE_TO_DELETE_DATA_FORM_OTHER_CHANNEL(400, "数据来源于其他平台, 不允许删除"),
    /**
     * 电话号码已经注册
     */
    PHONE_IS_EXIST(400, "手机号已被使用"),
    /**
     * 微信登录失败
     */
    WX_LOGIN_FAIL(400, "微信登录失败"),
    /**
     * 修改手机号码失败
     */
    MODIFY_MOBILE_NUMBER_FAIL(400, "修改手机号码失败"),

    /**
     * 导出失败
     */
    EXPORT_FAIL(400, "导出失败"),

    DOWNLOAD_TEMPLATE_FAIL(400, "下载模板失败"),

    /**
     * 导入失败
     */
    IMPORT_FAIL(400, "导入失败"),
    /**
     * Excel数据为空
     */
    EXCEL_IS_EMPTY(400, "Excel数据为空或格式错误"),
    /**
     * 图片类型不支持
     */
    IMAGE_TYPE_NOT_SUPPORT(400, "图片格式不支持"),
    FILE_TYPE_NOT_SUPPORT(400, "文件格式不支持"),
    /**
     * 视频类型不支持
     */
    VIDEO_TYPE_NOT_SUPPORT(400, "视频格式不支持"),
    /**
     * 单张图片大小不能超过xM
     */
    IMAGE_SIZE_OVER_LIMIT(400, "上传图片过大"),
    /**
     * 单个视频大小不能超过50M
     */
    VIDEO_SIZE_OVER_LIMIT(400, "单个视频大小不能超过50M"),
    /**
     * 图片压缩失败
     */
    IMAGE_REDUCE_FILE(400, "图片压缩失败"),

    /**
     * 省市区街道地址解析出错
     */
    ADDRESS_CORD_ERROR(400, "省市区街道地址解析出错"),

    /**
     * areaId参数异常，上送地址不符合规范
     */
    ADDRESS_ARG_ILLEGAL_AREA_ID(400, "areaId参数异常，上送地址不符合规范"),

    /**
     * 当前状态无法操作
     */
    UNABLE_OPERATE_STATUS(400, "当前状态无法操作"),
    /**
     * elementAddress数据异常，上送地址不符合规范
     */
    ADDRESS_INVALID(400, "elementAddress数据异常，上送地址不符合规范"),
    /**
     * elementAddress数据异常，上送地址不符合规范
     */
    NAVIGATION_TYPE_INVALID(400, "犬只类型或者投诉类型非法，请检查"),

    /**
     * 消息发送异常
     */
    MESSAGE_SEND_ERROR(400, "消息发送异常");

    /**
     * 状态码
     *
     * @see
     */
    private Integer code;

    /**
     * 失败消息
     *
     * @see ResultEnum
     */
    private String message;

}
