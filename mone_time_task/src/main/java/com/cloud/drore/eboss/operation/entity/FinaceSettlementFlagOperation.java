package com.cloud.drore.eboss.operation.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


import javax.persistence.Table;
import java.util.Date;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 自动结算判断是否是首次结算的标识表，每次都更新该数据库的表<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/30 0024 下午 4:42 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Data
@Table(name = "eboss_finace_settlement_flag_time")
public class FinaceSettlementFlagOperation extends BaseEntity<Long> {


    /**
     * 供应商id
     */
    @JsonProperty("supplier_id")
    @JSONField(name = "supplier_id")
    @ApiModelProperty(name = "supplier_id", notes = "供应商id", example = "1")
    private Long supplierId;


    /**
     * 当前供应商自动结算时间，精确到秒
     */
    @JsonProperty("auto_settlement_time")
    @JSONField(name = "auto_settlement_time")
    @ApiModelProperty(name = "auto_settlement_time", notes = "当前供应商自动结算时间，精确到秒", example = "2018-01-31 16:33:24")
    private Date autoSettlementTime;

    /**
     * 当年结算的期数
     */
    @JsonProperty("current_year_settlement_stage")
    @JSONField(name = "current_year_settlement_stage")
    @ApiModelProperty(name = "current_year_settlement_stage", notes = "当年结算的期数", example = "1")
    private int currentYearSettlementStage;

}
