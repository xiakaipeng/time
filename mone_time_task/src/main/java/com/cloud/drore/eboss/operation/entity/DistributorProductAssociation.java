package com.cloud.drore.eboss.operation.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.data.domain.AbstractEntity;
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
 * @Description: 合作管理新增<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/2/10 10:23 <br>
 * @Author: <a href="1451173193@qq.com">杨亮</a>
 */
@Data
@Table(name = "eboos_distributor_product_association")
public class DistributorProductAssociation extends AbstractEntity {
    /**
     * 公共表id
     */
    @JsonProperty("main_id")
    @JSONField(name = "main_id")
    @ApiModelProperty(name = "main_id", notes = "公共表id", example = "10")
    private Long mainId;

    /**
     * 结算价
     */
    @JsonProperty("settlement_price")
    @JSONField(name = "settlement_price")
    @ApiModelProperty(name = "settlement_price", notes = "结算价", example = "10.00")
    private BigDecimal settlementPrice;

    /**
     * 分销商id
     */
    @JsonProperty("distributor_id")
    @JSONField(name = "distributor_id")
    @ApiModelProperty(name = "distributor_id", notes = "分销商id", example = "10")
    private Long distributorId;

    /** 销售价 */
//    @JsonProperty("sales_price")
//    @JSONField(name = "sales_price")
//    @ApiModelProperty(name = "sales_price", notes = "销售价", example = "10.00")
//    private BigDecimal salesPrice;

    /**
     * 产品名称
     */
    @JsonProperty("product_name")
    @JSONField(name = "product_name")
    @ApiModelProperty(name = "product_name", notes = "产品名称", example = "门票产品")
    private String productName;
    /**
     * 产品库存
     */
    @JsonProperty("product_stock")
    @JSONField(name = "product_stock")
    @ApiModelProperty(name = "product_stock", notes = "产品库存", example = "22")
    private Integer productStock;
    /*有效期开始时间*/
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("term_of_validity_start_time")
    @JSONField(name = "term_of_validity_start_time", format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "term_of_validity_start_time", notes = "有效期开始时间", example = "2018-02-06 11:20:05")
    private Date termOfValidityStartTime;
    /*有效期结束时间*/
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("term_of_validity_end_time")
    @JSONField(name = "term_of_validity_end_time", format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "term_of_validity_end_time", notes = "有效期结束时间", example = "2018-02-16 11:20:05")
    private Date termOfValidityEndTime;
}
