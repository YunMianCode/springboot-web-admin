package com.springboot.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.admin.model.Log;
import com.springboot.admin.model.VO.LogVO;
import com.springboot.admin.model.param.LogQueryParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 日志记录
 * </p>
 *
 * @author WangFei
 * @since 2020-12-22
 */
@Repository
public interface LogMapper extends BaseMapper<Log> {

    List<LogVO> listByParams(@Param("logQueryParam") LogQueryParam logQueryParam);

}
