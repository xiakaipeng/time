package com.cloud.drore.eboss.operation.entity.po;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 供应算根据供应商id和结算历史记录表id结算历史记录查询<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/2/5 0005 下午 6:12 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Data
public class SupplierRechargeHistoryPo extends BaseEntity<Long> {


    /**
     * 供应商id
     */
    @NotNull(message = "供应商id不能为空")
    @JsonProperty("supplier_id")
    @JSONField(name = "supplier_id")
    @ApiModelProperty(name = "supplier_id", notes = "供应商id", example = "1")
    private Long supplierId;


    /**
     * 结算历史记录表id
     */

    @NotNull(message = "结算历史记录表id不能为空")
    @JsonProperty("settlement_stage_id")
    @JSONField(name = "settlement_stage_id")
    @ApiModelProperty(name = "settlement_stage_id", notes = "结算历史记录表id", example = "62")
    private Long settlementStageId;

}