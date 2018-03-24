package com.cloud.drore.eboos.common.entity.operation.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 财务结算的时候从订单产品表中取到的数据源<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/24 0024 下午 4:42 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Data
public class FinaceSourseDataListVo extends BaseEntity<Long> {
    /**
     * 分销商结算需要的集合
     */
    @JsonProperty("distributor_list")
    @JSONField(name = "distributor_list")
    @ApiModelProperty(name = "distributor_list", notes = "分销商结算需要的集合")
    private List<FinaceSourseDistributorDataVo> distributorList;

    /**
     * 供应商结算需要的集合
     */
    @JsonProperty("supplier_list")
    @JSONField(name = "supplier_list")
    @ApiModelProperty(name = "supplier_list", notes = "供应商结算需要的集合")
    private List<FinaceSourseDataVo> supplierList;
}
