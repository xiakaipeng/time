package com.cloud.drore.eboos.common.entity.supplier;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.base.BaseEntity;
import com.cloud.drore.eboos.common.entity.operation.Consume;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.List;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 产品关联实体类<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/8 10:36 <br>
 * @Author: <a href="575842778@qq.com">郑永涛</a>
 */
@Data
@Table(name = "eboos_product")
public class ProductRelation extends BaseEntity<Long> {

    /** 产品类型（门票产品，住宿产品，组合产品） */
    @JsonProperty("product_type")
    @JSONField(name = "product_type")
    @ApiModelProperty(name = "product_type", notes = "产品类型", example = "门票产品")
    private String productType;

    /** 产品单价 */
    @JsonProperty("product_unit_price")
    @JSONField(name = "product_unit_price")
    @ApiModelProperty(name = "product_unit_price", notes = "产品单价", example = "10.00")
    private BigDecimal productUnitPrice;

    /** 产品剩余库存 */
    @JsonProperty("product_surplus_stock")
    @JSONField(name = "product_surplus_stock")
    @ApiModelProperty(name = "product_surplus_stock", notes = "产品剩余库存", example = "10")
    private Integer productSurplusStock;

    /** 产品名称 */
    @JsonProperty("product_name")
    @JSONField(name = "product_name")
    @ApiModelProperty(name = "product_name", notes = "产品名称", example = "门票")
    private String productName;

    /** 产品主体 */
    @JsonProperty("product_body")
    @JSONField(name = "product_body")
    @ApiModelProperty(name = "product_body", notes = "产品主体", example = "门票")
    private String productBody;

    /** 产品id */
    @JsonProperty("product_id")
    @JSONField(name = "product_id")
    @ApiModelProperty(name = "product_id", notes = "产品id", example = "10")
    private Long productId;

    /** 商户id */
    @JsonProperty("merchant_id")
    @JSONField(name = "merchant_id")
    @ApiModelProperty(name = "merchant_id", notes = "商户id", example = "10")
    private Long merchantId;

    /** 消费点id */
    @JsonProperty("consume_id")
    @JSONField(name = "consume_id")
    @ApiModelProperty(name = "consume_id", notes = "消费点id", example = "10")
    private String consumeId;

    /** 人群 */
    @JsonProperty("crowd")
    @JSONField(name = "crowd")
    @ApiModelProperty(name = "crowd", notes = "人群", example = "学生")
    private String crowd;

    /** 使用说明 */
    @JsonProperty("instruction")
    @JSONField(name = "instruction")
    @ApiModelProperty(name = "instruction", notes = "使用说明", example = "使用说明")
    private String instruction;

    /** 验证码类型 */
    @JsonProperty("verification_code_type")
    @JSONField(name = "verification_code_type")
    @ApiModelProperty(name = "verification_code_type", notes = "验证码类型", example = "二维码")
    private String verificationCodeType;

    /** 产品编号 */
    @JsonProperty("product_num")
    @JSONField(name = "product_num")
    @ApiModelProperty(name = "product_num", notes = "产品编号", example = "t188")
    private String productNum;

    /** 购票须知 */
    @JsonProperty("predetermined_instructions")
    @JSONField(name = "predetermined_instructions")
    @ApiModelProperty(name = "predetermined_instructions", notes = "购票须知", example = "购票须知")
    private String predeterminedInstructions;

    /** 产品状态  */
    @JsonProperty("status")
    @JSONField(name = "status")
    @ApiModelProperty(name = "status", notes = "产品状态", example = "THE_SHELVES")
    private String status;

    /** 库存方式 */
    @JsonProperty("stock_method")
    @JSONField(name = "stock_method")
    @ApiModelProperty(name = "stock_method", notes = "库存方式", example = "CYCLICAL_INVENTORY")
    private String stockMethod;

    /** 支付类型 */
    @JsonProperty("payment_type")
    @JSONField(name = "payment_type")
    @ApiModelProperty(name = "payment_type", notes = "支付类型", example = "ONLINE_PREPAYMENT")
    private String paymentType;

    /** 退款手续费(1.不收取手续费,2.固定费率) */
    @JsonProperty("refund_fee")
    @JSONField(name = "refund_fee")
    @ApiModelProperty(name = "refund_fee", notes = "退款手续费", example = "FIXED_RATE")
    private String refundFee;

    /** 退款模式(1.未消费随时可退 2.不可退 3.人工审核) */
    @JsonProperty("refund_model")
    @JSONField(name = "refund_model")
    @ApiModelProperty(name = "refund_model", notes = "退款模式", example = "NOT_REFUNDABLE")
    private String refundModel;

    /** 结算价 */
    @JsonProperty("supplier_settlement_price")
    @JSONField(name = "supplier_settlement_price")
    @ApiModelProperty(name = "supplier_settlement_price", notes = "结算价", example = "80.00")
    private BigDecimal supplierSettlementPrice;

    /** 消费点信息集合 */
    @Transient
    private List<Consume> consumeList;

    /** 是否实名制 */
    @JsonProperty("is_real_name")
    @JSONField(name = "is_real_name")
    @ApiModelProperty(name = "is_real_name", notes = "是否实名制(0:是，1:不是)")
    private Integer isRealName;

    public interface SAVE{};

}