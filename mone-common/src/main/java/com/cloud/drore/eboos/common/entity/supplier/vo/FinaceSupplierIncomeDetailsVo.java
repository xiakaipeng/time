package com.cloud.drore.eboos.common.entity.supplier.vo;

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
public class FinaceSupplierIncomeDetailsVo extends BaseEntity<Long> {

    /**
     * 分销商id
     */
    @JsonProperty("distributor_id")
    @JSONField(name = "distributor_id")
    @ApiModelProperty(name = "distributor_id", notes = "分销商id", example = "1")
    private Long distributorId;

    /**
     * 分销商名称
     */
    @JsonProperty("distributor_name")
    @JSONField(name = "distributor_name")
    @ApiModelProperty(name = "distributor_name", notes = "分销商名称", example = "携程")
    private String distributorName;

    /**
     * 产品名称
     */
    @JsonProperty("product_name")
    @JSONField(name = "product_name")
    @ApiModelProperty(name = "product_name", notes = "产品名称", example = "洪源门票")
    private String productName;
    /**
     * 订单编号
     */
    @JsonProperty("order_num")
    @JSONField(name = "order_num")
    @ApiModelProperty(name = "order_num", notes = "订单编号", example = "XC3457863475683")
    private String orderNum;


    /**
     * 订单状态
     */
    @JsonProperty("order_status")
    @JSONField(name = "order_status")
    @ApiModelProperty(name = "order_status", notes = "订单状态", example = "16")
    private Integer orderStatus;

    /**
     * 订单状态中文
     */
    @JsonProperty("order_status_name")
    @JSONField(name = "order_status_name")
    @ApiModelProperty(name = "order_status_name", notes = "订单状态中文", example = "取票")
    private String orderStatusName;

    /**
     * 本次结算时间
     */
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("created_date")
    @JSONField(name = "created_date", format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "created_date", notes = "本次结算时间", example = "2018-1-23")
    private Date createdDate;

    /**
     * 供应商应结算单价
     */
    @JsonProperty("supplier_settlement_price")
    @JSONField(name = "supplier_settlement_price")
    @ApiModelProperty(name = "supplier_settlement_price", notes = "供应商应结算单价", example = "40")
    private BigDecimal supplierSettlementPrice;


}
