package com.cloud.drore.eboss.operation.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.sql.Time;
import java.util.Date;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: POI区域实体类<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/5 0005 下午 6:12 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Table(name = "eboos_poi")
@Data
public class POIOperation extends BaseEntity<Long> {


    /**
     * POI名称
     */
    @NotBlank(message = "POI名称不能为空并且不能重名！")
    @JsonProperty("poi_name")
    @JSONField(name = "poi_name")
    @ApiModelProperty(name = "poi_name", notes = "POI名称", example = "都江堰")
    private String poiName;


    /**
     * 供应商商户id
     */
    @NotNull(message = "供应商商户id不能为空！")
    @JsonProperty("merchant_id")
    @JSONField(name = "merchant_id")
    @ApiModelProperty(name = "merchant_id", notes = "供应商商户id", example = "1")
    private Long merchantId;

    /**
     * 供应商商户名称
     */
    @NotNull(message = "供应商商户名称不能为空！")
    @JsonProperty("merchant_name")
    @JSONField(name = "merchant_name")
    @ApiModelProperty(name = "merchant_name", notes = "供应商商户名称", example = "都江堰")
    private String merchantName;

    /**
     * 联系人
     */
    @NotBlank(message = "联系人名称不能为空！")
    @JsonProperty("link_man")
    @JSONField(name = "link_man")
    @ApiModelProperty(name = "link_man", notes = "联系人", example = "冯腾")
    private String linkMan;

    /**
     * 联系电话
     */
    @NotBlank(message = "联系电话不能为空！")
    @JsonProperty("telephone")
    @JSONField(name = "telephone")
    @ApiModelProperty(name = "telephone", notes = "联系电话", example = "18888888888")
    private String telephone;

    /**
     * 地址省
     */
    @NotBlank(message = "地址省不能为空！")
    @JsonProperty("area_address_province")
    @JSONField(name = "area_address_province")
    @ApiModelProperty(name = "area_address_province", notes = "地址省", example = "浙江省")
    private String areaAddressProvince;

    /**
     * 地址市
     */
    @NotBlank(message = "地址市不能为空！")
    @JsonProperty("area_address_city")
    @JSONField(name = "area_address_city")
    @ApiModelProperty(name = "area_address_city", notes = "地址市", example = "杭州市")
    private String areaAddressCity;

    /**
     * 地址县
     */
    @NotBlank(message = "地址县不能为空！")
    @JsonProperty("area_address_city_county")
    @JSONField(name = "area_address_city_county")
    @ApiModelProperty(name = "area_address_city_county", notes = "地址县", example = "建德市")
    private String areaAddressCityCounty;
    /**
     * 详细地址
     */
    @JsonProperty("detail_address")
    @JSONField(name = "detail_address")
    @ApiModelProperty(name = "detail_address", notes = "详细地址", example = "五常大道龙舌嘴")
    private String detailAddress;

    /**
     * 经度
     */
    @JsonProperty("longitude")
    @JSONField(name = "longitude")
    @ApiModelProperty(name = "longitude", notes = "经度", example = "45°")
    private String longitude;

    /**
     * 纬度
     */
    @JsonProperty("latitude")
    @JSONField(name = "latitude")
    @ApiModelProperty(name = "latitude", notes = "纬度", example = "45°")
    private String latitude;


    /**
     * 开放时间
     */
    @JsonProperty("open_time")
    @JSONField(name = "open_time", format = "HH:mm:ss")
    @ApiModelProperty(name = "open_time", notes = "开放时间", example = "08:30:10")
    private Time openTime;

    /**
     * 结束时间
     */
    @JsonProperty("end_time")
    @JSONField(name = "end_time", format = "HH:mm:ss")
    @ApiModelProperty(name = "end_time", notes = "开放时间", example = "18:30:10")
    private Time endTime;


    /**
     * poi类型
     */
    @NotBlank(message = "poi类型不能为空！")
    @JsonProperty("poi_type")
    @JSONField(name = "poi_type")
    @ApiModelProperty(name = "poi_type", notes = "poi类型", example = "0")
    private String poiType;

    /**
     * 客服电话
     */
    @NotBlank(message = "客服电话不能为空！")
    @JsonProperty("customer_tel")
    @JSONField(name = "customer_tel")
    @ApiModelProperty(name = "customer_tel", notes = "客服电话", example = "0571-88888888")
    private String customerTel;

    /**
     * 封面图
     */
    @NotBlank(message = "封面图不能为空！")
    @JsonProperty("covermap_url")
    @JSONField(name = "covermap_url")
    @ApiModelProperty(name = "covermap_url", notes = "封面图", example = "covermap_url")
    private String covermapUrl;

    /**
     * 方形封面图
     */
    @JsonProperty("covermap_square_url")
    @JSONField(name = "covermap_square_url")
    @ApiModelProperty(name = "covermap_square_url", notes = "方形封面图", example = "covermap_square_url")
    private String covermapSquareUrl;

    /**
     * 相册
     */
    @NotBlank(message = "相册不能为空！")
    @JsonProperty("album_url")
    @JSONField(name = "album_url")
    @ApiModelProperty(name = "album_url", notes = "相册", example = "album_url")
    private String albumUrl;

    /**
     * 景区介绍文字
     */
    @NotBlank(message = "景区介绍不能为空！")
    @JsonProperty("scenica_introduction_text")
    @JSONField(name = "scenica_introduction_text")
    @ApiModelProperty(name = "scenica_introduction_text", notes = "景区介绍", example = "如何吸引用户的目光让人眼前一亮的印象，请用心为本店做详情介绍吧（15字以上）……")
    private String scenicaIntroductionText;


    /**
     * 验证说明
     */
    @NotBlank(message = "验证说明不能为空！")
    @JsonProperty("verification_instructions")
    @JSONField(name = "verification_instructions")
    @ApiModelProperty(name = "verification_instructions", notes = "验证说明", example = "我在验证……")
    private String verificationInstructions;


    /**
     * 状态(1有效、0禁用)
     */
    @JsonProperty("status")
    @JSONField(name = "status")
    @ApiModelProperty(name = "status", notes = "状态(1有效、0禁用)", example = "0")
    private Integer status;

    public interface SAVE {
    }

}