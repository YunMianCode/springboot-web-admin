package com.springboot.admin.common.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 返回前台数据封装
 *
 * @author zhangshichang
 * @date 2019-01-05 11:33
 */
@ApiModel("服务端返回数据结果封装")
public class CommonResult<T> {

    /**
     * 状态码<br/>
     * 200-请求成功<br/>
     * 400-请求失败<br/>
     * 500-服务器内部错误<br/>
     */
    @ApiModelProperty("code: 200->请求成功, 400->请求失败:一般为参数格式错误, 500->服务器错误")
    private Integer code;
    /**
     * 返回成功或者失败的消息
     */
    @ApiModelProperty("返回成功或者失败的消息")
    private String msg;
    /**
     * JSON数据
     */
    @ApiModelProperty("返回JSON格式数据")
    private T data;

    /**
     * 有结果数据返回
     *
     * @param code 状态码
     * @param msg  消息
     * @param data JSON数据
     */
    public CommonResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 无数据返回
     *
     * @param code 状态码
     * @param msg  消息
     */
    public CommonResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CommonResult() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
