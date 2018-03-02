package com.cloud.drore.eboss.operation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 商户关联表实体类<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/8 0008 下午 2:06 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Data
@Table(name = "eboos_merchant_multi")
public class MerchantMulti extends BaseEntity<Long> {

    /**
     * 商户id
     */
    @JsonProperty("merchant_id")
    @JSONField(name = "merchant_id")
    @ApiModelProperty(name = "merchant_id", notes = "商户id", example = "名称")
    private Long merchantId;

    /**
     * code
     */
    @JsonProperty("dic_code")
    @JSONField(name = "dic_code")
    @ApiModelProperty(name = "dic_code", notes = "code", example = "名称")
    private String dicCode;

    /**
     * 状态
     */
    @JsonProperty("state")
    @JSONField(name = "state")
    @ApiModelProperty(name = "state", notes = "状态", example = "名称")
    private String state;

    /**
     * code对应的名称
     */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(name = "name", notes = "code对应的名称", example = "名称")
    private String name;

}