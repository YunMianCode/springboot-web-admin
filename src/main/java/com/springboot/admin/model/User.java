package com.springboot.admin.model;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.Message;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
@Builder
@ApiModel(value = "用户实体", description = "图书馆Books实体User")
public class User implements Serializable {

    @TableField(value = "USER_ID")
    @ApiModelProperty("用户Id")
    @NotNull(message = "用户Id不能为空")
    @TableId(type = IdType.AUTO)
    private int userId;

    @TableField(value = "USER_NAME")
    @ApiModelProperty("用户名")
    @NotEmpty(message = "用户名不能为空")
    @Length(message = "用户名长度最大为40，最小为5",max=40,min=5)
    private String userName;

    @TableField(value = "PASSWORD")
    @ApiModelProperty("用户密码")
    @Min(message = "用户密码至少6位",value = 6)
//    @Max(message = "用户密码最长100位",value = 100)
    private String password;

    @TableField(value = "TEL")
    @ApiModelProperty("用户电话")
    @NotEmpty(message = "联系电话不能为空")
    private String tel;

    @TableField(value = "STATUS")
    @ApiModelProperty("用户状态")
    @TableLogic(value = "1", delval = "0")
    private String status;

    public User(String userName,String password){
        this.userName = userName;
        this.password = password;
    }

}
