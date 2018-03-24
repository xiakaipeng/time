package com.cloud.drore.eboos.common.entity.dealer;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 用于封装进TicketOrderInitVo的供应商、分销商Vo<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/20 16:19 <br>
 * @Author: <a href="747639122@qq.com">冯腾</a>
 */
@Data
public class MerchantVo {

    /** id */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(name = "id", notes = "id",example = "1")
    private Long id;

    /** 名称 */
    @JsonProperty("merchant_name")
    @JSONField(name = "merchant_name")
    @ApiModelProperty(name = "merchant_name", notes = "名称",example = "XY")
    private String merchantName;

}
