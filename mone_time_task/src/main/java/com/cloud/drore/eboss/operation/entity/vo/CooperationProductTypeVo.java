package com.cloud.drore.eboss.operation.entity.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 合作管理-产品类型<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/2/9 13:47 <br>
 * @Author: <a href="1451173193@qq.com">杨亮</a>
 */
@Data
public class CooperationProductTypeVo {
    /*产品类型名称*/
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty(name = "name", notes = "产品类型名称")
    private String name;
    /*产品类型编码*/
    @JSONField(name = "dic_code")
    @JsonProperty("dic_code")
    @ApiModelProperty(name = "dic_code", notes = "产品类型编码")
    private String dicCode;
}
