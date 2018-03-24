package com.cloud.drore.eboos.data.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

/**
 * User: wcy
 * Date: 2017/9/7
 * Time: 10:25
 */

public abstract class AbstractEntity<ID extends Serializable> implements Auditable<String, ID>,Versionable {

    @Column(name = "created_date")
    @JsonProperty("created_date")
    @JSONField(name = "created_date")
    @ApiModelProperty(hidden = true)
    private Date createdDate;
    @ApiModelProperty(hidden = true)
    private long version;
    @Column(name = "created_by")
    @JsonProperty("created_by")
    @JSONField(name = "created_by")
    @ApiModelProperty(hidden = true)
    private long createdBy;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public String getCreatedBy() {
        return createdBy+"";
    }

    public void setCreatedBy(String var1) {

    }

    public String getLastModifiedBy() {
        return null;
    }

    public void setLastModifiedBy(String s) {

    }

    public Date getLastModifiedDate() {
        return null;
    }

    public void setLastModifiedDate(Date var1) {

    }

    public ID getId() {
        return null;
    }

    public boolean isNew() {
        return false;
    }
}
