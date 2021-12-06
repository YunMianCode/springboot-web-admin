package com.springboot.admin.model.DTO;

import lombok.Data;

@Data
public class SignLingDTO {

    private String areaId;
    private String dateTime;
    private String dayType; //1为按天、2为按月数据、3为按节假日数据、4为按月累计数据。

    public SignLingDTO(String areaId, String dateTime, String dayType) {
        this.areaId = areaId;
        this.dateTime = dateTime;
        this.dayType = dayType;
    }

    public SignLingDTO() {
    }

}
