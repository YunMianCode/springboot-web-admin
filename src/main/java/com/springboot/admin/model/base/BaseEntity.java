package com.springboot.admin.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.springboot.admin.model.enums.DelFlagEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Accessors(chain = true)
@ApiModel(value = "BaseEntity", description = "公共字段基础类")
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 9078572325206129462L;

    @TableId
    @ApiModelProperty(value = "数据库唯一ID")
    private Long id;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建者ID")
    private Long createUserId;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.UPDATE)
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @TableField(fill = FieldFill.UPDATE)
    @ApiModelProperty(value = "更新者ID")
    private Long updateUserId;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    @JSONField(serialzeFeatures = SerializerFeature.DisableCircularReferenceDetect)
    @ApiModelProperty(value = "逻辑删除")
    private DelFlagEnum delFlag;

}
