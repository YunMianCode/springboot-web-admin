package com.springboot.admin.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.Primary;

import java.util.Date;

/**
 * <p>
 * 日志记录
 * </p>
 *
 * @author 郭安
 * @since 2021-02-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("log")
@ApiModel(value = "Log", description = "日志记录表")
public class Log {

//    private static final long serialVersionUID = 1;

    @TableId(type = IdType.AUTO)
    private String id;
    /**
     * 模块类型,1图书管理、2教务管理
     */
    private String moduleType;
    /**
     * 一级模块名称
     */
    private String moduleOne;
    /**
     * 二级模块名称
     */
    private String moduleTwo;
    /**
     * 操作名称
     */
    private String operationName;
    /**
     * 操作明细
     */
    private String operationDetail;
    /**
     * 操作时间
     */
    private Date operateTime;
    /**
     * ip
     */
    private String ip;
    /**
     * 用户id
     */
    private Long userId;


}
