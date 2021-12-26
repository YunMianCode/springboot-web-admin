package com.springboot.admin.common.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.admin.common.annoation.OperationLog;
import com.springboot.admin.common.result.CommonResult;
import com.springboot.admin.common.util.IpUtil;
import com.springboot.admin.model.Log;
import com.springboot.admin.service.ILogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.security.Principal;
import java.util.Date;

/**
 * 日志切面
 *
 * @author guoan
 * @date 21-12-24 上午9:35
 */
@Slf4j
@Aspect
@Component
@Order(value = 1)
public class WebLogAspect {

    @Resource
    private ILogService logService;

    /**
     * 切入点
     *
     * @author zhangshichang
     * @date 19-3-22 下午9:37
     */
    @Pointcut("execution(public * com.springboot.admin.controller..*.*(..))")
    public void webLog() {
    }


    /**
     * 在切点之前织入
     *
     * @param joinPoint 切入点
     * @author zhangshichang
     * @date 19-3-22 下午9:39
     */
    @Before("webLog()")
    public void deBefore(JoinPoint joinPoint) throws Throwable {
        //开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes != null ? attributes.getRequest() : null;

        //打印请求相关参数
        log.info("========================================== Request Start ==========================================");
        if (request != null) {
            //打印 Http URL
            log.info("URL            : {}", request.getRequestURL().toString());
            //打印 Http method
            log.info("HTTP Method    : {}", request.getMethod());
            //打印调用controller的全路径及执行方法
            Signature signature = joinPoint.getSignature();
            log.info("Class Method   : {}.{}", signature.getDeclaringTypeName(), signature.getName());
            //打印客户端真实的IP
            String ipAddr = IpUtil.getIpAddr(request);
            log.info("Client IP      : {}", ipAddr);
            //打印请求参数--将参数转化成JSON打印; 目前已知以下三个参数不可打印，否则序列化报错  Principal 过于冗余，也不打印
            Object[] args = joinPoint.getArgs();
            Object[] arguments = new Object[args.length];
            for (int i = 0; i < args.length; i++) {
                if (args[i] instanceof ServletRequest
                        || args[i] instanceof ServletResponse
                        || args[i] instanceof MultipartFile
                        || args[i] instanceof Principal) {
                    continue;
                }
                arguments[i] = args[i];
            }
            log.info("Request param  : {}", new ObjectMapper().writeValueAsString(arguments));

        }
    }

    /**
     * 在切点之后织入
     *
     * @author zhangshichang
     * @date 19-3-22 下午10:35
     */
    @After("webLog()")
    public void doAfter(JoinPoint joinPoint) {
        log.info("=========================================== Request End ===========================================");
        //每个请求之间空一行
        log.info("");
    }

    /**
     * 环绕通知--记录后台执行时间以及将响应结果打印
     *
     * @param proceedingJoinPoint 切入点
     * @return object
     * @author zhangshichang
     * @date 19-3-22 下午10:38
     */
    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes != null ? attributes.getRequest() : null;
        Object[] args = proceedingJoinPoint.getArgs();
        Object[] arguments = new Object[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof ServletRequest
                    || args[i] instanceof ServletResponse
                    || args[i] instanceof MultipartFile
                    || args[i] instanceof Principal) {
                continue;
            }
            arguments[i] = args[i];
        }
        String detail = new ObjectMapper().writeValueAsString(arguments);
        long startTime = System.currentTimeMillis();
        //放行
        log.info("proceed之前");//用于验证Advice顺序
        Object result = proceedingJoinPoint.proceed();
        log.info("proceed之后");
        // 记录操作类且成功操作的日志 入库保存
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = methodSignature.getMethod();
        OperationLog annotation = method.getAnnotation(OperationLog.class);
        CommonResult commonResult;
        if (annotation != null
                && result instanceof CommonResult
                && (commonResult = (CommonResult) result).getCode() != null
                && commonResult.getCode() == 200) {
            Log log = new Log();
            log.setUserId(1L);
            log.setModuleOne(annotation.module1());
            log.setModuleTwo(annotation.module2());
            log.setOperationName(annotation.name());
            log.setModuleType(annotation.moduleType());
            log.setOperationDetail(detail);
            if (StringUtils.isNotBlank(annotation.detail())) {
                log.setOperationDetail(annotation.detail());
            }
            log.setOperateTime(new Date());
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (attributes != null) {
                log.setIp(IpUtil.getIpAddr(attributes.getRequest()));
            }
            logService.saveLog(log);
        }

        //打印出参
        log.info("Response param : {}", new ObjectMapper().writeValueAsString(result));
        //执行耗时
        log.info("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
        return result;
    }
}