package com.springboot.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.admin.common.result.CommonResult;
import com.springboot.admin.common.result.CommonResultBuilder;
import com.springboot.admin.dao.LogMapper;
import com.springboot.admin.model.Log;
import com.springboot.admin.model.VO.LogVO;
import com.springboot.admin.model.param.LogQueryParam;
import com.springboot.admin.service.ILogService;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 * <p>
 * Description:
 * </P>
 *
 * @author wangfei
 * @since 2021-02-26
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService {

    /**
     * 日志分页查询
     *
     * @param logQueryParam 查询参数
     * @return 列表
     */
    @Override
    public CommonResult<PageInfo<LogVO>> page(LogQueryParam logQueryParam) {
        //查询条件结束时间推后一天
        if (Objects.nonNull(logQueryParam.getOperateEndTime())) {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(logQueryParam.getOperateEndTime());
            calendar.add(calendar.DATE, 1);
            logQueryParam.setOperateEndTime(calendar.getTime());
        }
        PageInfo<LogVO> pageInfo = PageHelper.startPage(logQueryParam.getPageNum(), logQueryParam.getPageSize())
                .doSelectPageInfo(() -> getBaseMapper().listByParams(logQueryParam));
        return CommonResultBuilder.success(pageInfo);
    }

    @Override
    public int saveLog(Log log) {
        return baseMapper.insert(log);
    }
}
