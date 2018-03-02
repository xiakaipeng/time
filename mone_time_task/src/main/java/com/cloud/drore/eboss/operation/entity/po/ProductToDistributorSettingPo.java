package com.cloud.drore.eboss.operation.entity.po;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboss.jackson.JacksonDateDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 运营商_门票产品_设置运营商vo<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/30 14:59 <br>
 * @Author: <a href="1451173193@qq.com">杨亮</a>
 */
@Data
public class ProductToDistributorSettingPo {
    /*分销商id*/
    @JsonProperty("distributor_id")
    @JSONField(name = "distributor_id")
    @ApiModelProperty(name = "distributor_id", notes = "分销商id", example = "1")
    private Long distributorId;
    /*产品主表id*/
    @JsonProperty("main_id")
    @JSONField(name = "main_id")
    @ApiModelProperty(name = "main_id", notes = "产品主表id", example = "1")
    private Long mainId;
    /*关联表id（eboos_distributor_product_association）*/
    @JsonProperty("relation_id")
    @JSONField(name = "relation_id")
    @ApiModelProperty(name = "relation_id", notes = "分销商id", example = "1")
    private Long relationId;
    /*产品名称*/
    @JsonProperty("product_name")
    @JSONField(name = "product_name")
    @ApiModelProperty(name = "product_name", notes = "产品名称", example = "1")
    private String productName;
    /*市场价*/
    @JsonProperty("sales_price")
    @JSONField(name = "sales_price")
    @ApiModelProperty(name = "sales_price", notes = "市场价", example = "55")
    private BigDecimal salesPrice;
    /*结算价*/
    @JsonProperty("settlement_price")
    @JSONField(name = "settlement_price")
    @ApiModelProperty(name = "settlement_price", notes = "结算价", example = "66")
    private BigDecimal settlementPrice;
    /*库存*/
//    @JsonProperty("product_stock")
//    @JSONField(name = "product_stock")
//    @ApiModelProperty(name = "product_stock", notes = "库存", example = "1")
//    private Integer productStock;
    /*有效期开始时间*/
    @NotNull(message = "有效期开始时间不能为空！")
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("term_of_validity_start_time")
    @JSONField(name = "term_of_validity_start_time",format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "term_of_validity_start_time", notes = "有效期开始时间", example = "2018-02-06 11:20:05")
    private Date termOfValidityStartTime;
//    /*有效期结束时间*/
    @NotNull(message = "有效期结束时间不能为空！")
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("term_of_validity_end_time")
    @JSONField(name = "term_of_validity_end_time",format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "term_of_validity_end_time", notes = "有效期结束时间", example = "2018-02-16 11:20:05")
    private Date termOfValidityEndTime;


}
