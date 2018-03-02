package com.cloud.drore.eboos.common.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * User: wcy
 * Date: 2017/2/16
 * Time: 16:26
 */
@Data
@Table(name = "eboos_dictionary")
public class Dictionary {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JSONField(name = "dic_code")
    @JsonProperty("dic_code")
    @Column(name = "dic_code")
    @ApiModelProperty(name = "dic_code", notes = "字段code", example = "DRORE_SEX")
    private String dicCode;
    @JSONField(name = "parent_code")
    @JsonProperty("parent_code")
    @Column(name = "parent_code")
    @ApiModelProperty(name = "父节点code", notes = "父节点code", example = "DRORE_FAMLE")
    private String parentCode;
    @JsonProperty("name")
    @Column(name = "name")
    @ApiModelProperty(name = "name", notes = "名称", example = "性别")
    private String name;
    @JsonProperty("description")
    @Column(name = "description")
    @ApiModelProperty(name = "description", notes = "描述", example = "描述")
    private String description;

}
