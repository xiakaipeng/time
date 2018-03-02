package com.cloud.drore.eboss.operation.entity.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.entity.base.DictionaryVo;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: POI类型字典表VO实体类<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/12 0012 下午 7:21 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Data
public class DictionaryPOIVo {

    /**
     * POI类型
     */
    @JSONField(name = "poi_type")
    @JsonProperty("poi_type")
    @ApiModelProperty(name = "poi_type", notes = "POI类型 ", example = "POI类型类型字典信息")
    private List<DictionaryVo> POIType;
}
