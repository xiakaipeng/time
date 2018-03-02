package com.cloud.drore.eboss.operation.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.base.BaseEntity;
import com.cloud.drore.eboss.jackson.JacksonDateDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 供应商查询手动结算查询本次结算金额和时间<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/2/5 0005 下午 6:12 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Data
public class SupplierSettlementInfo extends BaseEntity<Long> {

    /**
     * 结算金额
     */

    @JsonProperty("supplier_settlement_amount")
    @JSONField(name = "supplier_settlement_amount")
    @ApiModelProperty(name = "supplier_settlement_amount", notes = "结算金额", example = "10000")
    private BigDecimal supplierSettlementAmount;

    /**
     * 本次结算时间
     */
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("settlement_recetent_time")
    @JSONField(name = "settlement_recetent_time", format = "yy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "settlement_recetent_time", notes = "本次结算时间", example = "2018-03-01")
    private Date settlementRecetentTime;
}