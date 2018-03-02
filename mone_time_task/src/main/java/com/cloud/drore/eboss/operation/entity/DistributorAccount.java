package com.cloud.drore.eboss.operation.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.base.BaseEntity;
import com.cloud.drore.eboss.jackson.JacksonDateDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/17 0017 上午 9:19 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Table(name = "eboss_distributor_account")
@Data
public class DistributorAccount extends BaseEntity<Long> {

    /**
     * 分销商id
     */
    @JsonProperty("distributor_id")
    @JSONField(name = "distributor_id")
    @ApiModelProperty(name = "distributor_id", notes = "分销商id", example = "17")
    private Long distributorId;

    /**
     * 分销商名称
     */
    @JsonProperty("distributor_name")
    @JSONField(name = "distributor_name")
    @ApiModelProperty(name = "distributor_name", notes = "分销商名称", example = "携程")
    private String distributorName;

    /**
     * 账户余额
     */
    @JsonProperty("account_balance")
    @JSONField(name = "account_balance")
    @ApiModelProperty(name = "account_balance", notes = "账户余额", example = "5000.00")
    private BigDecimal accountBalance;

    /**
     * 账户最低余额限制
     */
    @JsonProperty("account_min_balance")
    @JSONField(name = "account_min_balance")
    @ApiModelProperty(name = "account_min_balance", notes = "账户最低余额限制", example = "5000.00")
    private BigDecimal accountMinBalance;

    /**
     * 最近一次充值时间
     */
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("recent_recharge_time")
    @JSONField(name = "recent_recharge_time", format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "recent_recharge_time", notes = "最近一次充值时间", example = "2017-01-05 16:23:56")
    private Date recentRechargeTime;

}
