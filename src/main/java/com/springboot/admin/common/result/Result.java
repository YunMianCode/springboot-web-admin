package com.springboot.admin.common.result;

import com.springboot.admin.common.util.BuzCode;
import lombok.Data;

import java.io.Serializable;

/**
 * 统一返回值
 */
@Data
public class Result implements Serializable {
    /**
     * 返回码
     */
    private int code = BuzCode.SUCCEED.getCode();

    /**
     * 返回信息
     */
    private String message = BuzCode.SUCCEED.getMessage();

    /**
     * 返回数据
     */
    private Object data;

    public static Result success() {
        return new Result();
    }

    public static Result success(Object data) {
        return new Result(BuzCode.SUCCEED.getCode(), BuzCode.SUCCEED.getMessage(), data);
    }

    public static Result fail(String message) {
        return new Result(BuzCode.FAILED.getCode(), message);
    }

    public static Result fail() {
        return new Result(BuzCode.FAILED.getCode(), BuzCode.FAILED.getMessage());
    }

    public static Result duplicateName() {
        return new Result(BuzCode.DUPLICATE_NAME.getCode(), BuzCode.DUPLICATE_NAME.getMessage());
    }

    public static Result operate(boolean isSucceed) {
        return isSucceed ? success() : fail();
    }

    public static Result of(int code, String message, Object data){
        return new Result(code,message,data);
    }

    /**
     * 接口字段为空时返回的错误编码
     *
     * @param message
     * @return
     */
    public static Result fieldVerifyFail(String message) {
        return new Result(BuzCode.FIELD_VERIFY_ERROR.getCode(), message);
    }

    /**
     * 文件校验错误
     *
     * @param message
     * @return
     */
    public static Result fileVerifyFail(String message) {
        return new Result(BuzCode.FILE_VERIFY_ERROR.getCode(), message);
    }

    /**
     * 数据校验异常
     *
     * @param message 错误信息
     * @return
     */
    public static Result dataVerifyFail(String message) {
        return new Result(BuzCode.DATA_VERIFY_ERROR.getCode(), message);
    }

    public Result() {
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
