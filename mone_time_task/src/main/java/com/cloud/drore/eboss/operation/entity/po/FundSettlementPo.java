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
 * @Description: 资金结算<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/2/5 0005 下午 6:12 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Data
public class FundSettlementPo extends BaseEntity<Long> {


    /**
     * 供应商id
     */
    @JsonProperty("supplier_id")
    @JSONField(name = "supplier_id")
    @ApiModelProperty(name = "supplier_id", notes = "供应商id", example = "1")
    private Long supplierId;


}