package com.cloud.drore.eboss.operation.entity.vo;

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
 * @Description: 供应商查询当前返回的最近一次结算次数<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/2/5 0005 下午 6:12 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Data
public class SupplierSelectHistoryRecenetTimeVo extends BaseEntity<Long> {


    /**
     * 结算标识
     */

    @JsonProperty("supplier_settlement_flag")
    @JSONField(name = "supplier_settlement_flag")
    @ApiModelProperty(name = "supplier_settlement_flag", notes = "结算标识", example = "1")
    private int supplierSettlementFlag;

    /**
     * 供应商最近一次结算时间
     */
    @JsonProperty("settlement_end_time")
    @JSONField(name = "settlement_end_time")
    @ApiModelProperty(name = "settlement_end_time", notes = "供应商最近一次结算时间", example = "2018-03-01")
    private Date settlementEndTime;
}