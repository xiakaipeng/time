package com.cloud.drore.eboos.common.entity.dealer;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.entity.base.DictionaryVo;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/3/1 14:50 <br>
 * @Author: <a href="1451173193@qq.com">杨亮</a>
 */
@Data
public class OrderNotificationInitVo {
    /** 消息（通知）类型字典*/
    @JsonProperty("notification_type")
    @JSONField(name = "notification_type")
    @ApiModelProperty(name = "notification_type", notes = "消息（通知）类型字典")
    private List<DictionaryVo> notificationType;
    /** 消息（通知）状态字典*/
    @JsonProperty("notification_status")
    @JSONField(name = "notification_status")
    @ApiModelProperty(name = "notification_status", notes = "消息（通知）状态字典")
    private List<DictionaryVo> notificationStatus;
}
