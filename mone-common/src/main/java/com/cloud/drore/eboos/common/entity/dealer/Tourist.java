package com.cloud.drore.eboos.common.entity.dealer;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Table;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 游客表对应实体类<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/2/26 10:11 <br>
 * @Author: <a href="747639122@qq.com">冯腾</a>
 */
@Data
@Table(name = "eboos_tourist")
public class Tourist extends BaseEntity<Long> {

    /** 游玩人姓名 */
    @JsonProperty("tourist_name")
    @JSONField(name = "tourist_name")
    @ApiModelProperty(name = "tourist_name", notes = "游玩人姓名", example = "张三")
    private String touristName;

    /** 游玩人电话 */
    @JsonProperty("tourist_phone_num")
    @JSONField(name = "tourist_phone_num")
    @ApiModelProperty(name = "tourist_phone_num", notes = "游玩人电话", example = "13087789807")
    private String touristPhoneNum;

    /** 游玩人证件类型 */
    @JsonProperty("tourist_identification_type")
    @JSONField(name = "tourist_identification_type")
    @ApiModelProperty(name = "tourist_identification_type", notes = "游玩人证件类型", example = "ID_CARD")
    private String touristIdentificationType;

    /** 游玩人证件号码 */
    @JsonProperty("tourist_identification_num")
    @JSONField(name = "tourist_identification_num")
    @ApiModelProperty(name = "tourist_identification_num", notes = "游玩人证件号码", example = "723468723648726048357")
    private String touristIdentificationNum;

    /** 订单主键 */
    @JsonProperty("order_id")
    @JSONField(name = "order_id")
    @ApiModelProperty(name = "order_id", notes = "订单主键", example = "16")
    private Long orderId;


}
