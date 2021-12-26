package com.springboot.admin.controller;

import com.github.pagehelper.PageInfo;
import com.springboot.admin.common.result.CommonResult;
import com.springboot.admin.model.VO.LogVO;
import com.springboot.admin.model.param.LogQueryParam;
import com.springboot.admin.service.ILogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 多跨协同管理-日志管理
 *
 * @author wangfei
 * @date 2021-08-26
 */
@RestController
@RequestMapping(value = "/log")
@Api(tags = {"日志管理"})
public class LogController {

    @Autowired
    private ILogService logService;

    @PostMapping("/page")
    @ApiOperation(value = "分页查询日志列表")
    public CommonResult<PageInfo<LogVO>> page(@Valid @RequestBody LogQueryParam logQueryParam) {
        logQueryParam.setModuleType("2");
        return logService.page(logQueryParam);
    }

}
