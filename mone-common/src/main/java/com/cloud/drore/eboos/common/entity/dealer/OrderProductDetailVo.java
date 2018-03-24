package com.cloud.drore.eboos.common.entity.dealer;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 订单子表产品详情vo<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/24 15:16 <br>
 * @Author: <a href="747639122@qq.com">冯腾</a>
 */
@Data
public class OrderProductDetailVo {

    /** 消费点名称 */
    @JsonProperty("consume_name")
    @JSONField(name = "consume_name")
    @ApiModelProperty(name = "consume_name", notes = "消费点名称", example = "洪园")
    private String consumeName;

}
