package com.cloud.drore.eboos.common.entity.dealer;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.jackson.JacksonDateDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 供应商最早下订单时间<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/15 17:05 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Data
public class EarliestOrderTimeVo {


    /** 供应商id */
    @JsonProperty("supplier_id")
    @JSONField(name = "supplier_id")
    @ApiModelProperty(name = "supplier_id", notes = "供应商id", example = "1")
    private Long supplierId;


    /** 最早订单时间 */
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("earliest_order_time")
    @JSONField(name = "earliest_order_time" ,format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "earliest_order_time", notes = "最早订单时间", example = "2018-02-26 13:26:12")
    private Date earliestOrderTime;


}