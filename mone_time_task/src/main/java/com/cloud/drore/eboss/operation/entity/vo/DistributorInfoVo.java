package com.cloud.drore.eboss.operation.entity.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 运营商_分销商列表实体<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/29 14:59 <br>
 * @Author: <a href="1451173193@qq.com">杨亮</a>
 */
@Data
public class DistributorInfoVo {
    /*分销商id*/
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(name = "id", notes = "分销商id", example = "1")
    private Long id;
    /*分销商类型*/
    @JsonProperty("distributor_type")
    @JSONField(name = "distributor_type")
    @ApiModelProperty(name = "distributor_type", notes = "分销商类型", example = "OTA")
    private String distributorType;
    /*分销商名称*/
    @JsonProperty("distributor_name")
    @JSONField(name = "distributor_name")
    @ApiModelProperty(name = "distributor_name", notes = "分销商名称", example = "西溪湿地")
    private String distributorName;
    /*分销商编号*/
    @JsonProperty("distributor_num")
    @JSONField(name = "distributor_num")
    @ApiModelProperty(name = "distributor_num", notes = "分销商编号", example = "DX001")
    private String distributorNum;
    /*联系人*/
    @JsonProperty("link_man")
    @JSONField(name = "link_man")
    @ApiModelProperty(name = "link_man", notes = "联系人", example = "冯腾")
    private String linkMan;
    /*手机号*/
    @JsonProperty("mobile")
    @JSONField(name = "mobile")
    @ApiModelProperty(name = "mobile", notes = "手机号", example = "18072750743")
    private String mobile;

}
