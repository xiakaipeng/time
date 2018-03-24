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
 * @Description:运营商-订单管理-通知信息 vo <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/2/25 17:17 <br>
 * @Author: <a href="1451173193@qq.com">杨亮</a>
 */
@Data
public class OrderNotificationVo {
    /** 通知id*/
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(name = "id", notes = "通知id", example = "1")
    private Long id;

    /** 分销商名称*/
    @JsonProperty("distributor_name")
    @JSONField(name = "distributor_name")
    @ApiModelProperty(name = "distributor_name", notes = "分销商名称", example = "携程")
    private String distributorName;
    /** 消息（通知）类型_名称*/
    @JsonProperty("notification_type")
    @JSONField(name = "notification_type")
    @ApiModelProperty(name = "notification_type", notes = "消息（通知）类型_名称", example = "退订")
    private String notificationType;
    /** 退订/消费时间 */
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("notification_date")
    @JSONField(name = "notification_date",format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "notification_date", notes = "退订/消费时间", example = "2017-12-27 13:40:11")
    private Date notificationDate;
    /**订单号 */
    @JsonProperty("order_num")
    @JSONField(name = "order_num")
    @ApiModelProperty(name = "order_num", notes = "订单号", example = "XC345786")
    private String orderNum;
    /**分销商订单号*/
    @JsonProperty("distributor_order_num")
    @JSONField(name = "distributor_order_num")
    @ApiModelProperty(name = "distributor_order_num", notes = "分销商订单号", example = "LX20180202")
    private String distributorOrderNum;
    /** 订单总数量（购买数量）*/
    @JsonProperty("purchase_count")
    @JSONField(name = "purchase_count")
    @ApiModelProperty(name = "purchase_count", notes = "订单总数量（购买数量）", example = "1")
    private Integer purchaseCount;

    /** 本次处理数量*/
    @JsonProperty("processed_count")
    @JSONField(name = "processed_count")
    @ApiModelProperty(name = "processed_count", notes = "本次处理数量", example = "1")
    private Integer processedCount;

    /** 退订金额*/
    @JsonProperty("refund_amount")
    @JSONField(name = "refund_amount")
    @ApiModelProperty(name = "refund_amount", notes = "退订金额", example = "100")
    private BigDecimal refundAmount;

    /**通知状态cn*/
    @JsonProperty("notification_status")
    @JSONField(name = "notification_status")
    @ApiModelProperty(name = "notification_status", notes = "通知状态cn", example = "通知成功")
    private String notificationStatus;

    /**当前状态cn*/
    @JsonProperty("order_status")
    @JSONField(name = "order_status")
    @ApiModelProperty(name = "order_status", notes = "当前状态cn", example = "退订成功")
    private String orderStatus;
}
