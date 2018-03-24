package com.cloud.drore.eboos.common.entity.dealer.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: OTA获取产品信息接口入参<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/3/8 10:34 <br>
 * @Author: <a href="1451173193@qq.com">杨亮</a>
 */
@Data
public class OTAGetProductRequest {
    /** 分销商id */
    @JsonProperty("distributor_id")
    @JSONField(name = "distributor_id")
    @ApiModelProperty(name = "distributor_id", notes = "分销商id", example = "109")
    private Long distributorId;
    /** method */
    @JsonProperty("method")
    @JSONField(name = "method")
    @ApiModelProperty(name = "method", notes = "处理方式（method为all时取所有接口，single时取单个接口）", example = "ALL")
    private String method;
    /** 产品类型 */
    @JsonProperty("product_type")
    @JSONField(name = "product_type")
    @ApiModelProperty(name = "product_type", notes = "产品类型（门票产品或者组合产品）", example = "TICKET_PRODUCT")
    private String productType;
    /** 产品编号 */
    @JsonProperty("product_num")
    @JSONField(name = "product_num")
    @ApiModelProperty(name = "product_num", notes = "产品编号", example = "T27")
    private String productNum;
}
