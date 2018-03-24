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
 * @Description: 对供应商组合产品订单页面提供的Vo<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/9 11:47 <br>
 * @Author: <a href="747639122@qq.com">冯腾</a>
 */
@Data
public class SupplierCombProductOrderVo {

    /** 订单主键 */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(name = "id", notes = "订单编号", example = "XC3457863475683")
    private Long id;

    /** 订单下单时间 */
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("created_date")
    @JSONField(name = "created_date",format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "created_date", notes = "订单下单时间", example = "2018-1-9 15:47:11")
    private Date createdDate;

    /** 订单编号 */
    @JsonProperty("order_num")
    @JSONField(name = "order_num")
    @ApiModelProperty(name = "order_num", notes = "订单编号", example = "XC3457863475683")
    private String orderNum;

    /** 支付类型(查询字典):ONLINE_PREPAYMENT:线上预付 SCENIC_PAYMENT:景区支付 */
    @JsonProperty("payment_type")
    @JSONField(name = "payment_type")
    @ApiModelProperty(name = "payment_type", notes = "支付类型", example = "线上预付")
    private String paymentType;

    /** 付款方式(询查字典):ALIPAY_PAYMENT:支付宝支付 WECHAT_PAYMENT:微信支付 */
    @JsonProperty("payment_way")
    @JSONField(name = "payment_way")
    @ApiModelProperty(name = "payment_way", notes = "付款方式", example = "支付宝支付")
    private String paymentWay;

    /** 订单状态(1.待付款 2.已取消 3.已支付 4.退订失败 8.已退订 9.已消费 10.已验证 11.已过期) */
    @JsonProperty("order_status")
    @JSONField(name = "order_status")
    @ApiModelProperty(name = "order_status", notes = "订单状态(1.待付款 2.已取消 3.已支付 4.退订失败" +
            " 8.已退订 9.已消费 10.已验证 11.已过期)", example = "退款失败")
    private Integer orderStatus;

    /** 订单状态(1.待付款 2.已取消 3.已支付 4.退订失败 8.已退订 9.已消费 10.已验证 11.已过期) */
    @JsonProperty("order_status_name")
    @JSONField(name = "order_status_name")
    @ApiModelProperty(name = "order_status_name", notes = "订单状态(1.待付款 2.已取消 3.已支付 4.退订失败" +
            " 8.已退订 9.已消费 10.已验证 11.已过期)", example = "退订失败")
    private String orderStatusName;

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

    /** 购买数量 */
    @JsonProperty("purchase_count")
    @JSONField(name = "purchase_count")
    @ApiModelProperty(name = "purchase_count", notes = "购买数量", example = "3")
    private Integer purchaseCount;

    /** 订单总价*/
    /*@JsonProperty("total_price")
    @JSONField(name = "total_price")
    @ApiModelProperty(name = "total_price", notes = "订单总价", example = "699.99")
    private BigDecimal totalPrice;*/

    /** 产品名称 */
    @JsonProperty("product_name")
    @JSONField(name = "product_name")
    @ApiModelProperty(name = "product_name", notes = "产品名称", example = "门票")
    private String productName;

    /** 消费点名称 */
    /*@JsonProperty("consume_name")
    @JSONField(name = "consume_name")
    @ApiModelProperty(name = "consume_name", notes = "消费点名称", example = "洪园")
    private String consumeName;*/

    /** 产品类型 */
    @JsonProperty("product_type")
    @JSONField(name = "product_type")
    @ApiModelProperty(name = "product_type", notes = "产品类型: TICKET_PRODUCT:门票产品 COMBINATION_PRODUCT:组合产品 HOTEL_PRODUCT:酒店产品", example = "2018-1-9")
    private String productType;

    /** 供应商名称 */
    @JsonProperty("merchant_name")
    @JSONField(name = "merchant_name")
    @ApiModelProperty(name = "merchant_name", notes = "供应商名称", example = "龙门石窟")
    private String merchantName;

    /** 分销商订单编号 */
    @JsonProperty("distributor_order_num")
    @JSONField(name = "distributor_order_num")
    @ApiModelProperty(name = "distributor_order_num", notes = "供应商订单编号", example = "JQ345734683")
    private String distributorOrderNum;

    /** 分销商名称 */
    @JsonProperty("distributor_name")
    @JSONField(name = "distributor_name")
    @ApiModelProperty(name = "distributor_name", notes = "分销商名称", example = "携程")
    private String distributorName;
}
