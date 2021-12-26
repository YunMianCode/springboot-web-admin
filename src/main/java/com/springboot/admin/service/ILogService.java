package com.springboot.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.springboot.admin.common.result.CommonResult;
import com.springboot.admin.model.Log;
import com.springboot.admin.model.VO.LogVO;
import com.springboot.admin.model.param.LogQueryParam;


/**
 * <p>
 * Description:
 * </P>
 *
 * @author wangfei
 * @since 2021-02-26
 */
public interface ILogService extends IService<Log> {

    /**
     * 日志分页查询
     *
     * @param logQueryParam 查询参数
     * @return 列表
     */
    CommonResult<PageInfo<LogVO>> page(LogQueryParam logQueryParam);

    int saveLog(Log log);
}
