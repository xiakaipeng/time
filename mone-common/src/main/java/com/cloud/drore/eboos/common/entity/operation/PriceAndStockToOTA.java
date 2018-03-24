package com.cloud.drore.eboos.common.entity.operation;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/3/6 20:59 <br>
 * @Author: <a href="1451173193@qq.com">杨亮</a>
 */
@Data
public class PriceAndStockToOTA {
    /** 商户id */
    @JsonProperty("merchant_id")
    @JSONField(name = "merchant_id")
    @ApiModelProperty(name = "merchant_id",notes = "商户id")
    private Long merchantId;
    /** 产品编号*/
    @JsonProperty("product_num")
    @JSONField(name = "product_num")
    @ApiModelProperty(name = "product_num",notes = "产品编号")
    private String productNum;
    /** 当前可用库存*/
    @JsonProperty("inventory")
    @JSONField(name = "inventory")
    @ApiModelProperty(name = "inventory",notes = "当前可用库存")
    private Integer inventory;
    /** 销售价格*/
    @JsonProperty("sales_price")
    @JSONField(name = "sales_price")
    @ApiModelProperty(name = "sales_price",notes = "销售价格")
    private BigDecimal salesPrice;

}
