package com.springboot.admin.common.annoation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * Description: 操作日志记录
 * </P>
 *
 * @author wangfei
 * @since 2021-02-26
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OperationLog {

    /**
     * 模块类型,1图书管理、2教务管理
     */
    String moduleType() default "1";

    /**
     * 一级菜单模块名称
     */
    String module1() default "UnKnown";

    /**
     * 二级菜单模块名称
     */
    String module2() default "UnKnown";

    /**
     * 操作名称
     */
    String name() default "UnKnown";

    /**
     * 操作详情
     */
    String detail() default "";
}
