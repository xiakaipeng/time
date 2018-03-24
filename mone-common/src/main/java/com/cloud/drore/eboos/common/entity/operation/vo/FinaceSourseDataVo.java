package com.cloud.drore.eboos.common.entity.operation.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.base.BaseEntity;
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
 * @Description: 财务结算的时候从订单产品表中取到的数据源<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/24 0024 下午 4:42 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Data
@Table(name = "eboss_finace_form")
public class FinaceSourseDataVo extends BaseEntity<Long> {

    /**
     * 产品编号
     */
    @JsonProperty("product_num")
    @JSONField(name = "product_num")
    @ApiModelProperty(name = "product_num", notes = "产品编号", example = "NBFteng")
    private String productNum;

    /**
     * 产品名称
     */
    @JsonProperty("product_name")
    @JSONField(name = "product_name")
    @ApiModelProperty(name = "product_name", notes = "商品名称", example = "牛逼冯腾")
    private String productName;


    /**
     * 产品人群
     */
    @JsonProperty("crowd")
    @JSONField(name = "crowd")
    @ApiModelProperty(name = "crowd", notes = "适用人群", example = "老年人")
    private String crowd;


    /**
     * 供应商id
     */
    @JsonProperty("supplier_id")
    @JSONField(name = "supplier_id")
    @ApiModelProperty(name = "supplier_id", notes = "供应商id", example = "19")
    private Long supplierId;


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
    @JsonProperty("distributor_name")
    @JSONField(name = "distributor_name")
    @ApiModelProperty(name = "distributor_name", notes = "分销商名称", example = "携程")
    private String distributorName;

    /**
     * 交易数量
     */
    @JsonProperty("purchase_count")
    @JSONField(name = "purchase_count")
    @ApiModelProperty(name = "purchase_count", notes = "订单数量", example = "999")
    private int purchaseCount;


    /**
     * 供应商应结算单价
     */
    @JsonProperty("supplier_settlement_price")
    @JSONField(name = "supplier_settlement_price")
    @ApiModelProperty(name = "supplier_settlement_price", notes = "供应商应结算", example = "40")
    private BigDecimal supplierSettlementPrice;

    /**
     * ota应结算单价
     */
    @JsonProperty("operation_settlement_price")
    @JSONField(name = "operation_settlement_price")
    @ApiModelProperty(name = "operation_settlement_price", notes = "应结算", example = "50")
    private BigDecimal operationSettlementPrice;

    /**
     * ota销售单价
     */
    @JsonProperty("sales_price")
    @JSONField(name = "sales_price")
    @ApiModelProperty(name = "sales_price", notes = "ota销售单价", example = "50")
    private BigDecimal salesPrice;


    /**
     * 供应商结算总额 total_amount_should_supplier
     */
    @JsonProperty("total_amount_settlement_supplier")
    @JSONField(name = "total_amount_settlement_supplier")
    @ApiModelProperty(name = "total_amount_settlement_supplier", notes = "结算价", example = "1500")
    private BigDecimal totalAmountSettlementSupplier;

    /**
     * ota结算总额
     */
    @JsonProperty("total_amount_settlement_ota")
    @JSONField(name = "total_amount_settlement_ota")
    @ApiModelProperty(name = "total_amount_settlement_ota", notes = "结算价", example = "3000")
    private BigDecimal totalAmountSettlementOta;

    /**
     * ota销售总额
     */
    @JsonProperty("total_amount_sales_price")
    @JSONField(name = "total_amount_sales_price")
    @ApiModelProperty(name = "total_amount_sales_price", notes = "结算价", example = "4000")
    private BigDecimal totalAmountSalesPrice;

    /**
     * 期数id
     */
    @JsonProperty("finace_settlement_history_id")
    @JSONField(name = "finace_settlement_history_id")
    @ApiModelProperty(name = "finace_settlement_history_id", notes = "期数id", example = "12")
    private Long finaceSettlementHistoryId;

    /**
     * 上一次结算时间
     */
    @JsonDeserialize(using = com.cloud.drore.eboos.jackson.JacksonDateDeserializer.class)
    @JsonProperty("settlement_start_time")
    @JSONField(name = "settlement_start_time", format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "settlement_start_time", notes = "上一次结算时间", example = "2018-1-5 14:38:04")
    private Date settlementStartTime;

    /**
     * 本次结算时间
     */
    @JsonDeserialize(using = com.cloud.drore.eboos.jackson.JacksonDateDeserializer.class)
    @JsonProperty("settlement_end_time")
    @JSONField(name = "settlement_end_time", format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "settlement_end_time", notes = "本次结算时间", example = "2018-1-24 11:26:28")
    private Date settlementEndTime;

}
