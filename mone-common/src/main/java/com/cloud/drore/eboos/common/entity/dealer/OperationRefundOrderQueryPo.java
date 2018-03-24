package com.cloud.drore.eboos.common.entity.dealer;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 退订订单查询条件Po<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/12 10:51 <br>
 * @Author: <a href="747639122@qq.com">冯腾</a>
 */
@Data
public class OperationRefundOrderQueryPo {

    /** 订单状态(1.待付款 2.已取消 3.已支付 4.退订失败 8.已退订 9.已消费 10.已验证 11.已过期) */
    @JsonProperty("order_status")
    @JSONField(name = "order_status")
    @ApiModelProperty(name = "order_status", notes = "订单状态(1.待付款 2.已取消 3.已支付 4.退订失败 " +
            "8.已退订 9.已消费 10.已验证 11.已过期)", example = "4")
    private Integer orderStatus;

    /** 所属商户(分销商)id */
    @JsonProperty("distributor_id")
    @JSONField(name = "distributor_id")
    @ApiModelProperty(name = "distributor_id", notes = "所属商户(分销商)id", example = "2")
    private Long distributorId;

    /** 付款方式(询查字典):ALIPAY_PAYMENT:支付宝支付 WECHAT_PAYMENT:微信支付 */
    /*@JsonProperty("payment_way")
    @JSONField(name = "payment_way")
    @ApiModelProperty(name = "payment_way", notes = "付款方式", example = "ALIPAY_PAYMENT")
    private String paymentWay;*/


    /** 产品类型 */
    /*@JsonProperty("product_type")
    @JSONField(name = "product_type")
    @ApiModelProperty(name = "product_type", notes = "产品类型: TICKET_PRODUCT:门票产品 COMBINATION_PRODUCT:组合产品 HOTEL_PRODUCT:酒店产品", example = "TICKET_PRODUCT")
    private String productType;*/

    /** 订单下单查询开始时间 */
    @JsonProperty("created_begin_date")
    @JSONField(name = "created_begin_date", format = "yyyy-MM-dd")
    @ApiModelProperty(name = "created_begin_date", notes = "订单下单查询开始时间", example = "2018-1-9")
    private Date createdBeginDate;

    /** 订单下单查询结束时间 */
    @JsonProperty("created_end_date")
    @JSONField(name = "created_end_date", format = "yyyy-MM-dd")
    @ApiModelProperty(name = "created_end_date", notes = "订单下单查询结束时间", example = "2018-1-14")
    private Date createdEndDate;

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

}
