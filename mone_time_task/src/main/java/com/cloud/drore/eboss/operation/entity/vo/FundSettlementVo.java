package com.cloud.drore.eboss.operation.entity.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 资金结算<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/2/5 0005 下午 6:12 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Data
public class FundSettlementVo extends BaseEntity<Long> {


    /**
     * 供应商名称
     */
    @JsonProperty("merchant_name")
    @JSONField(name = "merchant_name")
    @ApiModelProperty(name = "merchant_name", notes = "供应商名称", example = "1")
    private String merchantName;

    /**
     * 供应商id
     */
    @JsonProperty("merchant_id")
    @JSONField(name = "merchant_id")
    @ApiModelProperty(name = "merchant_id", notes = "供应商id", example = "1")
    private Long merchantId;

    /**
     * 收入总金额
     */
    @JsonProperty("total_amount_income")
    @JSONField(name = "total_amount_income")
    @ApiModelProperty(name = "total_amount_income", notes = "收入总金额", example = "1")
    private BigDecimal totalAmountIncome;

    /**
     * 应结算总金额
     */
    @JsonProperty("total_amount_should")
    @JSONField(name = "total_amount_should")
    @ApiModelProperty(name = "total_amount_should", notes = "应结算总金额", example = "1")
    private BigDecimal totalAmountShould;

    /**
     * 已结算总金额
     */
    @JsonProperty("total_amount_aleady")
    @JSONField(name = "total_amount_aleady")
    @ApiModelProperty(name = "total_amount_aleady", notes = "应结算总金额", example = "1")
    private BigDecimal totalAmountAleady;

    /**
     * 净收益
     */
    @JsonProperty("net_profit")
    @JSONField(name = "net_profit")
    @ApiModelProperty(name = "net_profit", notes = "净收益(total_amount_income-total_amount_should)", example = "1")
    private BigDecimal netProfit;

}