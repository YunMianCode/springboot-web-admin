
package com.springboot.admin.common.util;

/**
 * 业务异常编码
 *
 * @author guoan
 * @date 2020/11/2
 */
public enum BuzCode {
    /**
     * 0 成功
     */
    SUCCEED(0, "操作成功"),

    /**
     * 9999 失败
     */
    FAILED(-1, "操作失败"),

    DUPLICATE_NAME(5555, "名称已存在"),

    AUTH_FAIL(401, "认证失败"),

    IS_NOT_VALIDATE_PASSWORD(1001, "密码存在安全隐患，需强制修改密码"),
    /**
     * 1*** 用户相关业务异常
     */
    USER_PWD_ERROR(1002, "原密码错误，请重新输入"),

    //新增自定义返回码
    FIELD_VERIFY_ERROR(10001, "字段校验异常"),

    //数据校验异常
    DATA_VERIFY_ERROR(10002,"数据校验异常"),

    //新增自定义返回码
    FILE_VERIFY_ERROR(10003, "字段校验异常");

    /**
     * 业务异常编码
     */
    private int code;

    /**
     * 异常信息
     */
    private String message;

    BuzCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
