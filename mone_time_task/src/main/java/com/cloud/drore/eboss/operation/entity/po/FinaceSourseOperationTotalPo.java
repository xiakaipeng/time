package com.cloud.drore.eboss.operation.entity.po;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.base.BaseEntity;
import com.cloud.drore.eboos.jackson.JacksonDateDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;


/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 通过供应商id和结算期查询运营商的结算记录<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/24 0024 下午 4:42 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Data
public class FinaceSourseOperationTotalPo extends BaseEntity<Long> {

    /**
     * 供应商id
     */
    @NotNull(message = "供应商id不能为空")
    @JsonProperty("supplier_id")
    @JSONField(name = "supplier_id")
    @ApiModelProperty(name = "supplier_id", notes = "供应商id", example = "1")
    private Long supplierId;


    /**
     * 期数
     */
    @JsonProperty("settlement_stage")
    @JSONField(name = "settlement_stage")
    @ApiModelProperty(name = "settlement_stage", notes = "期数", example = "2018年58期")
    private String settlementStage;

}
