package com.cloud.drore.eboos.common.entity.operation.vo;

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
public class FinaceOperationFlowMeterDetailsVo extends BaseEntity<Long> {

    /**
     * 分销商id
     */
    @JsonProperty("distributor_id")
    @JSONField(name = "distributor_id")
    @ApiModelProperty(name = "distributor_id", notes = "分销商id", example = "1")
    private Long distributorId;

    /**
     * 分销商名称
     */
    @JsonProperty("distributor_name")
    @JSONField(name = "distributor_name")
    @ApiModelProperty(name = "distributor_name", notes = "分销商名称", example = "携程")
    private String distributorName;

    /**
     * 订单编号
     */
    @JsonProperty("order_num")
    @JSONField(name = "order_num")
    @ApiModelProperty(name = "order_num", notes = "订单编号", example = "XC3457863475683")
    private String orderNum;


    /**
     * 订单数量
     */
    @JsonProperty("handle_count")
    @JSONField(name = "handle_count")
    @ApiModelProperty(name = "handle_count", notes = "订单数量", example = "12")
    private int handleCount;

    /**
     * 交易事件
     */
    @JsonProperty("order_event_status")
    @JSONField(name = "order_event_status")
    @ApiModelProperty(name = "order_event_status", notes = "订单交易事件", example = "ORDER_PAY")
    private String orderEventStatus;

    /**
     * 交易事件中文
     */
    @JsonProperty("order_event_status_code")
    @JSONField(name = "order_event_status_code")
    @ApiModelProperty(name = "order_event_status_code", notes = "交易事件中文", example = "已支付")
    private String orderEventStatusCode;

    /**
     * 下单时间
     */
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("order_produce_time")
    @JSONField(name = "order_produce_time", format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "order_produce_time", notes = "本次结算时间", example = "2018-1-24 16:36:24")
    private Date orderProduceTime;

    /**
     * 运营商商应结算单价
     */
    @JsonProperty("operation_settlement_price")
    @JSONField(name = "operation_settlement_price")
    @ApiModelProperty(name = "operation_settlement_price", notes = "运营商应结算单价", example = "40")
    private BigDecimal operationSettlementPrice;


    /**
     * 应收款=数量*单价
     */
    @JsonProperty("amount_should_collect")
    @JSONField(name = "amount_should_collect")
    @ApiModelProperty(name = "amount_should_collect", notes = "应收款=数量*单价", example = "40")
    private BigDecimal amountShouldCollect;

    /**
     * 应付款=数量*单价
     */
    @JsonProperty("amount_should_pay")
    @JSONField(name = "amount_should_pay")
    @ApiModelProperty(name = "amount_should_pay", notes = "应付款=数量*单价", example = "40")
    private BigDecimal amountShouldPay;


}
