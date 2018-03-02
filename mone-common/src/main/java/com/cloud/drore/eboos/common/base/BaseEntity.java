package com.cloud.drore.eboos.common.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.data.domain.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User: wcy
 * Date: 2017/9/5
 * Time: 15:30
 */
@Data
public class BaseEntity<ID extends Serializable> extends AbstractEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 当前数据是否被删除 0未删除 1 已删除
     */
    @ApiModelProperty(hidden = true)
    @Column(name = "is_deleted")
    @JsonProperty("is_deleted")
    @JSONField(name = "is_deleted")
    private Integer isDeleted =0;

}
