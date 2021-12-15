package com.springboot.admin.common.annoation;


import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyLog {

    String desc() default "";

}
