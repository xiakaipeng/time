package com.cloud.drore.eboos.common.entity.dealer;

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
 * @Description: 财务结算的时候从订单产品表中取到的数据源<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/24 0024 下午 4:42 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Data
@Table(name = "eboos_order_product")
public class FinaceSourseDataOperationVo extends BaseEntity<Long> {

    /**
     * 商品名称
     */
    @JsonProperty("product_name")
    @JSONField(name = "product_name")
    @ApiModelProperty(name = "product_name", notes = "商品名称", example = "牛逼冯腾")
    private String productName;

    /**
     * 产品编号
     */
    @JsonProperty("product_num")
    @JSONField(name = "product_num")
    @ApiModelProperty(name = "product_num", notes = "产品编号", example = "NBFteng")
    private String productNum;


    /**
     * 适用人群
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
     * 应商供名称
     */
    @JsonProperty("supplier_name")
    @JSONField(name = "supplier_name")
    @ApiModelProperty(name = "supplier_name", notes = "应商供名称", example = "都江堰")
    private String supplierName;

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
     * 结算价
     */
    @JsonProperty("settlement_price")
    @JSONField(name = "settlement_price")
    @ApiModelProperty(name = "settlement_price", notes = "结算价", example = "15")
    private BigDecimal settlementPrice;

    /**
     * 所属订单状态
     */
    @JsonProperty("order_status")
    @JSONField(name = "order_status")
    @ApiModelProperty(name = "order_status", notes = "所属订单状态", example = "已消费")
    private String orderStatus;

    /**
     * 订单主键id
     */
    @JsonProperty("order_id")
    @JSONField(name = "order_id")
    @ApiModelProperty(name = "order_id", notes = "订单主键id", example = "12")
    private Long orderId;


    /**
     * 实退金额
     */
    @JsonProperty("actually_refund")
    @JSONField(name = "actually_refund")
    @ApiModelProperty(name = "actually_refund", notes = "实退金额", example = "5")
    private BigDecimal actuallyRefund;

    /**
     * 交易数量
     */
    @JsonProperty("settlement_count")
    @JSONField(name = "settlement_count")
    @ApiModelProperty(name = "settlement_count", notes = "交易数量", example = "15")
    private BigDecimal settlementCount;

    /**
     * 应付总额
     */
    @JsonProperty("settlement_total_amount")
    @JSONField(name = "settlement_total_amount")
    @ApiModelProperty(name = "settlement_total_amount", notes = "应付总额", example = "15000")
    private BigDecimal settlementTotalAmount;

}
