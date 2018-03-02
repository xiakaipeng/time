package com.cloud.drore.eboss.operation.entity.po;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 添加产品po<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/2/9 16:09 <br>
 * @Author: <a href="1451173193@qq.com">杨亮</a>
 */
@Data
public class CooperationManagementAddPo {
    /*分销商id*/
    @NotNull
    @JsonProperty("distributor_id")
    @JSONField(name = "distributor_id")
    @ApiModelProperty(name = "distributor_id", notes = "分销商id", example = "106")
    private Long distributorId;
    /*产品类型*/
    @NotNull
    @JsonProperty("product_type")
    @JSONField(name = "product_type")
    @ApiModelProperty(name = "product_type", notes = "产品类型", example = "COMBINATION_PRODUCT")
    private String productType;
    /*poi Id*/
    @NotNull
    @JsonProperty("poi_id")
    @JSONField(name = "poi_id")
    @ApiModelProperty(name = "poi_id", notes = "poi Id", example = "4")
    private Long poiId;
}
