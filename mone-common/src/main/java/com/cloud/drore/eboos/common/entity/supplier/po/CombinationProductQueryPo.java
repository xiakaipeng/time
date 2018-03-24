package com.cloud.drore.eboos.common.entity.supplier.po;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 组合产品实体类<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/18 14:49 <br>
 * @Author: <a href="575842778@qq.com">郑永涛</a>
 */
@Data
public class CombinationProductQueryPo {
    /** 组合产品名称 */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(name = "name", notes = "门票名称", example = "西溪湿地门票")
    private String name;

    /** 组合产品是否上架标识 0 未上架 1 已上架 */
    @JsonProperty("status")
    @JSONField(name = "status")
    @ApiModelProperty(name = "status", notes = "组合产品是否上架标识", example = "1")
    private String status;

    /** 信息点id */
    @JsonProperty("poi_id")
    @JSONField(name = "poi_id")
    @ApiModelProperty(name = "poi_id", notes = "信息点id", example = "12")
    private Long poiId;

    /** 消费点id */
    @JsonProperty("consume_id")
    @JSONField(name = "consume_id")
    @ApiModelProperty(name = "consume_id", notes = "消费点id（后台接口业务用）", example = "10", hidden = true)
    private String consumeId;

    /** 商户id */
    @JsonProperty("supplier_id")
    @JSONField(name = "supplier_id")
    @ApiModelProperty(name = "supplier_id", notes = "商户id(后台设置)", example = "1")
    private Long supplierId;
}