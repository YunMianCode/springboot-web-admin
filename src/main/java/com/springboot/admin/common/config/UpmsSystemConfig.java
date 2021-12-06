package com.springboot.admin.common.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName SystemConfig
 * @Description 系统配置参数
 * @Author yinzx
 * @Date 2020/1/2 14:24
 * @Version 1.0
 **/
@Data
@Component
public class UpmsSystemConfig {

    /**
     * rsa模
     */
    @Value("${rsa.modulus}")
    private String modulus;

    /**
     * rsa公钥指数
     */
    @Value("${rsa.privateExponent}")
    private String privateExponent;

    /**
     * 登录失败限制次数
     */
    @Value("${loginError.count}")
    private int loginErrorCount;

    /**
     * 登录失败锁定限制次数
     */
    @Value("${loginLock.count}")
    private int loginLockCount;

    /**
     * 修改密码，原密码错误锁定时间
     */
    @Value("${updatePwd.locktime}")
    private int upPwdLocktime;

    /**
     * 登录锁定时间
     */
    @Value("${login.locktime}")
    private int loginLocktime;

}
