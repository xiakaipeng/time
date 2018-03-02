package com.cloud.drore.eboss.operation.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.base.BaseEntity;
import com.cloud.drore.eboss.jackson.JacksonDateDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

/**
 * 浙江卓锐科技股份有限公司 版权所有 © Copyright 2018<br>
 *
 * @Description: 测试实体类<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/4 12:24 <br>
 * @Author: <a href="836327318@qq.com">吴昌益</a>
 */
@Data
public class Demo extends BaseEntity<Long>{

    @NotBlank(message = "名称不能为空")
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(name = "name", notes = "名称", example = "名称")
    private String name;
    @Min(value = 1,message = "大于等于1")
    @Max(value = 10,message = "小于等于10")
    @JsonProperty("parms")
    @JSONField(name = "parms")
    @ApiModelProperty(name = "parms", notes = "参数", example = "321")
    private Long parms;
    @Length(min=50, max=100,message = "长度必须大于50小于100", groups = SAVE.class)
    @JsonProperty("descript")
    @JSONField(name = "descript")
    @ApiModelProperty(name = "descript", notes = "描述", example = "321")
    private String descript;

    @Transient
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("aa_time")
    @JSONField(name = "aa_time", format = "yyyy-MM-dd HH:mm:ss")
    private Date aaTime;
    public interface SAVE{};
}
