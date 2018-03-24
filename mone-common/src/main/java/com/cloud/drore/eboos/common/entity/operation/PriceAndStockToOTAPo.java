package com.cloud.drore.eboos.common.entity.operation;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/3/7 11:48 <br>
 * @Author: <a href="1451173193@qq.com">杨亮</a>
 */
@Data
public class PriceAndStockToOTAPo {
    /** 商户id */
    @JsonProperty("merchant_id")
    @JSONField(name = "merchant_id")
    @ApiModelProperty(name = "merchant_id",notes = "商户id",example = "109")
    private Long merchantId;
    /** 产品编号*/
    @JsonProperty("product_num")
    @JSONField(name = "product_num")
    @ApiModelProperty(name = "product_num",notes = "产品编号",example="T83")
    private String productNum;
}
