package com.cloud.drore.eboos.common.entity.dealer;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 用于多条件查询订单的Po<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/9 14:18 <br>
 * @Author: <a href="747639122@qq.com">冯腾</a>
 */
@Data
public class OrderQueryPo {

    /** 供应商id */
    @JsonProperty("supplier_id")
    @JSONField(name = "supplier_id")
    @ApiModelProperty(name = "supplier_id", notes = "供应商id", example = "2")
    private Long supplierId;

    /** 分销商id */
    @JsonProperty("distributor_id")
    @JSONField(name = "distributor_id")
    @ApiModelProperty(name = "distributor_id", notes = "分销商id", example = "1")
    private Long distributorId;

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

    /** 订单状态(1.待付款 2.已取消 3.已支付 4.退订失败 8.已退订 9.已消费 10.已验证 11.已过期) */
    @JsonProperty("order_status")
    @JSONField(name = "order_status")
    @ApiModelProperty(name = "order_status", notes = "订单状态(1.待付款 2.已取消 3.已支付 4.退订失败 " +
            "8.已退订 9.已消费 10.已验证 11.已过期)", example = "2")
    private Integer orderStatus;

    /** 订单下单查询开始时间 */
    @JsonProperty("created_begin_date")
    @JSONField(name = "created_begin_date", format = "yyyy-MM-dd")
    @ApiModelProperty(name = "created_begin_date", notes = "订单下单查询开始时间", example = "2018-1-9")
    private Date createdBeginDate;

    /** 订单下单查询结束时间 */
    @JsonProperty("created_end_date")
    @JSONField(name = "created_end_date", format = "yyyy-MM-dd")
    @ApiModelProperty(name = "created_end_date", notes = "订单下单查询结束时间", example = "2018-1-11")
    private Date createdEndDate;

    /** 消费查询开始时间 */
    @JsonProperty("consume_begin_date")
    @JSONField(name = "consume_begin_date", format = "yyyy-MM-dd")
    @ApiModelProperty(name = "consume_begin_date", notes = "消费查询开始时间", example = "2018-1-5")
    private Date consumeBeginDate;

    /** 消费查询结束时间 */
    @JsonProperty("consume_end_date")
    @JSONField(name = "consume_end_date", format = "yyyy-MM-dd")
    @ApiModelProperty(name = "consume_end_date", notes = "消费查询结束时间", example = "2018-1-9")
    private Date consumeEndDate;

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
}
