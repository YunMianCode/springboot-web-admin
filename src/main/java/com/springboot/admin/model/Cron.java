package com.springboot.admin.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cron {

    @TableField(value = "CORN_ID")
    private int cornId;

    @TableField(value = "CORN_EXPRESS")
    private String cornExpress;

}
