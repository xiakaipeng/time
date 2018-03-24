package com.cloud.drore.eboos.common.entity.supplier.po;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/13 11:37 <br>
 * @Author: <a href="575842778@qq.com">郑永涛</a>
 */
@Data
public class TicketQueryPo {

    /** 门票名称 */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(name = "name", notes = "门票名称", example = "西溪湿地门票")
    private String name;

    /** 供应商id */
    @JsonProperty("supplier_id")
    @JSONField(name = "supplier_id")
    @ApiModelProperty(name = "supplier_id", notes = "供应商id(分销商模块不传此数据)", example = "1")
    private Long supplierId;

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

    /** 产品状态 */
    @JsonProperty("status")
    @JSONField(name = "status")
    @ApiModelProperty(name = "status", notes = "产品状态(供应商分页查询参数)", example = "1")
    private String status;
}