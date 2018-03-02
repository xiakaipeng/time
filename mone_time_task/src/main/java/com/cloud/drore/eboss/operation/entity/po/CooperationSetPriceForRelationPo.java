package com.cloud.drore.eboss.operation.entity.po;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 合作管理设置价格<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/2/9 9:43 <br>
 * @Author: <a href="1451173193@qq.com">杨亮</a>
 */
@Data
public class CooperationSetPriceForRelationPo {
    /**
     * 关联id
     */
    @NotNull(message = "id不能为空！")
    @JsonProperty("relation_id")
    @JSONField(name = "relation_id")
    @ApiModelProperty(name = "relation_id", notes = "关联id", example = "12")
    private Long relationId;
    /**
     * 销售价格
     */
    @NotNull(message = "销售价格不能为空！")
    @JsonProperty("sales_price")
    @JSONField(name = "sales_price")
    @ApiModelProperty(name = "sales_price", notes = "销售价格", example = "88")
    private BigDecimal salesPrice;
}
