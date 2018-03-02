package com.cloud.drore.eboss.operation.entity.po;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 运营商查询供应商账单实体类<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/24 0024 下午 4:42 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Data
public class FinaceSourseDataOperationPo extends BaseEntity<Long> {

    /**
     * 产品编号
     */
    @JsonProperty("product_num")
    @JSONField(name = "product_num")
    @ApiModelProperty(name = "product_num", notes = "产品编号", example = "P3454")
    private String productNum;


    /**
     * 供应商id(必传)
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
    @ApiModelProperty(name = "distributor_id", notes = "分销商id", example = "22")
    private Long distributorId;

    /**
     * 上一次结算时间(必传)
     */
    @JsonDeserialize(using = com.cloud.drore.eboos.jackson.JacksonDateDeserializer.class)
    @JsonProperty("settlement_start_time")
    @JSONField(name = "settlement_start_time", format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "settlement_start_time", notes = "上一次结算时间", example = "2018-01-05 14:38:04")
    private Date settlementStartTime;

    /**
     * 本次结算时间(必传)
     */
    @JsonDeserialize(using = com.cloud.drore.eboos.jackson.JacksonDateDeserializer.class)
    @JsonProperty("settlement_end_time")
    @JSONField(name = "settlement_end_time", format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "settlement_end_time", notes = "本次结算时间", example = "2018-01-30 11:26:28")
    private Date settlementEndTime;
}
