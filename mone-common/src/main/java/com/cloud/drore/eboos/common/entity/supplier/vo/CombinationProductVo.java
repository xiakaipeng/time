package com.cloud.drore.eboos.common.entity.supplier.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.jackson.JacksonDateDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/18 9:39 <br>
 * @Author: <a href="575842778@qq.com">郑永涛</a>
 */
@Data
public class CombinationProductVo {

    /** 退款手续费(1.不收取手续费,2.固定费率) */
    @JsonProperty("refund_fee")
    @JSONField(name = "refund_fee")
    @ApiModelProperty(name = "refund_fee", notes = "退款手续费", example = "FIXED_RATE")
    private String refundFee;

    /** 退款模式(1.未消费随时可退 2.不可退 3.人工审核) */
    @JsonProperty("refund_model")
    @JSONField(name = "refund_model")
    @ApiModelProperty(name = "refund_model", notes = "退款模式", example = "NOT_REFUNDABLE")
    private String refundModel;

    /** 产品有效期开始时间 */
    @JsonProperty("term_of_validity_start_time")
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JSONField(name = "term_of_validity_start_time",format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "term_of_validity_start_time", notes = "产品有效期开始时间", example = "2018-01-05 00:00:00")
    private Date termOfValidityStartTime;

    /** 产品有效期结束时间 */
    @JsonProperty("term_of_validity_end_time")
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JSONField(name = "term_of_validity_end_time",format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "term_of_validity_end_time", notes = "产品有效期结束时间", example = "2018-01-05 00:00:00")
    private Date termOfValidityEndTime;

    /** 产品名称 */
    @JsonProperty("product_name")
    @JSONField(name = "product_name")
    @ApiModelProperty(name = "product_name", notes = "产品名称", example = "门票")
    private String productName;

    /** 支付类型 */
    @JsonProperty("payment_type")
    @JSONField(name = "payment_type")
    @ApiModelProperty(name = "payment_type", notes = "支付类型", example = "线上支付")
    private String paymentType;

    /** 库存方式 */
    @JsonProperty("stock_method")
    @JSONField(name = "stock_method")
    @ApiModelProperty(name = "stock_method", notes = "库存方式", example = "库存不限")
    private String stockMethod;

    /** 产品人群 */
    @JsonProperty("product_crowd")
    @JSONField(name = "product_crowd")
    @ApiModelProperty(name = "product_crowd", notes = "产品人群", example = "学生")
    private String productCrowd;

    /** 使用说明 */
    @JsonProperty("instruction")
    @JSONField(name = "instruction")
    @ApiModelProperty(name = "instruction", notes = "使用说明", example = "使用说明")
    private String instruction;

    /** 搭配门票 */
    @JsonProperty("with_ticket")
    @JSONField(name = "with_ticket")
    @ApiModelProperty(name = "with_ticket", notes = "搭配门票", example = "y")
    private String withTicket;

    /** 搭配住宿 */
    @JsonProperty("with_room")
    @JSONField(name = "with_room")
    @ApiModelProperty(name = "with_room", notes = "搭配住宿", example = "y")
    private String withRoom;

    /** 销售价 */
    @JsonProperty("sales_price")
    @JSONField(name = "sales_price")
    @ApiModelProperty(name = "sales_price", notes = "销售价", example = "10.00")
    private BigDecimal salesPrice;

    /** 结算价 */
    @JsonProperty("settlement_price")
    @JSONField(name = "settlement_price")
    @ApiModelProperty(name = "settlement_price", notes = "结算价", example = "10.00")
    private BigDecimal settlementPrice;

    /** 结束时间 */
    @JsonProperty("end_time")
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JSONField(name = "end_time",format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "end_time", notes = "结束时间", example = "2018-1-5 14:38:04")
    private Date endTime;

    /** 开始时间 */
    @JsonProperty("start_time")
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JSONField(name = "start_time",format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "start_time", notes = "开始时间", example = "2018-1-5 14:38:04")
    private Date startTime;

    /** 信息点名称 */
    @JsonProperty("poi_name")
    @JSONField(name = "poi_name")
    @ApiModelProperty(name = "poi_name", notes = "信息点名称(后台业务用)", example = "都江堰景区")
    private String poiName;

    /** 消费点名称 */
    @JsonProperty("consume_name")
    @JSONField(name = "consume_name")
    @ApiModelProperty(name = "consume_name", notes = "消费点名称", example = "都江堰景点")
    private String consumeName;

    /** 组合产品id */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(name = "id", notes = "组合产品id", example = "10")
    private Long id;

    /** 组合产品是否上架标识 */
    @JsonProperty("status")
    @JSONField(name = "status")
    @ApiModelProperty(name = "status", notes = "组合产品是否上架标识", example = "1")
    private String status;

    /** 产品编号 */
    @JsonProperty("product_num")
    @JSONField(name = "product_num")
    @ApiModelProperty(name = "product_num", notes = "产品编号", example = "10")
    private String productNum;

    /** 预定须知 */
    @JsonProperty("booking_notice")
    @JSONField(name = "booking_notice")
    @ApiModelProperty(name = "booking_notice", notes = "预定须知", example = "预定须知")
    private String bookingNotice;

    /** 关联公共产品id */
    @JsonProperty("common_product_id")
    @JSONField(name = "common_product_id")
    @ApiModelProperty(name = "common_product_id", notes = "关联公共产品id")
    private Long commonProductId;

    /** 是否实名制 */
    @JsonProperty("is_real_name")
    @JSONField(name = "is_real_name")
    @ApiModelProperty(name = "is_real_name", notes = "是否实名制(0:是，1:不是)")
    private Integer isRealName;

    /** 游玩前一天退票 */
    @JsonProperty("refund_one_day_ago")
    @JSONField(name = "refund_one_day_ago")
    @ApiModelProperty(name = "refund_one_day_ago", notes = "游玩前一天退票", example = "2")
    private BigDecimal refundOneDayAgo;

    /** 游玩前两天退票 */
    @JsonProperty("refund_two_days_ago")
    @JSONField(name = "refund_two_days_ago")
    @ApiModelProperty(name = "refund_two_days_ago", notes = "游玩前两天退票", example = "1")
    private BigDecimal refundTwoDaysAgo;

    /** 游玩前三天及以上退票 */
    @JsonProperty("refund_three_days_ago")
    @JSONField(name = "refund_three_days_ago")
    @ApiModelProperty(name = "refund_three_days_ago", notes = "门票是否上架标识", example = "1")
    private BigDecimal refundThreeDaysAgo;

    /** 固定费率 */
    @JsonProperty("fixed_rate")
    @JSONField(name = "fixed_rate")
    @ApiModelProperty(name = "fixed_rate", notes = "固定费率", example = "80.00")
    private BigDecimal fixedRate;

    /** 验证码类型 */
    @Transient
    @JsonProperty("verification_type")
    @JSONField(name = "verification_type")
    @ApiModelProperty(name = "verification_type", notes = "验证码类型")
    private List<String> verificationType;

    /** 消费点和poi名称集合 */
    @Transient
    private List<ConsumeAndPoiNameVo> consumeAndPoiNameVoList;
}