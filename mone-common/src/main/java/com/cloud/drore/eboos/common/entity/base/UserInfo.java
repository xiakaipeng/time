package com.cloud.drore.eboos.common.entity.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 浙江卓锐科技股份有限公司 版权所有 © Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/2/28 16:06 <br>
 * @Author: <a href="836327318@qq.com">吴昌益</a>
 */
@Data
public class UserInfo {
    private Long id;
    private Long typeId;
    @JsonProperty("user_name")
    @JSONField(name = "user_name")
    @ApiModelProperty(name = "user_name", notes = "用户名", example = "angela")
    private String userName;
    @JsonProperty("tenant_id")
    @JSONField(name = "tenant_id")
    @ApiModelProperty(name = "tenant_id", notes = "租户", example = "1")
    private String tenantId;
    @ApiModelProperty(name = "status", notes = "状态（正式1、废弃-1）", example = "1")
    private Integer status;
    @ApiModelProperty(name = "type", notes = "DEALER,OPERATION,SUPPLIER", example = "DEALER")
    private String type;
    @JsonProperty("is_admin")
    @JSONField(name = "is_admin")
    @ApiModelProperty(name = "is_admin", notes = "0普通用户,1超级用户", example = "0")
    private int isAdmin=0;
    //职位
    @ApiModelProperty(name = "position", notes = "职位", example = "经理")
    private String position;
    @ApiModelProperty(name = "area", notes = "区域", example = "杭州")
    private String area;
}
