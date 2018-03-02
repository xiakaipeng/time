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
 * @Description: 资金结算平台收入<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/2/5 0005 下午 6:12 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Data
public class FundSettlementTotalVo extends BaseEntity<Long> {


    /**
     * 平台已收入
     */
    @JsonProperty("total_amount_income")
    @JSONField(name = "total_amount_income")
    @ApiModelProperty(name = "total_amount_income", notes = "收入总金额", example = "1")
    private BigDecimal totalAmountIncome;



    /**
     * 平台已结算
     */
    @JsonProperty("total_amount_aleady")
    @JSONField(name = "total_amount_aleady")
    @ApiModelProperty(name = "total_amount_aleady", notes = "平台已结算", example = "1")
    private BigDecimal totalAmountAleady;

    /**
     * 净收益
     */
    @JsonProperty("net_profit")
    @JSONField(name = "net_profit")
    @ApiModelProperty(name = "net_profit", notes = "净收益(total_amount_income-total_amount_should)", example = "1")
    private BigDecimal netProfit;

}