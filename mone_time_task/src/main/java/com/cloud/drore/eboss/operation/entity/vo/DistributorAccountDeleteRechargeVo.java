package com.cloud.drore.eboss.operation.entity.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 运营商删除分销商充值记录信息<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/29 14:59 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Data
public class DistributorAccountDeleteRechargeVo {
    /**
     * 账户余额
     */
    @JsonProperty("distributor_account_amount")
    @JSONField(name = "distributor_account_amount")
    @ApiModelProperty(name = "distributor_account_amount", notes = "账户余额", example = "10000")
    private BigDecimal distributorAccountAmount;

    /**
     * 分销商id
     */
    @JsonProperty("distributor_id")
    @JSONField(name = "distributor_id")
    @ApiModelProperty(name = "distributor_id", notes = "分销商id", example = "25")
    private Long distributorId;

}
