package com.springboot.admin.model.VO;

import lombok.Data;

@Data
public class PassengerFlowTrendVO {
    //名称
    private String name;
    //数量
    private Integer personNum;
    //环比比例
    private String seqGrowthRate;
    //同比增长率
    private String yearGrowthRate;
    private String num;
    private String type;
    //床位数
    private Integer bedNum;
    //房间数
    private Integer roomNum;


}
