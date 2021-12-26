package com.springboot.admin.model.param;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 日志查询
 *
 * @author wangfei
 * @date 2021-02-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "LogQueryParam", description = "日志查询")
public class LogQueryParam extends PageRequestParam {

    @ApiModelProperty(value = "操作人姓名或账户名关键字, 模糊匹配")
    private String operatorLike;

    @ApiModelProperty(value = "操作模块")
    private String module;

    @ApiModelProperty(value = "操作开始时间, 格式yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date operateBeginTime;

    @ApiModelProperty(value = "操作结束时间, 格式yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date operateEndTime;

    //    @ApiModelProperty(hidden = true)
//    private Long userId;
//    @ApiModelProperty(hidden = true)
//    private Long roleId;
    @ApiModelProperty(hidden = true)
    private Long departId;

    /**
     * 模块类型,1犬类管理、2多跨协同
     */
    @ApiModelProperty(hidden = true, value = "模块类型,1犬类管理、2多跨协同")
    private String moduleType = "1";
}
