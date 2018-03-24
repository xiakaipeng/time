package com.cloud.drore.eboos.common.entity.dealer;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 查询费率和退款手续费的Po<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/2/2 16:06 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Data
public class ProductForFeeAndRefundFeeCommonPo extends BaseEntity<Long> {


    /**
     * 公共产品id
     */
    @JsonProperty("product_id")
    @JSONField(name = "product_id")
    @ApiModelProperty(name = "product_id", notes = "公共产品id", example = "12")
    private Long productId;

    /**
     * 产品类型
     */
    @JsonProperty("product_type")
    @JSONField(name = "product_type")
    @ApiModelProperty(name = "product_type", notes = "产品类型", example = "P3034")
    private String productType;


    /**
     * 产品总价
     */
    @JsonProperty("product_total_price")
    @JSONField(name = "product_total_price")
    @ApiModelProperty(name = "product_total_price", notes = "产品总价", example = "5000")
    private BigDecimal productTotalPrice;
    /**
     * 游玩时间
     */
    @JsonProperty("play_date")
    @JSONField(name = "play_date")
    @ApiModelProperty(name = "play_date", notes = "游玩时间", example = "2018-03-17")
    private Date playDate;

}