package com.cloud.drore.eboos.common.entity.supplier.po;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.base.BaseEntity;
import com.cloud.drore.eboos.jackson.JacksonDateDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 供应商查询财务管理收入明细<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/24 0024 下午 4:42 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Data
public class FinaceSupplierIncomeDetailsCommonPo extends BaseEntity<Long> {
    /**
     * 供应商id
     */
    @JsonProperty("supplier_id")
    @JSONField(name = "supplier_id")
    @ApiModelProperty(name = "supplier_id", notes = "供应商id", example = "1")
    private Long supplierId;

    /**
     * 分销商id
     */
    @JsonProperty("distributor_id")
    @JSONField(name = "distributor_id")
    @ApiModelProperty(name = "distributor_id", notes = "分销商id", example = "109")
    private Long distributorId;

    /**
     * 订单状态(1.待付款 2.已取消 3.已支付 4.退订失败 8.已退订 9.已消费 10.已验证 11.已过期)
     */
    @JsonProperty("order_status")
    @JSONField(name = "order_status")
    @ApiModelProperty(name = "order_status", notes = "订单状态", example = "16")
    private Integer orderStatus;

    /**
     * 上一次结算时间
     */
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("settlement_start_time")
    @JSONField(name = "settlement_start_time", format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "settlement_start_time", notes = "上一次结算时间", example = "2018-1-5 14:38:04")
    private Date settlementStartTime;

    /**
     * 本次结算时间
     */
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("settlement_end_time")
    @JSONField(name = "settlement_end_time", format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "settlement_end_time", notes = "本次结算时间", example = "2018-1-24 11:26:28")
    private Date settlementEndTime;

    /**
     * 供应商应结算单价
     */
    @JsonProperty("supplier_settlement_price")
    @JSONField(name = "supplier_settlement_price")
    @ApiModelProperty(name = "supplier_settlement_price", notes = "供应商应结算单价", example = "20")
    private BigDecimal supplierSettlementPrice;

    /**
     * ota应结算单价
     */
    @JsonProperty("operation_settlement_price")
    @JSONField(name = "operation_settlement_price")
    @ApiModelProperty(name = "operation_settlement_price", notes = "ota应结算单价", example = "89.99")
    private BigDecimal operationSettlementPrice;

    /**
     * 产品编号
     */
    @JsonProperty("product_num")
    @JSONField(name = "product_num")
    @ApiModelProperty(name = "product_num", notes = "产品编号", example = "P3454")
    private String productNum;

}
