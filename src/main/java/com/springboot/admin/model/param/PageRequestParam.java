package com.springboot.admin.model.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 分页请求JSON参数
 *
 * @author zhangshichang
 * @date 19-4-17 下午4:27
 */
@Data
@ApiModel(value = "分页请求JSON参数")
public class PageRequestParam implements Serializable {

    private static final long serialVersionUID = -4206639131301706544L;

    @NotNull(message = "页码不能为空")
    @Min(value = 1, message = "页码不能小于1")
    @ApiModelProperty(name = "pageNum", value = "页码", example = "1", required = true)
    private Integer pageNum = 1;

    @NotNull(message = "页大小不能为空")
    @Min(value = 1, message = "页大小不能小于1")
    @ApiModelProperty(name = "pageSize", value = "页大小", example = "10", required = true)
    private Integer pageSize = 10;

    public void clearPageParams() {
        this.pageNum = null;
        this.pageSize = null;
    }

}
