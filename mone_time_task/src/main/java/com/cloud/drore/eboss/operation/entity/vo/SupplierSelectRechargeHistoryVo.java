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
 * @Description: 超级管理员删除供应商的充值凭证需要查询得到的对象<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/2/5 0005 下午 6:12 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Data
public class SupplierSelectRechargeHistoryVo extends BaseEntity<Long> {


    /**
     * 结算次数
     */

    @JsonProperty("settlement_count")
    @JSONField(name = "settlement_count")
    @ApiModelProperty(name = "settlement_count", notes = "结算次数", example = "1")
    private int settlementCount;

    /**
     * 查询返回用于更新的供应商已经结算的金额
     */
    @JsonProperty("settlement_amount_total")
    @JSONField(name = "settlement_amount_total")
    @ApiModelProperty(name = "settlement_amount_total", notes = "查询返回用于更新的供应商已经结算的金额", example = "62525")
    private BigDecimal settlementAmountTotal;
}