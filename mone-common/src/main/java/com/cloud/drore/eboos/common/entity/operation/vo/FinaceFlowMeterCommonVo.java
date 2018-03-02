package com.cloud.drore.eboos.common.entity.operation.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 财务结算的流水统计<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/24 0024 下午 4:42 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Data
public class FinaceFlowMeterCommonVo extends BaseEntity<Long> {

    /**
     * 分销商id
     */
    @JsonProperty("distributor_id")
    @JSONField(name = "distributor_id")
    @ApiModelProperty(name = "distributor_id", notes = "分销商id", example = "22")
    private Long distributorId;

    /**
     * 分销商名称
     */
    @JsonProperty("merchant_name")
    @JSONField(name = "merchant_name")
    @ApiModelProperty(name = "merchant_name", notes = "分销商名称", example = "携程")
    private String merchantName;


    /**
     * 已消费，已验证，已过期价格之和（应收款合计）
     */
    @JsonProperty("total_amount_should")
    @JSONField(name = "total_amount_should")
    @ApiModelProperty(name = "total_amount_should", notes = "应收款合计", example = "5000")
    private BigDecimal totalAmountShould;

    /**
     * 应付款合计（已退款）
     */
    @JsonProperty("total_amount_settlement")
    @JSONField(name = "total_amount_settlement")
    @ApiModelProperty(name = "total_amount_settlement", notes = "应付款合计", example = "5000")
    private BigDecimal totalAmountSettlement;


}
