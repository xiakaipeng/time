package com.cloud.drore.eboos.common.entity.dealer;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 费率和退款手续费<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/2/2 16:06 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Data
public class ProductForFeeAndRefundFeeCommonVo extends BaseEntity<Long> {


    /**
     * 产品是否可退识别标识(-1不可退)
     */
    @JsonProperty("product_refund_whether")
    @JSONField(name = "product_refund_whether")
    @ApiModelProperty(name = "product_refund_whether", notes = "可退", example = "TRUE")
    private String productRefundWhether;


    /**
     * 产品代码
     */
    @JsonProperty("product_code")
    @JSONField(name = "product_code")
    @ApiModelProperty(name = "product_code", notes = "产品编号", example = "P3034")
    private String productCode;

    /**
     * 消费点id
     */
    @JsonProperty("consume_id")
    @JSONField(name = "consume_id")
    @ApiModelProperty(name = "consume_id", notes = "消费点id", example = "名称")
    private String consumeId;

    /**
     * 退款费率
     */
    @JsonProperty("refund_rate")
    @JSONField(name = "refund_rate")
    @ApiModelProperty(name = "refund_rate", notes = "退款费率", example = "80")
    private BigDecimal refundRate;

    /**
     * 退款手续费
     */
    @JsonProperty("refund_total_fee")
    @JSONField(name = "refund_total_fee")
    @ApiModelProperty(name = "refund_total_fee", notes = "退款手续费", example = "50")
    private BigDecimal refundTotalFee;


}