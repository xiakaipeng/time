package com.cloud.drore.eboos.common.entity.operation.po;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/3/22 11:28 <br>
 * @Author: <a href="1451173193@qq.com">杨亮</a>
 */
@Data
public class GetProductByOTARequest {
    /**
     * 产品代码
     */
    @JsonProperty("product_code")
    @JSONField(name = "product_code")
    @ApiModelProperty(name = "product_code", notes = "产品代码", example = "0220022")
    private String productCode;
    /**
     * 请求方式
     */
    @JsonProperty("method")
    @JSONField(name = "method")
    @ApiModelProperty(name = "method", notes = "请求方式（ALL 或者 SINGLE）", example = "SINGLE")
    private String method;
    /**
     * 当前页
     */
    @JsonProperty("current_page")
    @JSONField(name = "current_page")
    @ApiModelProperty(name = "current_page", notes = "当前页", example = "1")
    private Integer currentPage;
    /**
     * 每页显示条数
     */
    @JsonProperty("page_size")
    @JSONField(name = "page_size")
    @ApiModelProperty(name = "page_size", notes = "每页显示条数", example = "10")
    private Integer pageSize;

}
