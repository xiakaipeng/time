package com.cloud.drore.eboss.operation.entity.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.entity.base.DictionaryVo;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 商户字典表VO实体类<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/12 0012 下午 7:21 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Data
public class DictionaryMerchantVo {

    /**
     * 销售产品类型
     */
    @JSONField(name = "dictionary_goods_sale_type")
    @JsonProperty("dictionary_goods_sale_type")
    @ApiModelProperty(name = "dictionary_goods_sale_type", notes = "销售产品类型 ",example = "销售产品类型字典信息")
    private List<DictionaryVo> dictionaryGoodsSaleType;

    /**
     * 商户类型
     */
    @JSONField(name = "dictionary_merchant_type")
    @JsonProperty("dictionary_merchant_type")
    @ApiModelProperty(name = "dictionary_merchant_type", notes = "商户类型 ",example = "商户类型字典信息")
    private List<DictionaryVo> dictionaryMerchantType;

    /**
     * 商户行业
     */
    @JSONField(name = "dictionary_merchant_industry")
    @JsonProperty("dictionary_merchant_industry")
    @ApiModelProperty(name = "dictionary_merchant_industry", notes = "商户行业 ",example = "商户行业字典信息")
    private List<DictionaryVo> dictionaryMerchantIndustry;

    /**
     * 经营性质  BUSINESS_NATURE
     */
    @JSONField(name = "dictionary_business_nature")
    @JsonProperty("dictionary_business_nature")
    @ApiModelProperty(name = "dictionary_business_nature", notes = "经营性质 ",example = "经营性质字典信息")
    private List<DictionaryVo> dictionaryBusinessNature;


    /**
     * 商户性质
     */
    @JSONField(name = "dictionary_merchant_character")
    @JsonProperty("dictionary_merchant_character")
    @ApiModelProperty(name = "dictionary_merchant_character", notes = "商户性质 ",example = "商户性质字典信息")
    private List<DictionaryVo> dictionaryMerchantCharacter;

    /**
     * 管理员类型
     */
    @JSONField(name = "dictionary_merchant_manager")
    @JsonProperty("dictionary_merchant_manager")
    @ApiModelProperty(name = "dictionary_merchant_manager", notes = "商户管理员类型 ",example = "商户管理员类型字典信息")
    private List<DictionaryVo> dictionaryMerchantManager;

}
