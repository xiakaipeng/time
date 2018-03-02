package com.cloud.drore.eboss.operation.entity.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboss.jackson.JacksonDateDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 添加产品关联关系 <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/2/9 16:27 <br>
 * @Author: <a href="1451173193@qq.com">杨亮</a>
 */
@Data
public class CooperationManagementAddVo {
    /**
     * 公共表id
     */
    @JsonProperty("main_id")
    @JSONField(name = "main_id")
    @ApiModelProperty(name = "main_id", notes = "公共表id", example = "10")
    private Long mainId;
    /**
     * 分销商id
     */
    @JsonProperty("distributor_id")
    @JSONField(name = "distributor_id")
    @ApiModelProperty(name = "distributor_id", notes = "分销商id", example = "10")
    private Long distributorId;
    /*产品名称*/
    @JSONField(name = "product_name")
    @JsonProperty("product_name")
    @ApiModelProperty(name = "product_name", notes = "产品名称")
    private String productName;
    /*产品人群*/
    @JSONField(name = "product_crowd")
    @JsonProperty("product_crowd")
    @ApiModelProperty(name = "product_crowd", notes = "产品人群")
    private String productCrowd;
    /*消费点*/
    @JSONField(name = "product_consume_name")
    @JsonProperty("product_consume_name")
    @ApiModelProperty(name = "product_consume_name", notes = "消费点")
    private String productConsumeName;
    /*结算价*/
    @JsonProperty("settlement_price")
    @JSONField(name = "settlement_price")
    @ApiModelProperty(name = "settlement_price", notes = "结算价", example = "123")
    private BigDecimal settlementPrice;
    /*库存*/
    @JsonProperty("product_stock")
    @JSONField(name = "product_stock")
    @ApiModelProperty(name = "product_stock", notes = "库存", example = "0")
    private Integer productStock;
    /*有效期开始时间*/
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("term_of_validity_start_time")
    @JSONField(name = "term_of_validity_start_time",format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "term_of_validity_start_time", notes = "有效期开始时间", example = "2018-02-06 11:20:05")
    private Date termOfValidityStartTime;
    /*有效期结束时间*/
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("term_of_validity_end_time")
    @JSONField(name = "term_of_validity_end_time",format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "term_of_validity_end_time", notes = "有效期结束时间", example = "2018-02-16 11:20:05")
    private Date termOfValidityEndTime;
}
