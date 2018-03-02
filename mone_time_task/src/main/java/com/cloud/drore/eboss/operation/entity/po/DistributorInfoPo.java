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
 * @Description: 运营商_分销商列表实体<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/29 14:59 <br>
 * @Author: <a href="1451173193@qq.com">杨亮</a>
 */
@Data
public class DistributorInfoPo {
    /*分销商编码*/
    @JsonProperty("distributor_num")
    @JSONField(name = "distributor_num")
    @ApiModelProperty(name = "distributor_num", notes = "分销商编码", example = "dx001")
    private String distributorNum;
    /*分销商名称*/
    @JsonProperty("distributor_name")
    @JSONField(name = "distributor_name")
    @ApiModelProperty(name = "distributor_name", notes = "分销商名称", example = "西溪湿地")
    private String distributorName;

}
