package com.springboot.admin.model.VO;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 日志记录
 * </p>
 *
 * @author wangfei
 * @since 2021-02-26
 */
@Data
@ApiModel(value = "LogVO", description = "日志记录VO")
public class LogVO {

    @ApiModelProperty("编号")
    private String id;
    @ApiModelProperty("操作时间, 格式yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date operateTime;
    @ApiModelProperty("操作人账号")
    private String username;
    @ApiModelProperty("操作人名称")
    private String userFullName;

    @ApiModelProperty("操作模块(二级菜单)")
    private String module;

    @ApiModelProperty("操作内容")
    private String operationDetail;

    @ApiModelProperty("ip地址")
    private String ip;
}
