package com.cloud.drore.eboss.operation.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.base.BaseEntity;
import com.cloud.drore.eboss.jackson.JacksonDateDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 财务结算的历史事件记录<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/30 0024 下午 4:42 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Data
@Table(name = "eboss_finace_settlement_history")
public class FinaceSettlementHistoryOperation extends BaseEntity<Long> {

    /**
     * 结算期
     */
    @NotBlank(message = "结算期不能为空！")
    @JsonProperty("settlement_stage")
    @JSONField(name = "settlement_stage")
    @ApiModelProperty(name = "settlement_stage", notes = "结算期", example = "2018年1期")
    private String settlementStage;

    /**
     * 结算次数
     */
    @JsonProperty("settlement_count")
    @JSONField(name = "settlement_count")
    @ApiModelProperty(name = "settlement_count", notes = "结算次数", example = "1")
    private int settlementCount;

    /**
     * 结算方式
     */
    @JsonProperty("settlement_type")
    @JSONField(name = "settlement_type")
    @ApiModelProperty(name = "settlement_type", notes = "结算方式", example = "现下支付")
    private String settlementType;

    /**
     * 供应商id
     */
    @JsonProperty("merchant_id")
    @JSONField(name = "merchant_id")
    @ApiModelProperty(name = "merchant_id", notes = "供应商id", example = "1")
    private Long merchantId;

    /**
     * 应结算金额
     */
    @JsonProperty("total_amount_should")
    @JSONField(name = "total_amount_should")
    @ApiModelProperty(name = "total_amount_should", notes = "应结算金额", example = "500")
    private BigDecimal totalAmountShould;

    /**
     * 已结算金额
     */
    @JsonProperty("total_amount_aleady")
    @JSONField(name = "total_amount_aleady")
    @ApiModelProperty(name = "total_amount_aleady", notes = "已结算金额", example = "5000")
    private BigDecimal totalAmountAleady;

    /**
     * 运营商收入金额
     */
    @JsonProperty("total_amount_income")
    @JSONField(name = "total_amount_income")
    @ApiModelProperty(name = "total_amount_income", notes = "运营商收入金额", example = "5000")
    private BigDecimal totalAmountIncome;

    /**
     * 上一次结算时间
     */
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("settlement_start_time")
    @JSONField(name = "settlement_start_time",format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "settlement_start_time", notes = "上一次结算时间", example = "2018-1-5 14:38:04")
    private Date settlementStartTime;

    /**
     * 本次结算时间
     */
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("settlement_end_time")
    @JSONField(name = "settlement_end_time",format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "settlement_end_time", notes = "本次结算时间", example = "2018-1-24 11:26:28")
    private Date settlementEndTime;

    /**
     * 下一次结算时间
     */
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("settlement_next_time")
    @JSONField(name = "settlement_next_time",format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "settlement_next_time", notes = "下一次结算时间", example = "2018-2-5 14:38:04")
    private Date settlementNextTime;

    /**
     * 结算凭证
     */
    @JsonProperty("settlement_voucher")
    @JSONField(name = "settlement_voucher")
    @ApiModelProperty(name = "settlement_voucher", notes = "结算凭证", example = "12")
    private Long settlementVoucher;

    /**
     * 供应商最近一次更新时间
     */
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("recenetly_recharge_time")
    @JSONField(name = "recenetly_recharge_time",format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "recenetly_recharge_time", notes = "供应商最近一次更新时间", example = "2018-2-5 14:38:04")
    private Date recenetlyRechargeTime;


}
