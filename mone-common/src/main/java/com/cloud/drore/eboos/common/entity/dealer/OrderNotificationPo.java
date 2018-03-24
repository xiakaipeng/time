package com.cloud.drore.eboos.common.entity.dealer;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description:运营商-订单管理-通知信息 po <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/2/25 17:17 <br>
 * @Author: <a href="1451173193@qq.com">杨亮</a>
 */
@Data
public class OrderNotificationPo {
    /** 分销商id */
    @JsonProperty("distributor_id")
    @JSONField(name = "distributor_id")
    @ApiModelProperty(name = "distributor_id", notes = "分销商id", example = "93")
    private Long distributorId;
    /** 消息（通知）类型*/
    @JsonProperty("notification_type")
    @JSONField(name = "notification_type")
    @ApiModelProperty(name = "notification_type", notes = "消息（通知）类型", example = "ORDER_NOTIFICATION_TYPE_REFUND")
    private String notificationType;
    /** 开始时间 */
    @JsonProperty("time_begin")
    @JSONField(name = "time_begin")
    @ApiModelProperty(name = "time_begin", notes = "开始时间", example = "2017-12-27 13:40:11")
    private Date timeBegin;
    /** 结束时间 */
    @JsonProperty("time_end")
    @JSONField(name = "time_end")
    @ApiModelProperty(name = "time_end", notes = "结束时间", example = "2018-12-27 13:40:11")
    private Date timeEnd;
    /**订单号*/
    @JsonProperty("order_num")
    @JSONField(name = "order_num")
    @ApiModelProperty(name = "order_num", notes = "订单号", example = "XC345786")
    private String orderNum;
    /** 通知状态*/
    @JsonProperty("notification_status")
    @JSONField(name = "notification_status")
    @ApiModelProperty(name = "notification_status", notes = "通知状态", example = "ORDER_NOTIFICATION_STATUS_NOT_NOTIFIED")
    private String notificationStatus;
}
