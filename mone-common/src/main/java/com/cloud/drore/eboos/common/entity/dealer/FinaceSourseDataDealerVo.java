package com.cloud.drore.eboos.common.entity.dealer;

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
 * @Description: 分销商收入报表vo<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/24 0024 下午 4:42 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Data
@Table(name = "eboss_finace_form")
public class FinaceSourseDataDealerVo extends BaseEntity<Long> {

    /**
     * 产品编号
     */
    @JsonProperty("product_num")
    @JSONField(name = "product_num")
    @ApiModelProperty(name = "product_num", notes = "产品编号", example = "P3454")
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
     * 分销商id
     */
    @JsonProperty("distributor_id")
    @JSONField(name = "distributor_id")
    @ApiModelProperty(name = "distributor_id", notes = "分销商id", example = "109")
    private Long distributorId;

    /**
     * 分销商名称
     */
    @JsonProperty("distributor_name")
    @JSONField(name = "distributor_name")
    @ApiModelProperty(name = "distributor_name", notes = "分销商名称", example = "携程")
    private String distributorName;


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
    @ApiModelProperty(name = "supplier_name", notes = "供应商名称", example = "西溪湿地")
    private String supplierName;
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


}
