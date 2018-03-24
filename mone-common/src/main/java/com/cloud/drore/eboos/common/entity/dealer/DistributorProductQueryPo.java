package com.cloud.drore.eboos.common.entity.dealer;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 分销商模块产品管理接口<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/3/18 16:50 <br>
 * @Author: <a href="1451173193@qq.com">杨亮</a>
 */
@Data
public class DistributorProductQueryPo {
    /** 产品名称 */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(name = "name", notes = "门票名称", example = "西溪湿地门票")
    private String name;

    /** 景区id */
    @JsonProperty("poi_id")
    @JSONField(name = "poi_id")
    @ApiModelProperty(name = "poi_id", notes = "景区id", example = "12")
    private Long poiId;

    /** 分销商id */
    @JsonProperty("distributor_id")
    @JSONField(name = "distributor_id")
    @ApiModelProperty(name = "distributor_id", notes = " 分销商id ", example = "1")
    private Long distributorId;
}
