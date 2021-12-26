package com.springboot.admin.model.enums;

import com.alibaba.fastjson.annotation.JSONType;
import com.baomidou.mybatisplus.core.enums.IEnum;

import java.io.Serializable;

@JSONType(serializeEnumAsJavaBean = true)
public enum DelFlagEnum implements IEnum {
    NORMAL_STATUS("1", "正常"),
    DELETE_STATUS("0", "删除");

    private String value;
    private String desc;

    DelFlagEnum(final String value, final String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Serializable getValue() {
        return this.value;
    }

    public Serializable getDesc() {
        return this.desc;
    }
}
