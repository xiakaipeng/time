package com.cloud.drore.eboss.operation.entity.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 运营商账户信息显示<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/29 14:59 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Data
public class DistributorAccountVo {
    /**
     * 账户余额
     */
    @JsonProperty("account_balance")
    @JSONField(name = "account_balance")
    @ApiModelProperty(name = "account_balance", notes = "账户余额", example = "10000")
    private BigDecimal accountBalance;

    /**
     * 已结算金额
     */
    @JsonProperty("total_amount_aleady")
    @JSONField(name = "total_amount_aleady")
    @ApiModelProperty(name = "total_amount_aleady", notes = "已结算金额", example = "50000")
    private BigDecimal totalAmountAleady;

}
