package com.cloud.drore.eboos.common.entity.operation;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 浙江卓锐科技股份有限公司 版权所有 © Copyright 2018<br>
 *
 * @Description: 用来接收对象用于转hashmap的对象<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/3/13 14:45 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Data
public class HashMapVo {
    @JSONField(name = "id")
    @JsonProperty("id")
    @ApiModelProperty(name = "id", notes = "key", example = "12")
    private String id;
    @JsonProperty("name")
    @ApiModelProperty(name = "name", notes = "value", example = "性别")
    private String name;
}
