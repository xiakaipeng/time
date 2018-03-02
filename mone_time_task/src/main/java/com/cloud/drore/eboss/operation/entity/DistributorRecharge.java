package com.cloud.drore.eboss.operation.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Transient;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/19 0019 上午 11:38 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Table(name = "eboss_distributor_recharge_record")
@Data
public class DistributorRecharge extends BaseEntity<Long> {

    /**
     * 分销商id
     */
    @NotNull(message = "分销商id不能为空！")
    @JsonProperty("distributor_id")
    @JSONField(name = "distributor_id")
    @ApiModelProperty(name = "distributor_id", notes = "分销商id", example = "12")
    private Long distributorId;

    /**
     * 分销商名称
     */
    @NotBlank(message = "分销商名称不能为空！")
    @JsonProperty("distributor_name")
    @JSONField(name = "distributor_name")
    @ApiModelProperty(name = "distributor_name", notes = "分销商名称", example = "携程")
    private String distributorName;

    /**
     * 账户余额
     */
    @JsonProperty("account_balance")
    @JSONField(name = "account_balance")
    @ApiModelProperty(name = "account_balance", notes = "账户余额", example = "50.00")
    private BigDecimal accountBalance;

    /**
     * 账户实际到账金额
     */
    @JsonProperty("account_arrival_amount")
    @JSONField(name = "account_arrival_amount")
    @ApiModelProperty(name = "account_arrival_amount", notes = "账户实际到账金额", example = "50.00")
    private BigDecimal accountArrivalAmount;

    /**
     * 充值金额
     */
    @JsonProperty("recharge_amount")
    @JSONField(name = "recharge_amount")
    @ApiModelProperty(name = "recharge_amount", notes = "充值金额", example = "50.00")
    private BigDecimal rechargeAmount;

    /**
     * 充值方式
     */
    @JsonProperty("recharge_method")
    @JSONField(name = "recharge_method")
    @ApiModelProperty(name = "recharge_method", notes = "充值方式", example = "支付宝")
    private String rechargeMethod;

    /**
     * 充值凭证
     */
    @NotBlank(message = "充值凭证不能为空！")
    @JsonProperty("voucher")
    @JSONField(name = "voucher")
    @ApiModelProperty(name = "voucher", notes = "voucher", example = "名称")
    private String voucher;

    /**
     * 充值时间
     */
    @JsonProperty("recharge_time")
    @JSONField(name = "recharge_time", format = "yyyy-MM-dd")
    @ApiModelProperty(name = "recharge_time", notes = "充值时间", example = "2018-01-03")
    private Date rechargeTime;

    /**
     * 操作账号
     */
    @Transient
    @JsonProperty("distributor_account_num")
    @JSONField(name = "distributor_account_num")
    @ApiModelProperty(name = "distributor_account_num", notes = "操作账号", example = "xiecheng2")
    private String distributorAccountNum;

}
