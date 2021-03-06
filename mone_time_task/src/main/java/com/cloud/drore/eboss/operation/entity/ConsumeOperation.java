package com.cloud.drore.eboss.operation.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 消费点实体类<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/5 0005 下午 6:12 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Table(name = "eboos_consume")
@Data
public class ConsumeOperation extends BaseEntity<Long> {

    /**
     * POI的id
     */
    @NotNull(message = "POI的id不能为空！")
    @JsonProperty("consume_poi_id")
    @JSONField(name = "consume_poi_id")
    @ApiModelProperty(name = "consume_poi_id", notes = "POI的id", example = "12")
    private Long consumePoiId;


    /**
     * 商户的id
     */
    @NotNull(message = "商户的id不能为空！")
    @JsonProperty("merchant_id")
    @JSONField(name = "merchant_id")
    @ApiModelProperty(name = "merchant_id", notes = "商户的id", example = "1")
    private Long merchantId;

    /**
     * POI的name
     */
    @NotBlank(message = "POI的name不能为空！")
    @JsonProperty("consume_poi_name")
    @JSONField(name = "consume_poi_name")
    @ApiModelProperty(name = "consume_poi_name", notes = "POI的name", example = "都江堰")
    private String consumePoiName;



    /**
     * 不能少于100字
     */

    @NotNull(message = "描述不能为空！",groups = ConsumeOperation.SAVE.class)
    @NotBlank(message = "一句话简介不能为空！")
    @JsonProperty("description")
    @JSONField(name = "description")
    @ApiModelProperty(name = "description", notes = "一句话简介", example = "石龙飞瀑真是漂亮！")
    private String description;

    /**
     * 消费点详细地址
     */
    @JsonProperty("detail_address")
    @JSONField(name = "detail_address")
    @ApiModelProperty(name = "detail_address", notes = "消费点地址", example = "浙大西溪校区")
    private String detailAddress;


    /**
     * 消费点名称
     */
    @NotBlank(message = "消费点名称不能为空！")
    @JsonProperty("consume_name")
    @JSONField(name = "consume_name")
    @ApiModelProperty(name = "consume_name", notes = "消费点名称", example = "都江堰")
    private String consumeName;

    /**
     * 联系人
     */
    @NotBlank(message = "联系人不能为空！")
    @JsonProperty("link_man")
    @JSONField(name = "link_man")
    @ApiModelProperty(name = "link_man", notes = "联系人", example = "冯腾")
    private String linkMan;


    /**
     * 联系电话
     */
    @NotBlank(message = "联系电话不能为空！")
    @JsonProperty("link_tel")
    @JSONField(name = "link_tel")
    @ApiModelProperty(name = "link_tel", notes = "联系电话", example = "18888888888")
    private String linkTel;

    /**
     * 消费点编号
     */
    @Transient
    private String consumeNum;

    public interface SAVE {
    }
}