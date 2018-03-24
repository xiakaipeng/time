package com.cloud.drore.eboos.common.entity.supplier.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 给分销商提供的消费点poi和供应商名称和id<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/3/22 11:41 <br>
 * @Author: <a href="747639122@qq.com">冯腾</a>
 */
@Data
public class ConsumeAndPoiForDealer {

    /** 信息点名称 */
    @JsonProperty("poi_name")
    @JSONField(name = "poi_name")
    @ApiModelProperty(name = "poi_name", notes = "信息点名称", example = "都江堰景区")
    private String poiName;

    /** 消费点名称 */
    @JsonProperty("consume_name")
    @JSONField(name = "consume_name")
    @ApiModelProperty(name = "consume_name", notes = "消费点名称", example = "都江堰景点")
    private String consumeName;

    /** POIid */
    @JsonProperty("poi_id")
    @JSONField(name = "poi_id")
    @ApiModelProperty(name = "poi_id", notes = "POIid")
    private Long poiId;

    /** 消费点id */
    @JsonProperty("consume_id")
    @JSONField(name = "consume_id")
    @ApiModelProperty(name = "consume_id", notes = "消费点id")
    private Long consumeId;

    /** 供应商id */
    @JsonProperty("merchant_id")
    @JSONField(name = "merchant_id")
    @ApiModelProperty(name = "merchant_id", notes = "供应商id")
    private Long merchantId;

    /** 供应商名称 */
    @JsonProperty("merchant_name")
    @JSONField(name = "merchant_name")
    @ApiModelProperty(name = "merchant_name", notes = "供应商名称")
    private String merchantName;


}
