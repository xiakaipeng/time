package com.cloud.drore.eboos.common.entity.operation.po;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.base.BaseEntity;
import com.cloud.drore.eboos.jackson.JacksonDateDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 财务结算的时候从订单产品表中取到的数据源<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/24 0024 下午 4:42 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Data
@Table(name = "eboos_order_product")
public class FinaceSourseDataCommonPo extends BaseEntity<Long> {

    /**
     * 供应商id
     */
    @JsonProperty("supplier_id")
    @JSONField(name = "supplier_id")
    @ApiModelProperty(name = "supplier_id", notes = "供应商id", example = "1")
    private Long supplierId;

    /**
     * 上一次结算时间
     */
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("settlement_start_time")
    @JSONField(name = "settlement_start_time", format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "settlement_start_time", notes = "上一次结算时间", example = "2018-1-5 14:38:04")
    private Date settlementStartTime;

    /**
     * 本次结算时间
     */
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("settlement_end_time")
    @JSONField(name = "settlement_end_time", format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "settlement_end_time", notes = "本次结算时间", example = "2018-1-24 11:26:28")
    private Date settlementEndTime;

    /**
     * 期数id
     */
    @JsonProperty("finace_settlement_history_id")
    @JSONField(name = "finace_settlement_history_id")
    @ApiModelProperty(name = "finace_settlement_history_id", notes = "期数id", example = "12")
    private Long finaceSettlementHistoryId;

}
