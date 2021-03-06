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
 * @Description: 账户信息<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/2/5 0005 下午 6:12 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Data
public class AccountTotalVo extends BaseEntity<Long> {


    /**
     * 平台账户余额
     */
    @JsonProperty("total_account_amount")
    @JSONField(name = "total_account_amount")
    @ApiModelProperty(name = "total_account_amount", notes = "平台账户余额", example = "1")
    private BigDecimal totalAccountAmount;


    /**
     * 平台已结算金额
     */
    @JsonProperty("total_amount_aleady")
    @JSONField(name = "total_amount_aleady")
    @ApiModelProperty(name = "total_amount_aleady", notes = "平台已结算金额", example = "1")
    private BigDecimal totalAmountAleady;


}