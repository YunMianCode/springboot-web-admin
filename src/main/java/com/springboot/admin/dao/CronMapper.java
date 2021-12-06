package com.springboot.admin.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CronMapper {

    @Select("select CRON_EXPRESS from cron limit 1")
    String getCron();

}
