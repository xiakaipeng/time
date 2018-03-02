package com.cloud.drore.eboss.operation.entity.po;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.List;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description:门票，组合产品分销商关系维护列表保存接口Po <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/2/2 17:03 <br>
 * @Author: <a href="1451173193@qq.com">杨亮</a>
 */
@Data
public class SaveRelationListPo {
    /*修改的数据列表*/
    @JsonProperty("update_list")
    @JSONField(name = "update_list")
    @ApiModelProperty(name = "update_list", notes = "修改的数据列表")
    private List<ProductToDistributorSettingPo> updateList;

}
