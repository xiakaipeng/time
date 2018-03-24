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
import java.util.List;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 订单对应单个商品实体类<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/23 11:48 <br>
 * @Author: <a href="747639122@qq.com">冯腾</a>
 */
@Data
@Table(name = "eboos_order_product")
public class OrderProduct extends BaseEntity<Long> {

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

    /** 实退金额 */
    /*@JsonProperty("actually_refund")
    @JSONField(name = "actually_refund")
    @ApiModelProperty(name = "actually_refund", notes = "实退金额", example = "45.5")
    private BigDecimal actuallyRefund;*/

    /** 购买数量 */
    @JsonProperty("purchase_count")
    @JSONField(name = "purchase_count")
    @ApiModelProperty(name = "purchase_count", notes = "购买数量", example = "3")
    private Integer purchaseCount;

    /** 产品名称 */
    @JsonProperty("product_name")
    @JSONField(name = "product_name")
    @ApiModelProperty(name = "product_name", notes = "产品名称", example = "西溪湿地门票")
    private String productName;

    /** 产品编号 */
    @JsonProperty("product_num")
    @JSONField(name = "product_num")
    @ApiModelProperty(name = "product_num", notes = "产品编号", example = "T1000")
    private String productNum;

    /** 消费点id */
    @JsonProperty("consume_id")
    @JSONField(name = "consume_id")
    @ApiModelProperty(name = "consume_id", notes = "消费点id", example = "2")
    private Long consumeId;

    /** 消费点名称 */
    @JsonProperty("consume_name")
    @JSONField(name = "consume_name")
    @ApiModelProperty(name = "consume_name", notes = "消费点名称", example = "洪园")
    private String consumeName;

    /** 景区id */
    @JsonProperty("poi_id")
    @JSONField(name = "poi_id")
    @ApiModelProperty(name = "poi_id", notes = "景区id", example = "2")
    private Long poiId;

    /** 景区名称 */
    @JsonProperty("poi_name")
    @JSONField(name = "poi_name")
    @ApiModelProperty(name = "poi_name", notes = "景区名称", example = "西溪湿地公园")
    private String poiName;

    /** 适用人群 */
    @JsonProperty("crowd")
    @JSONField(name = "crowd")
    @ApiModelProperty(name = "crowd", notes = "适用人群", example = "学生")
    private String crowd;

    /** 产品库存 */
    @JsonProperty("stock")
    @JSONField(name = "stock")
    @ApiModelProperty(name = "stock", notes = "产品库存", example = "80")
    private Integer stock;

    /** 当前能否退款：1可以，0不可以，默认1 */
    @JsonProperty("enable_refund")
    @JSONField(name = "enable_refund")
    @ApiModelProperty(name = "enable_refund", notes = "当前能否退款：1可以，0不可以，默认1", example = "1")
    private Integer enableRefund;

    /** 产品有效期开始时间 */
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("term_of_validity_start_time")
    @JSONField(name = "term_of_validity_start_time")
    @ApiModelProperty(name = "term_of_validity_start_time", notes = "产品有效期开始时间", example = "2018-01-05 00:00:00")
    private Date termOfValidityStartTime;

    /** 产品有效期结束时间 */
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("term_of_validity_end_time")
    @JSONField(name = "term_of_validity_end_time")
    @ApiModelProperty(name = "term_of_validity_end_time", notes = "产品有效期结束时间", example = "2018-01-05 00:00:00")
    private Date termOfValidityEndTime;

    /** 供应商id */
    @JsonProperty("supplier_id")
    @JSONField(name = "supplier_id")
    @ApiModelProperty(name = "supplier_id", notes = "供应商id", example = "2")
    private Long supplierId;

    /** 供应商名称 */
    @JsonProperty("supplier_name")
    @JSONField(name = "supplier_name")
    @ApiModelProperty(name = "supplier_name", notes = "供应商名称", example = "西溪湿地")
    private String supplierName;

    /** 产品类型 */
    @JsonProperty("product_type")
    @JSONField(name = "product_type")
    @ApiModelProperty(name = "product_type", notes = "产品类型", example = "TICKET_PRODUCT")
    private String productType;

    /** 运营商和供应商的结算价 */
    @JsonProperty("supplier_settlement_price")
    @JSONField(name = "supplier_settlement_price")
    @ApiModelProperty(name = "supplier_settlement_price", notes = "运营商和供应商的结算价", example = "100.34")
    private BigDecimal supplierSettlementPrice;

    /** 所属订单主键id */
    @JsonProperty("order_id")
    @JSONField(name = "order_id")
    @ApiModelProperty(name = "order_id", notes = "所属订单主键id", example = "1")
    private Long orderId;

    /** 失效时间,单位天 */
    @JsonProperty("disable_time")
    @JSONField(name = "disable_time")
    @ApiModelProperty(name = "disable_time", notes = "失效时间,单位天", example = "1")
    private Integer disableTime;

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

    /** 订单状态(1.待付款 2.已取消 3.已支付 4.退订失败 8.已退订 9.已消费 10.已验证 11.已过期) */
    @JsonProperty("order_status")
    @JSONField(name = "order_status")
    @ApiModelProperty(name = "order_status", notes = "订单状态(1.待付款 2.已取消 3.已支付 4.退订失败 " +
            "8.已退订 9.已消费 10.已验证 11.已过期)", example = "ORDER_EXPIRED")
    private Integer orderStatus;

    /** 产品编码（畅游通） */
    @JsonProperty("product_code")
    @JSONField(name = "product_code")
    @ApiModelProperty(name = "product_code", notes = "产品编码（畅游通）", example = "25221")
    private String productCode;

    /** 入园凭证（密码）*/
    @JsonProperty("message_code")
    @JSONField(name = "message_code")
    @ApiModelProperty(name = "message_code", notes = "入园凭证（密码）", example = "345234")
    private String messageCode;

    /** 电子票信息*/
    @JsonProperty("eticket_info")
    @JSONField(name = "eticket_info")
    @ApiModelProperty(name = "eticket_info", notes = "电子票信息", example = "订单号[20180226999777002],密码[32177154],二维码[dy.jingqu.cn/z/2wk_r8la.do]")
    private String eticketInfo;

    /** 退款流水号*/
    @JsonProperty("refund_seq")
    @JSONField(name = "refund_seq")
    @ApiModelProperty(name = "refund_seq", notes = "退款流水号", example = "TK342342")
    private String refundSeq;

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

    /** 票务（畅游通）订单编号 */
    @JsonProperty("ticket_order_num")
    @JSONField(name = "ticket_order_num")
    @ApiModelProperty(name = "ticket_order_num", notes = "票务（畅游通）订单编号", example = "CYT5734683")
    private String ticketOrderNum;

    /** 消费信息 */
    @JsonProperty("consume_info")
    @JSONField(name = "consume_info")
    @ApiModelProperty(name = "consume_info", notes = "消费信息", example = "这里就是消费时的备注信息")
    private String consumeInfo;

    /** 消费数量 */
    @JsonProperty("consume_count")
    @JSONField(name = "consume_count")
    @ApiModelProperty(name = "consume_count", notes = "消费数量", example = "1")
    private Integer consumeCount;

    /** 电子票状态，0表示未发送，1表示已发送 */
    @JsonProperty("eticket_status")
    @JSONField(name = "eticket_status")
    @ApiModelProperty(name = "eticket_status", notes = "电子票状态，0表示未发送，1表示已发送", example = "1")
    private String eticketStatus;

    /** 子，支付是否成功，0表示不成功，1表示成功 */
    @JsonProperty("eticket_status")
    @JSONField(name = "eticket_status")
    @ApiModelProperty(name = "eticket_status", notes = "子，支付是否成功，0表示不成功，1表示成功", example = "1")
    private String paySuccess;

    /** 子，退款是否成功，0表示不成功，1表示成功 */
    @JsonProperty("refund_success")
    @JSONField(name = "refund_success")
    @ApiModelProperty(name = "refund_success", notes = "子，退款是否成功，0表示不成功，1表示成功", example = "1")
    private String refundSuccess;

    /** 子，退款审核结果，APPROVE：同意退款；REJECT：拒绝退款 */
    @JsonProperty("refund_result")
    @JSONField(name = "refund_result")
    @ApiModelProperty(name = "refund_result", notes = "退款审核结果", example = "REJECT")
    private String refundResult;

    public interface SAVE{}
}
