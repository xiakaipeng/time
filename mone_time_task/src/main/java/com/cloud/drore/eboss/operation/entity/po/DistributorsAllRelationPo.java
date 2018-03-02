package com.cloud.drore.eboss.operation.entity.po;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 合作管理-分销商列表-修改分销商产品po<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/2/8 17:18 <br>
 * @Author: <a href="1451173193@qq.com">杨亮</a>
 */
@Data
public class DistributorsAllRelationPo {
    /*分销商id*/
    @JSONField(name = "distributor_id")
    @JsonProperty("distributor_id")
    @ApiModelProperty(name = "distributor_id", notes = "分销商id", example = "109")
    private Long distributorId;

    /*产品名称*/
    @JSONField(name = "product_name")
    @JsonProperty("product_name")
    @ApiModelProperty(name = "product_name", notes = "产品名称", example = "门票")
    private String productName;
}
