package com.cloud.drore.eboos.common.entity.dealer;

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
 * @Description: 订单实体类<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/5 13:59 <br>
 * @Author: <a href="747639122@qq.com">冯腾</a>
 */
@Data
@Table(name = "eboos_order")
public class Order extends BaseEntity<Long> {

    /** 订单编号 */
    @JsonProperty("order_num")
    @JSONField(name = "order_num")
    @ApiModelProperty(name = "order_num", notes = "订单编号", example = "XC3457863475683")
    private String orderNum;

    /** 分销商订单编号 */
    @JsonProperty("distributor_order_num")
    @JSONField(name = "distributor_order_num")
    @ApiModelProperty(name = "distributor_order_num", notes = "分销商订单编号", example = "JQ345734683")
    private String distributorOrderNum;

    /** 支付类型(查询字典):ONLINE_PREPAYMENT:线上预付 SCENIC_PAYMENT:景区支付 */
    @JsonProperty("payment_type")
    @JSONField(name = "payment_type")
    @ApiModelProperty(name = "payment_type", notes = "支付类型", example = "SCENIC_PAYMENT")
    private String paymentType;

    /** 付款方式(询查字典):ALIPAY_PAYMENT:支付宝支付 WECHAT_PAYMENT:微信支付 */
    @JsonProperty("payment_way")
    @JSONField(name = "payment_way")
    @ApiModelProperty(name = "payment_way", notes = "付款方式", example = "ALIPAY_PAYMENT")
    private String paymentWay;

    /** 订单状态(1.待付款 2.已取消 3.已支付 4.退订失败 8.已退订 9.已消费 10.已验证 11.已过期) */
    @JsonProperty("order_status")
    @JSONField(name = "order_status")
    @ApiModelProperty(name = "order_status", notes = "订单状态(1.待付款 2.已取消 3.已支付 4.退订失败 " +
            "8.已退订 9.已消费 10.已验证 11.已过期)", example = "ORDER_EXPIRED")
    private Integer orderStatus;

    /** 消费码 */
    @JsonProperty("consume_code")
    @JSONField(name = "consume_code")
    @ApiModelProperty(name = "consume_code", notes = "消费码", example = "4567754867334")
    private String consumeCode;

    /** 预订人姓名 */
    @JsonProperty("subscriber_name")
    @JSONField(name = "subscriber_name")
    @ApiModelProperty(name = "subscriber_name", notes = "预订人姓名", example = "王二")
    private String subscriberName;

    /** 预订人电话 */
    @JsonProperty("subscriber_phone_num")
    @JSONField(name = "subscriber_phone_num")
    @ApiModelProperty(name = "subscriber_phone_num", notes = "预订人电话", example = "12345677685")
    private String subscriberPhoneNum;

    /** 预订人证件号码 */
    @JsonProperty("subscriber_identification_num")
    @JSONField(name = "subscriber_identification_num")
    @ApiModelProperty(name = "subscriber_identification_num", notes = "预订人证件号码", example = "723468723648726048357")
    private String subscriberIdentificationNum;

    /** 预订人证件类型 */
    @JsonProperty("subscriber_identification_type")
    @JSONField(name = "subscriber_identification_type")
    @ApiModelProperty(name = "subscriber_identification_type", notes = "预订人证件类型", example = "ID_CARD")
    private String subscriberIdentificationType;

    /** 购买数量 */
    @JsonProperty("purchase_count")
    @JSONField(name = "purchase_count")
    @ApiModelProperty(name = "purchase_count", notes = "购买数量", example = "3")
    private Integer purchaseCount;

    /** 退订数量 */
    @JsonProperty("unsubscribe_count")
    @JSONField(name = "unsubscribe_count")
    @ApiModelProperty(name = "unsubscribe_count", notes = "退订数量", example = "2")
    private Integer unsubscribeCount;

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

    /** 付款时间 */
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("payed_date")
    @JSONField(name = "payed_date", format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "payed_date", notes = "付款时间", example = "2018-1-20 14:38:04")
    private Date payedDate;

    /** 退款时间 */
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("refund_date")
    @JSONField(name = "refund_date", format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "refund_date", notes = "退款时间", example = "2018-1-20 14:38:04")
    private Date refundDate;

    /** 退款次数 */
    @JsonProperty("refund_count")
    @JSONField(name = "refund_count")
    @ApiModelProperty(name = "refund_count", notes = "退款次数", example = "1")
    private Integer refundCount;

    /** 产品类型 */
    @JsonProperty("product_type")
    @JSONField(name = "product_type")
    @ApiModelProperty(name = "product_type", notes = "产品类型: TICKET_PRODUCT:门票产品 COMBINATION_PRODUCT:组合产品 HOTEL_PRODUCT:酒店产品", example = "TICKET_PRODUCT")
    private String productType;

    /** 产品名称 */
    @JsonProperty("product_name")
    @JSONField(name = "product_name")
    @ApiModelProperty(name = "product_name", notes = "产品名称", example = "洪园")
    private String productName;

    /** 产品编号 */
    @JsonProperty("product_num")
    @JSONField(name = "product_num")
    @ApiModelProperty(name = "product_num", notes = "产品编号", example = "XX111")
    private String productNum;

    /** 所属产品id */
    @JsonProperty("product_relation_id")
    @JSONField(name = "product_relation_id")
    @ApiModelProperty(name = "product_relation_id", notes = "所属产品id", example = "4")
    private Long productRelationId;

    /** 所属商户(分销商)id */
    @JsonProperty("distributor_id")
    @JSONField(name = "distributor_id")
    @ApiModelProperty(name = "distributor_id", notes = "所属商户(分销商)id", example = "2")
    private Long distributorId;

    /** 所属商户(分销商)类型，旅行社(MERCHANT_INDUSTRY_HOUSEKEEPER)、OTA(MERCHANT_INDUSTRY_OTA)*/
    @JsonProperty("merchant_industry")
    @JSONField(name = "merchant_industry")
    @ApiModelProperty(name = "merchant_industry", notes = "所属商户(分销商)id，旅行社(MERCHANT_INDUSTRY_HOUSEKEEPER)、OTA(MERCHANT_INDUSTRY_OTA)", example = "MERCHANT_INDUSTRY_OTA")
    private String merchantIndustry;

    /** 所属商户(分销商)名称*/
    @JsonProperty("distributor_name")
    @JSONField(name = "distributor_name")
    @ApiModelProperty(name = "distributor_name", notes = "所属商户(分销商)名称", example = "携程")
    private String distributorName;

    /** 退款金额*/
    @JsonProperty("actually_refund")
    @JSONField(name = "actually_refund")
    @ApiModelProperty(name = "actually_refund", notes = "分销商实际退款给用户金额", example = "45.99")
    private BigDecimal actuallyRefund;

    /** 分销商和运营商的结算价 */
    @JsonProperty("operation_settlement_price")
    @JSONField(name = "operation_settlement_price")
    @ApiModelProperty(name = "operation_settlement_price", notes = "分销商和运营商的结算价", example = "149.34")
    private BigDecimal operationSettlementPrice;

    /** 产品单价*/
    @JsonProperty("unit_price")
    @JSONField(name = "unit_price")
    @ApiModelProperty(name = "unit_price", notes = "产品单价", example = "20.99")
    private BigDecimal unitPrice;

    /** 电子票信息*/
    @JsonProperty("eticket_info")
    @JSONField(name = "eticket_info")
    @ApiModelProperty(name = "eticket_info", notes = "电子票信息", example = "订单号[20180226999777002],密码[32177154],二维码[dy.jingqu.cn/z/2wk_r8la.do]")
    private String eticketInfo;

    /** 电子票状态，0表示未发送，1表示已发送 */
    @JsonProperty("eticket_status")
    @JSONField(name = "eticket_status")
    @ApiModelProperty(name = "eticket_status", notes = "电子票状态，0表示未发送，1表示已发送", example = "1")
    private String eticketStatus;

    /** 退款类型 */
    @JsonProperty("refund_type")
    @JSONField(name = "refund_type")
    @ApiModelProperty(name = "refund_type", notes = "退款类型", example = "REFUND_MONEY")
    private String refundType;

    /** 退款说明*/
    @JsonProperty("refund_explain")
    @JSONField(name = "refund_explain")
    @ApiModelProperty(name = "refund_explain", notes = "退款说明", example = "因为不想买了就退款")
    private String refundExplain;

    /** 退款审核结果，APPROVE：同意退款；REJECT：拒绝退款 */
    @JsonProperty("refund_result")
    @JSONField(name = "refund_result")
    @ApiModelProperty(name = "refund_result", notes = "退款审核结果", example = "REJECT")
    private String refundResult;

    /** 退款手续费费率 */
    @JsonProperty("refund_fee")
    @JSONField(name = "refund_fee")
    @ApiModelProperty(name = "refund_fee", notes = "退款手续费费率", example = "0.05")
    private BigDecimal refundFee;



//    /** 消费数量 */
//    @JsonProperty("consume_count")
//    @JSONField(name = "consume_count")
//    @ApiModelProperty(name = "consume_count", notes = "消费数量", example = "1")
//    private Integer consumeCount;
//
//    /** 消费信息 */
//    @JsonProperty("consume_info")
//    @JSONField(name = "consume_info")
//    @ApiModelProperty(name = "consume_info", notes = "消费信息", example = "这里就是消费时的备注信息")
//    private String consumeInfo;
//
    /** 退款流水号*/
    @JsonProperty("refund_seq")
    @JSONField(name = "refund_seq")
    @ApiModelProperty(name = "refund_seq", notes = "退款流水号", example = "TK342342")
    private String refundSeq;
//
//    /** 票务（畅游通）订单编号 */
//    @JsonProperty("ticket_order_num")
//    @JSONField(name = "ticket_order_num")
//    @ApiModelProperty(name = "ticket_order_num", notes = "票务（畅游通）订单编号", example = "CYT5734683")
//    private String ticketOrderNum;

    /** 退款手续费*/
    @JsonProperty("refund_charge")
    @JSONField(name = "refund_charge")
    @ApiModelProperty(name = "refund_charge", notes = "退款手续费", example = "5.81")
    private BigDecimal refundCharge;

    /** 订单总价*/
    @JsonProperty("total_price")
    @JSONField(name = "total_price")
    @ApiModelProperty(name = "total_price", notes = "订单总价", example = "699.99")
    private BigDecimal totalPrice;

    /** 入园凭证（密码）*/
    @JsonProperty("message_code")
    @JSONField(name = "message_code")
    @ApiModelProperty(name = "message_code", notes = "入园凭证（密码）", example = "345234")
    private String messageCode;

    /** 主，支付是否成功，0表示不成功，1表示成功 */
    @JsonProperty("eticket_status")
    @JSONField(name = "eticket_status")
    @ApiModelProperty(name = "eticket_status", notes = "子，支付是否成功，0表示不成功，1表示成功", example = "1")
    private String paySuccess;

    /** 主，退款是否成功，0表示不成功，1表示成功 */
    @JsonProperty("refund_success")
    @JSONField(name = "refund_success")
    @ApiModelProperty(name = "refund_success", notes = "子，退款是否成功，0表示不成功，1表示成功", example = "1")
    private String refundSuccess;

    /** 适用人群 */
    @JsonProperty("crowd")
    @JSONField(name = "crowd")
    @ApiModelProperty(name = "crowd", notes = "适用人群", example = "学生")
    private String crowd;

    /** 分销商编号 */
    @JsonProperty("distributor_num")
    @JSONField(name = "distributor_num")
    @ApiModelProperty(name = "distributor_num", notes = "分销商编号")
    private String distributorNum;


    public interface SAVE{}
}
