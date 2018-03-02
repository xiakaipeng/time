package com.cloud.drore.eboos.common.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * User: wcy
 * Date: 2017/10/27
 * Time: 15:56
 */
@Data
public class PagePo<T> {

    @JsonProperty("page_num")
    @JSONField(name = "page_num")
    @ApiModelProperty(name = "page_num", notes = "当前页", example = "0")
    private Integer pageNum = 0;
    @JsonProperty("page_size")
    @JSONField(name = "page_size")
    @ApiModelProperty(name = "page_size", notes = "行数", example = "20")
    private Integer pageSize = 20;
    private T fields;
    @JsonProperty("sort_type")
    @JSONField(name = "sort_type")
    @ApiModelProperty(name = "sort_type", notes = "正序:ASC,逆序：DESC", example = "DESC")
    private String sortType;
    @JsonProperty("sort_fields")
    @JSONField(name = "sort_fields")
    @ApiModelProperty(name = "sort_fields", notes = "正序:ASC,逆序：DESC", example = "id,create_date")
    private String sortFields;
}
