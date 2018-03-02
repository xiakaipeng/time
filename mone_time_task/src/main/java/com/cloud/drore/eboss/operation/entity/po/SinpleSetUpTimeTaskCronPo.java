package com.cloud.drore.eboss.operation.entity.po;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/3/2 0002 下午 1:35 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Data
public class SinpleSetUpTimeTaskCronPo extends BaseEntity<Long> {
    /**
     * 定时任务的时间周期cron
     */
    @JsonProperty("sinple_time_task_cycle")
    @JSONField(name = "sinple_time_task_cycle")
    @ApiModelProperty(name = "sinple_time_task_cycle", notes = "定时任务的时间周期", example = "*/5 * * * * *")
    private String sinpleTimeTaskCycle;

}
