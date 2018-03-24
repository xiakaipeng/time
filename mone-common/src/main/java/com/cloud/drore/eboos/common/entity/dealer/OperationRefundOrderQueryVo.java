package com.cloud.drore.eboos.common.entity.dealer;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.entity.base.DictionaryVo;
import com.cloud.drore.eboos.jackson.JacksonDateDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 退订订单查询结果Vo<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/12 11:11 <br>
 * @Author: <a href="747639122@qq.com">冯腾</a>
 */
@Data
public class OperationRefundOrderQueryVo {

    /** 订单主键 */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(name = "id", notes = "订单主键", example = "2")
    private Long id;

    /** 订单创建时间 */
    @JsonProperty("created_date")
    @JSONField(name = "created_date", format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "created_date", notes = "预订结束时间", example = "2018-1-9 15:47:11")
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    private Date createdDate;

    /** 订单编号 */
    @JsonProperty("order_num")
    @JSONField(name = "order_num")
    @ApiModelProperty(name = "order_num", notes = "订单编号", example = "XC3457863475683")
    private String orderNum;

    /** 产品类型 */
    @JsonProperty("product_type")
    @JSONField(name = "product_type")
    @ApiModelProperty(name = "product_type", notes = "产品类型: TICKET_PRODUCT:门票产品 COMBINATION_PRODUCT:组合产品 HOTEL_PRODUCT:酒店产品，不显示而作为其他接口参数")
    private String productType;

    /** 产品名称 */
    @JsonProperty("product_name")
    @JSONField(name = "product_name")
    @ApiModelProperty(name = "product_name", notes = "产品名称", example = "门票")
    private String productName;

    /** 付款方式(询查字典):ALIPAY_PAYMENT:支付宝支付 WECHAT_PAYMENT:微信支付 */
    @JsonProperty("payment_way")
    @JSONField(name = "payment_way")
    @ApiModelProperty(name = "payment_way", notes = "付款方式", example = "ALIPAY_PAYMENT")
    private String paymentWay;

    /** 支付类型(查询字典):ONLINE_PREPAYMENT:线上预付 SCENIC_PAYMENT:景区支付 */
    @JsonProperty("payment_type")
    @JSONField(name = "payment_type")
    @ApiModelProperty(name = "payment_type", notes = "支付类型", example = "SCENIC_PAYMENT")
    private String paymentType;

    /** 景区名称 */
    /*@JsonProperty("poi_name")
    @JSONField(name = "poi_name")
    @ApiModelProperty(name = "poi_name", notes = "景区名称", example = "西溪湿地公园")
    private String poiName;*/

    /** 购买数量 */
    /*@JsonProperty("purchase_count")
    @JSONField(name = "purchase_count")
    @ApiModelProperty(name = "purchase_count", notes = "购买数量", example = "3")
    private Integer purchaseCount;*/

    /** 退订数量 */
    @JsonProperty("unsubscribe_count")
    @JSONField(name = "unsubscribe_count")
    @ApiModelProperty(name = "unsubscribe_count", notes = "退订数量", example = "3")
    private Integer unsubscribeCount;

    /** 退款金额 */
    @JsonProperty("actually_refund")
    @JSONField(name = "actually_refund")
    @ApiModelProperty(name = "actually_refund", notes = "退款金额", example = "45.5")
    private BigDecimal actuallyRefund;

    /** 退款类型 */
    @JsonProperty("refund_type")
    @JSONField(name = "refund_type")
    @ApiModelProperty(name = "refund_type", notes = "退款类型", example = "REFUND_MONEY")
    private String refundType;

    /** 退款次数 */
    @JsonProperty("refund_count")
    @JSONField(name = "refund_count")
    @ApiModelProperty(name = "refund_count", notes = "退款次数", example = "1")
    private Integer refundCount;

    /** 订单状态(1.待付款 2.已取消 3.已支付 4.退订失败 8.已退订 9.已消费 10.已验证 11.已过期) */
    @JsonProperty("order_status")
    @JSONField(name = "order_status")
    @ApiModelProperty(name = "order_status", notes = "订单状态(1.待付款 2.已取消 3.已支付 4.退订失败 " +
            "8.已退订 9.已消费 10.已验证 11.已过期)", example = "2")
    private Integer orderStatus;

    /** 订单状态(1.待付款 2.已取消 3.已支付 4.退订失败 8.已退订 9.已消费 10.已验证 11.已过期) */
    @JsonProperty("order_status_name")
    @JSONField(name = "order_status_name")
    @ApiModelProperty(name = "order_status_name", notes = "订单状态(1.待付款 2.已取消 3.已支付 4.退订失败" +
            " 8.已退订 9.已消费 10.已验证 11.已过期)", example = "退订失败")
    private String orderStatusName;

    /** 退款时间 */
    /*@JsonProperty("refund_date")
    @JSONField(name = "refund_date", format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "refund_date", notes = "退款时间", example = "2018-1-20 14:38:04")
    private Date refundDate;*/

    /** 分销商名称 */
    @JsonProperty("distributor_name")
    @JSONField(name = "distributor_name")
    @ApiModelProperty(name = "distributor_name", notes = "分销商名称", example = "携程")
    private String distributorName;

    /** 供应商名称 */
    @JsonProperty("supplier_name")
    @JSONField(name = "supplier_name")
    @ApiModelProperty(name = "supplier_name", notes = "供应商名称")
    private List<String> supplierName;

}
