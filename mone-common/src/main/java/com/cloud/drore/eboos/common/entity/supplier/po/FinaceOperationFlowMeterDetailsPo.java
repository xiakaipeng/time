package com.cloud.drore.eboos.common.entity.supplier.po;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.base.BaseEntity;
import com.cloud.drore.eboos.jackson.JacksonDateDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 供应商查询财务管理收入明细<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/24 0024 下午 4:42 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Data
public class FinaceOperationFlowMeterDetailsPo extends BaseEntity<Long> {

    /**
     * 分销商id
     */
    @JsonProperty("distributor_id")
    @JSONField(name = "distributor_id")
    @ApiModelProperty(name = "distributor_id", notes = "分销商id", example = "109")
    private Long distributorId;


    /**
     * 订单编号
     */
    @JsonProperty("order_num")
    @JSONField(name = "order_num")
    @ApiModelProperty(name = "order_num", notes = "订单编号", example = "XC3457863475683")
    private String orderNum;


    /**
     * 交易事件
     */
    @JsonProperty("order_event_status")
    @JSONField(name = "order_event_status")
    @ApiModelProperty(name = "order_event_status", notes = "订单状态", example = "ORDER_PAY")
    private String orderEventStatus;


    /**
     * 查询开始时间
     */
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("settlement_start_time")
    @JSONField(name = "settlement_start_time", format = "yyyy-MM-dd")
    @ApiModelProperty(name = "settlement_start_time", notes = "查询开始时间", example = "2018-02-08")
    private Date settlementStartTime;

    /**
     * 查询截止时间
     */
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("settlement_end_time")
    @JSONField(name = "settlement_end_time", format = "yyyy-MM-dd")
    @ApiModelProperty(name = "settlement_end_time", notes = "查询截止时间", example = "2018-02-08")
    private Date settlementEndTime;


}
