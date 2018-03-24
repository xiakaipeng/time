package com.cloud.drore.eboos.common.entity.dealer;

import com.alibaba.fastjson.annotation.JSONField;
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
 * @Description: 订单详情Vo<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/11 11:55 <br>
 * @Author: <a href="747639122@qq.com">冯腾</a>
 */
@Data
public class OrderDetailVo {

    /** 订单主键 */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(name = "id", notes = "订单主键", example = "1")
    private Long id;

    /** 订单编号 */
    @JsonProperty("order_num")
    @JSONField(name = "order_num")
    @ApiModelProperty(name = "order_num", notes = "订单编号", example = "XC3457863475683")
    private String orderNum;

    /** 分销商订单编号 */
    @JsonProperty("distributor_order_num")
    @JSONField(name = "distributor_order_num")
    @ApiModelProperty(name = "distributor_order_num", notes = "供应商订单编号", example = "JQ345734683")
    private String distributorOrderNum;


    /** 订单状态(1.待付款 2.已取消 3.已支付 4.退订失败 8.已退订 9.已消费 10.已验证 11.已过期) */
    @JsonProperty("order_status")
    @JSONField(name = "order_status")
    @ApiModelProperty(name = "order_status", notes = "订单状态(1.待付款 2.已取消 3.已支付 4.退订失败 " +
            "8.已退订 9.已消费 10.已验证 11.已过期)", example = "1")
    private Integer orderStatus;

    /** 订单状态(1.待付款 2.已取消 3.已支付 4.退订失败 8.已退订 9.已消费 10.已验证 11.已过期) */
    @JsonProperty("order_status_name")
    @JSONField(name = "order_status_name")
    @ApiModelProperty(name = "order_status_name", notes = "订单状态(1.待付款 2.已取消 3.已支付 4.退订失败" +
            " 8.已退订 9.已消费 10.已验证 11.已过期)", example = "退订失败")
    private String orderStatusName;

    /** 取票人姓名 */
    @JsonProperty("subscriber_name")
    @JSONField(name = "subscriber_name")
    @ApiModelProperty(name = "subscriber_name", notes = "取票人姓名", example = "王二")
    private String subscriberName;

    /** 取票人电话 */
    @JsonProperty("subscriber_phone_num")
    @JSONField(name = "subscriber_phone_num")
    @ApiModelProperty(name = "subscriber_phone_num", notes = "取票人电话", example = "12345677685")
    private String subscriberPhoneNum;

    /** 取票人证件号码 */
    @JsonProperty("subscriber_identification_num")
    @JSONField(name = "subscriber_identification_num")
    @ApiModelProperty(name = "subscriber_identification_num", notes = "取票人证件号码", example = "723468723648726048357")
    private String subscriberIdentificationNum;

    /** 订单下单时间 */
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("created_date")
    @JSONField(name = "created_date",format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "created_date", notes = "订单下单时间", example = "2018-1-9 15:47:11")
    private Date createdDate;

    /** 付款方式(询查字典):ALIPAY_PAYMENT:支付宝支付 WECHAT_PAYMENT:微信支付 */
    @JsonProperty("payment_way")
    @JSONField(name = "payment_way")
    @ApiModelProperty(name = "payment_way", notes = "付款方式", example = "ALIPAY_PAYMENT")
    private String paymentWay;

    /** 消费码 */
    @JsonProperty("consume_code")
    @JSONField(name = "consume_code")
    @ApiModelProperty(name = "consume_code", notes = "消费码", example = "4567754867334")
    private String consumeCode;

    /** 所属商户(分销商)名称*/
    @JsonProperty("distributor_name")
    @JSONField(name = "distributor_name")
    @ApiModelProperty(name = "distributor_name", notes = "所属商户(分销商)名称", example = "携程")
    private String distributorName;

    /** 消费点名称 */
    @JsonProperty("consume_name")
    @JSONField(name = "consume_name")
    @ApiModelProperty(name = "consume_name", notes = "消费点名称", example = "洪园")
    private String consumeName;

    /** 产品名称 */
    @JsonProperty("product_name")
    @JSONField(name = "product_name")
    @ApiModelProperty(name = "product_name", notes = "产品名称", example = "门票")
    private String productName;

    /** 产品类型 */
    /*@JsonProperty("product_type")
    @JSONField(name = "product_type")
    @ApiModelProperty(name = "product_type", notes = "产品类型: TICKET_PRODUCT:门票产品 COMBINATION_PRODUCT:组合产品 HOTEL_PRODUCT:酒店产品", example = "门票")
    private String productType;*/

    /** 产品单价 */
    @JsonProperty("unit_price")
    @JSONField(name = "unit_price")
    @ApiModelProperty(name = "unit_price", notes = "产品单价", example = "233.33")
    private BigDecimal unitPrice;

    /** 订单总价*/
    @JsonProperty("total_price")
    @JSONField(name = "total_price")
    @ApiModelProperty(name = "total_price", notes = "订单总价", example = "699.99")
    private BigDecimal totalPrice;

    /** 产品库存 */
    /*@JsonProperty("stock")
    @JSONField(name = "stock")
    @ApiModelProperty(name = "stock", notes = "产品库存", example = "80")
    private Integer stock;*/

    /** 退款手续费 */
    @JsonProperty("refund_amount")
    @JSONField(name = "refund_amount")
    @ApiModelProperty(name = "refund_amount", notes = "退款手续费", example = "30")
    private BigDecimal refundAmount;

    /** 购买数量 */
    @JsonProperty("purchase_count")
    @JSONField(name = "purchase_count")
    @ApiModelProperty(name = "purchase_count", notes = "购买数量", example = "3")
    private Integer purchaseCount;

    /** 消费数量 */
    @JsonProperty("consume_count")
    @JSONField(name = "consume_count")
    @ApiModelProperty(name = "consume_count", notes = "消费数量", example = "1")
    private Integer consumeCount;

    /** 退订数量 */
    @JsonProperty("unsubscribe_count")
    @JSONField(name = "unsubscribe_count")
    @ApiModelProperty(name = "unsubscribe_count", notes = "退订数量", example = "2")
    private Integer unsubscribeCount;

    /** 实际支付金额 */
    /*@JsonProperty("actually_payment")
    @JSONField(name = "actually_payment")
    @ApiModelProperty(name = "actually_payment", notes = "实际支付金额", example = "222.34")
    private BigDecimal actuallyPayment;*/

    /** 应退金额 */
    /*@JsonProperty("should_refund")
    @JSONField(name = "should_refund")
    @ApiModelProperty(name = "should_refund", notes = "应退金额", example = "45.5")
    private BigDecimal shouldRefund;*/

    /** 退款金额 */
    @JsonProperty("actually_refund")
    @JSONField(name = "actually_refund")
    @ApiModelProperty(name = "actually_refund", notes = "退款金额", example = "45.5")
    private BigDecimal actuallyRefund;

    /** 预订开始时间 */
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("subscribe_start_date")
    @JSONField(name = "subscribe_start_date", format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "subscribe_start_date", notes = "预订开始时间", example = "2018-1-5 14:38:04")
    private Date subscribeStartDate;

    /** 预订结束时间 */
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("subscribe_end_date")
    @JSONField(name = "subscribe_end_date", format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "subscribe_end_date", notes = "预订结束时间", example = "2018-1-5 14:38:04")
    private Date subscribeEndDate;

    /** 消费开始时间 */
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("consume_start_date")
    @JSONField(name = "consume_start_date", format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "consume_start_date", notes = "消费开始时间", example = "2018-1-5 14:38:04")
    private Date consumeStartDate;

    /** 消费结束时间 */
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("consume_end_date")
    @JSONField(name = "consume_end_date", format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "consume_end_date", notes = "消费结束时间", example = "2018-1-5 14:38:04")
    private Date consumeEndDate;

    /** 结算价 */
    @JsonProperty("settlement_price")
    @JSONField(name = "settlement_price")
    @ApiModelProperty(name = "settlement_price", notes = "结算价", example = "400.5")
    private BigDecimal settlementPrice;

}
