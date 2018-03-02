package com.cloud.drore.eboss.operation.entity.po;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 门票与组合产品根据id获取分销商po<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/2/1 16:54 <br>
 * @Author: <a href="1451173193@qq.com">杨亮</a>
 */
@Data
public class ProductToDistributorPo {
    /**
     * 产品id
     */
    @NotNull(message = " 产品id不能为空！")
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(name = "id", notes = "产品id", example = "36")
    private Long id;

    /**
     * 产品类型（门票/组合产品）
     */
    @NotBlank(message = "产品类型不能为空！")
    @JsonProperty("product_type")
    @JSONField(name = "product_type")
    @ApiModelProperty(name = "product_type", notes = "产品类型", example = "1")
    private String productType;
}
