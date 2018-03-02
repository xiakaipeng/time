package com.cloud.drore.eboss.operation.entity.po;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.base.BaseEntity;
import com.cloud.drore.eboss.jackson.JacksonDateDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


import javax.persistence.Table;

import java.util.Date;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 财务结算的历史事件记录<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/30 0024 下午 4:42 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Data
@Table(name = "eboss_finace_settlement_history")
public class FinaceSettlementHistoryPo extends BaseEntity<Long> {

    /**
     * 查询开始时间
     */
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("recharge_begin_time")
    @JSONField(name = "recharge_begin_time", format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "recharge_begin_time", notes = "查询开始时间", example = "2018-01-30")
    private Date rechargeBeginTime;

    /**
     * 查询结束时间
     */
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("recharge_end_time")
    @JSONField(name = "recharge_end_time", format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "recharge_end_time", notes = "查询结束时间", example = "2018-01-31")
    private Date rechargeEndTime;

}
