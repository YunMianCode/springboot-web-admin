package com.springboot.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.admin.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    User getByName(String userName);

    int getCounts();

    Result add();

}
