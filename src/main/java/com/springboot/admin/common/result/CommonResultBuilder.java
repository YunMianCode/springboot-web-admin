package com.springboot.admin.common.result;

import com.springboot.admin.model.enums.ResultEnum;
import io.swagger.annotations.ApiModel;
import org.springframework.http.HttpStatus;

/**
 * 返回JSON数据封装工具类
 *
 * @author zhangshichang
 * @date 2019-01-05 11:37
 */
@ApiModel("返回JSON数据封装工具类")
public class CommonResultBuilder {

    /**
     * 成功并且有数据返回调用
     *
     * @param t 返回JSON对象
     * @return CommonResult
     */
    public static <T> CommonResult<T> success(T t) {
        CommonResult<T> results = new CommonResult<>();
        results.setCode(ResultEnum.SUCCESS.getCode());
        results.setMsg(ResultEnum.SUCCESS.getMessage());
        results.setData(t);
        return results;
    }

    /**
     * 成功并且没有数据返回调用,
     * 用于新增、删除、编辑
     *
     * @return CommonResult
     */
    public static CommonResult success() {
        return new CommonResult(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage());
    }

    /**
     * 失败返回 返回消息为枚举类中的信息
     *
     * @param resultEnum 枚举结果
     * @return CommonResult
     * @see ResultEnum
     */
    public static <T> CommonResult<T> fail(ResultEnum resultEnum) {
        CommonResult<T> results = new CommonResult<>();
        results.setCode(resultEnum.getCode());
        results.setMsg(resultEnum.getMessage());
        return results;
    }

    /**
     * 参数错误
     *
     * @param msg 参数错误返回的信息
     * @return CommonResult
     * @author zhangshichang
     * @date 19-2-28 下午2:27
     * @see HttpStatus#BAD_REQUEST
     */
    public static CommonResult parameterError(String msg) {
        CommonResult results = new CommonResult();
        results.setCode(HttpStatus.BAD_REQUEST.value());
        results.setMsg(msg);
        return results;
    }

    /**
     * 请求接口失败
     *
     * @param msg 参数错误返回的信息
     * @return CommonResult
     * @author zhangshichang
     * @date 19-2-28 下午2:27
     * @see HttpStatus#BAD_REQUEST
     */
    public static CommonResult requestFail(String msg) {
        CommonResult results = new CommonResult();
        results.setCode(HttpStatus.BAD_REQUEST.value());
        results.setMsg(msg);
        return results;
    }


    /**
     * 全局异常拦截 返回的错误消息
     *
     * @param msg 错误消息
     * @return CommonResult
     * @see ResultEnum
     * @see HttpStatus
     */
    public static CommonResult<Object> serverError(String msg) {
        CommonResult<Object> results = new CommonResult<>();
        results.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        results.setMsg(msg);
        results.setData("错误信息请看msg");
        return results;
    }

    /**
     * 未授权时调用--403
     *
     * @return CommonResult
     * @author zhangshichang
     * @date 19-4-18 下午2:31
     */
    public static CommonResult<Object> forbidden() {
        CommonResult<Object> results = new CommonResult<>();
        results.setCode(HttpStatus.FORBIDDEN.value());
        results.setMsg("没有相关权限");
        return results;
    }

    /**
     * 未登录时调用--401
     *
     * @return CommonResult
     * @author zhangshichang
     * @date 19-4-18 下午2:31
     */
    public static CommonResult<Object> unauthorized() {
        CommonResult<Object> results = new CommonResult<>();
        results.setCode(HttpStatus.UNAUTHORIZED.value());
        results.setMsg("未登录，请登录后重试。");
        return results;
    }

    /**
     * 密码验证不通过时调用
     *
     * @param message 消息
     * @return CommonResult
     * @author zhangshichang
     * @date 19-4-20 上午10:50
     */
    public static CommonResult badCredentials(String message) {
        CommonResult<Object> results = new CommonResult<>();
        results.setCode(HttpStatus.BAD_REQUEST.value());
        results.setMsg(message);
        results.setData(null);
        return results;
    }

    public static CommonResult TemporaryMoved(String message) {
        CommonResult<Object> results = new CommonResult<>();
        results.setCode(HttpStatus.FOUND.value());
        results.setMsg(message);
        results.setData(null);
        return results;
    }

    public static CommonResult requestNotFoundError(String msg) {
        CommonResult results = new CommonResult();
        results.setCode(HttpStatus.NOT_FOUND.value());
        results.setData("权限不足");
        results.setMsg(msg);
        return results;
    }
}
