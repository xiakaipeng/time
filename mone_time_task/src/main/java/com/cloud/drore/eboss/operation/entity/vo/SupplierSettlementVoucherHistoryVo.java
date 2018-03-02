package com.cloud.drore.eboss.operation.entity.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.base.BaseEntity;
import com.cloud.drore.eboss.jackson.JacksonDateDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 供应商结算历史记录凭证vo<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/24 0024 下午 4:42 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Data
public class SupplierSettlementVoucherHistoryVo extends BaseEntity<Long> {

    /**
     * 供应商id
     */
    @JsonProperty("supplier_id")
    @JSONField(name = "supplier_id")
    @ApiModelProperty(name = "supplier_id", notes = "供应商id", example = "1")
    private Long supplierId;

    /**
     * 供应商名称
     */
    @JsonProperty("supplier_name")
    @JSONField(name = "supplier_name")
    @ApiModelProperty(name = "supplier_name", notes = "供应商名称", example = "天台山")
    private String supplierName;
    /**
     * 关联结算记录的id
     */
    @JsonProperty("finace_settlement_history_id")
    @JSONField(name = "finace_settlement_history_id")
    @ApiModelProperty(name = "finace_settlement_history_id", notes = "关联结算记录的id", example = "62")
    private Long finaceSettlementHistoryId;

    /**
     * 充值凭证对应的金额
     */
    @JsonProperty("settlement_amount")
    @JSONField(name = "settlement_amount")
    @ApiModelProperty(name = "settlement_amount", notes = "充值凭证对应的金额", example = "5000")
    private BigDecimal settlementAmount;

    /**
     * 充值日期
     */
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("settlement_time")
    @JSONField(name = "settlement_time", format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "settlement_time", notes = "上一次结算时间", example = "2018-01-05 13:25:46")
    private Date settlementTime;

    /**
     * 充值凭证
     */
    @NotBlank(message = "充值凭证不能为空")
    @JsonProperty("voucher")
    @JSONField(name = "voucher")
    @ApiModelProperty(name = "voucher", notes = "关联结算记录的id", example = "voucher")
    private String voucher;

    /**
     * 操作账号
     */
    @JsonProperty("supplier_account_num")
    @JSONField(name = "supplier_account_num")
    @ApiModelProperty(name = "supplier_account_num", notes = "操作账号", example = "tiantaishan22")
    private String supplierAccountNum;

}
