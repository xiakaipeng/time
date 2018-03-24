package com.cloud.drore.eboos.common.entity.dealer;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.List;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/3/18 17:19 <br>
 * @Author: <a href="1451173193@qq.com">杨亮</a>
 */
@Data
public class DistributorProductQueryVo {
    /*产品id*/
    @JSONField(name = "id")
    @JsonProperty("id")
    @ApiModelProperty(name = "id", notes = "产品id")
    private Long id;
    /*产品编码*/
    @JSONField(name = "product_num")
    @JsonProperty("product_num")
    @ApiModelProperty(name = "product_num", notes = "产品编码")
    private String productNum;
    /*产品名称*/
    @JSONField(name = "product_name")
    @JsonProperty("product_name")
    @ApiModelProperty(name = "product_name", notes = "产品名称")
    private String productName;
    /*产品景区*/
    @JSONField(name = "poi_names")
    @JsonProperty("poi_names")
    @ApiModelProperty(name = "poi_names", notes = "产品景区")
    private String poiNames;
    /*产品消费点*/
    @JSONField(name = "consume_names")
    @JsonProperty("consume_names")
    @ApiModelProperty(name = "consume_names", notes = "产品消费点（景点）")
    private String consumeNames;
    /*产品售价*/
    @JSONField(name = "sales_price")
    @JsonProperty("sales_price")
    @ApiModelProperty(name = "sales_price", notes = "产品售价")
    private BigDecimal salesPrice;
    /*适应人群*/
    @JSONField(name = "product_crowd")
    @JsonProperty("product_crowd")
    @ApiModelProperty(name = "product_crowd", notes = "适应人群")
    private String productCrowd;
    /*是否实名制*/
    @JSONField(name = "is_real_name")
    @JsonProperty("is_real_name")
    @ApiModelProperty(name = "is_real_name", notes = "是否实名制(1-实名制，0-非实名制)")
    private String isRealName;
    /*产品类型*/
    @JSONField(name = "product_type")
    @JsonProperty("product_type")
    @ApiModelProperty(name = "product_type", notes = "产品类型")
    private String productType;
    /** 验证码类型 */
    @Transient
    @JsonProperty("verification_type")
    @JSONField(name = "verification_type")
    @ApiModelProperty(name = "verification_type", notes = "验证码类型")
    private List<String> verificationType;
}
