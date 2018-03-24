package com.cloud.drore.eboos.common.entity.dealer;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 显示分销商下拉列表的Vo<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/2/9 15:45 <br>
 * @Author: <a href="747639122@qq.com">冯腾</a>
 */
@Data
public class DistributorVo {

    /** 分销商id */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(name = "id", notes = "分销商id",example = "1")
    private Long id;

    /** 分销名称 */
    @JsonProperty("merchant_name")
    @JSONField(name = "merchant_name")
    @ApiModelProperty(name = "merchant_name", notes = "分销商id",example = "XY")
    private String merchantName;
}
