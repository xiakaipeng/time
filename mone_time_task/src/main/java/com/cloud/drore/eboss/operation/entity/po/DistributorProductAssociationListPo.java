package com.cloud.drore.eboss.operation.entity.po;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboss.operation.entity.DistributorProductAssociation;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 合作管理新增<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/2/10 10:23 <br>
 * @Author: <a href="1451173193@qq.com">杨亮</a>
 */
@Data
public class DistributorProductAssociationListPo {
    /**
     * 新增列表
     */
    @JsonProperty("insert_list")
    @JSONField(name = "insert_list")
    @ApiModelProperty(name = "insert_list", notes = "新增列表")
    private List<DistributorProductAssociation> insertList;


}
