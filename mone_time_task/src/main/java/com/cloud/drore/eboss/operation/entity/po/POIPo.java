package com.cloud.drore.eboss.operation.entity.po;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


import javax.persistence.Table;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: POI区域实体类<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/5 0005 下午 6:12 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Table(name = "eboos_poi")
@Data
public class POIPo extends BaseEntity<Long> {


    /**
     * poi类型
     */
    @JsonProperty("poi_type")
    @JSONField(name = "poi_type")
    @ApiModelProperty(name = "poi_type", notes = "poi类型", example = "SCENIC_CONSUME_TYPE")
    private String poiType;


}