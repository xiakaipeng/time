package com.cloud.drore.eboss.operation.entity.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 合作管理-分销商列表-修改分销商产品vo<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/2/8 17:18 <br>
 * @Author: <a href="1451173193@qq.com">杨亮</a>
 */
@Data
public class DistributorsAllRelationVo {
    /*分销商id*/
    @JSONField(name = "relation_id")
    @JsonProperty("relation_id")
    @ApiModelProperty(name = "relation_id", notes = "关联id")
    private Long relationId;
    /*产品编码*/
    @JSONField(name = "product_num")
    @JsonProperty("product_num")
    @ApiModelProperty(name = "product_num", notes = "产品编码")
    private String productNum;
    /*产品名称*/
    @JSONField(name = "product_name")
    @JsonProperty("product_name")
    @ApiModelProperty(name = "product_name", notes = "产品名称")
    private String productName;

    /*景区名称*/
    @JSONField(name = "poi_name")
    @JsonProperty("poi_name")
    @ApiModelProperty(name = "poi_name", notes = "景区名称")
    private String poiName;

    /*产品类型*/
    @JSONField(name = "product_type")
    @JsonProperty("product_type")
    @ApiModelProperty(name = "product_type", notes = "产品类型")
    private String productType;

    /*销售价格*/
    @JSONField(name = "sales_price")
    @JsonProperty("sales_price")
    @ApiModelProperty(name = "sales_price", notes = "销售价格")
    private BigDecimal salesPrice;
}
