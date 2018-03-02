package com.cloud.drore.eboss.operation.entity.po;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.base.BaseEntity;
import com.cloud.drore.eboss.jackson.JacksonDateDeserializer;
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
 * @Description: 供应商手动结算需要上传的参数<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/30 0024 下午 4:42 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Data
public class SupplierSettlementDoPo extends BaseEntity<Long> {

    /**
     * 结算始时间
     */
    @JsonProperty("supplier_settlement_time")
    @JSONField(name = "supplier_settlement_time", format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "supplier_settlement_time", notes = "结算始时间", example = "2018-01-30")
    private Date supplierSettlementTime;

    /**
     * 供应商id
     */
    @NotNull(message = "供应商id不能为空")
    @JsonProperty("supplier_id")
    @JSONField(name = "supplier_id")
    @ApiModelProperty(name = "supplier_id", notes = "供应商id", example = "1")
    private Long supplierId;

}
