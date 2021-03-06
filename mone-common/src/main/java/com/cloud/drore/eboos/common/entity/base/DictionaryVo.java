package com.cloud.drore.eboos.common.entity.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 浙江卓锐科技股份有限公司 版权所有 © Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/13 14:45 <br>
 * @Author: <a href="836327318@qq.com">吴昌益</a>
 */
@Data
@Table(name = "eboos_dictionary")
public class DictionaryVo {
    @JSONField(name = "dic_code")
    @JsonProperty("dic_code")
    @Column(name = "dic_code")
    @ApiModelProperty(name = "dic_code", notes = "字段code", example = "DRORE_SEX")
    private String dicCode;
    @JsonProperty("name")
    @Column(name = "name")
    @ApiModelProperty(name = "name", notes = "名称", example = "性别")
    private String name;
}
