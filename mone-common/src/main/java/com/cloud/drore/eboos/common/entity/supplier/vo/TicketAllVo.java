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
 * @CreateDate: Created in 2018/1/16 17:26 <br>
 * @Author: <a href="575842778@qq.com">郑永涛</a>
 */
@Data
public class TicketAllVo {

    /** id */
    @JsonProperty("id")
    @JSONField(name = "id")
    @ApiModelProperty(name = "id", notes = "门票id", example = "8")
    private Long id;

    /** 门票id */
    @JsonProperty("ticket_id")
    @JSONField(name = "ticket_id")
    @ApiModelProperty(name = "ticket_id", notes = "门票id", example = "80")
    private Long ticketId;

    /** 门票名称 */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(name = "name", notes = "门票名称", example = "西溪湿地门票")
    private String name;

    /** 消费点id */
    @JsonProperty("consume_id")
    @JSONField(name = "consume_id")
    @ApiModelProperty(name = "consume_id", notes = "消费点id", example = "80")
    private Long consumeId;

    /** 人群 */
    @JsonProperty("crowd")
    @JSONField(name = "crowd")
    @ApiModelProperty(name = "crowd", notes = "人群", example = "学生")
    private String crowd;

    /** 库存方式 */
    @JsonProperty("stock_method")
    @JSONField(name = "stock_method")
    @ApiModelProperty(name = "stock_method", notes = "库存方式", example = "周期性库存")
    private String stockMethod;

    /** 支付类型 */
    @JsonProperty("payment_type")
    @JSONField(name = "payment_type")
    @ApiModelProperty(name = "payment_type", notes = "支付类型", example = "线上预付")
    private String paymentType;

    /** 使用说明 */
    @JsonProperty("instruction")
    @JSONField(name = "instruction")
    @ApiModelProperty(name = "instruction", notes = "使用说明", example = "使用说明")
    private String instruction;

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

    /** 每个证件至多预定人数 */
    @JsonProperty("max_reservation_per_certificate")
    @JSONField(name = "max_reservation_per_certificate")
    @ApiModelProperty(name = "max_reservation_per_certificate", notes = "每个证件至多预定人数", example = "8")
    private Integer maxReservationPerCertificate;

    /** 发送短信 */
    @JsonProperty("is_send_message")
    @JSONField(name = "is_send_message")
    @ApiModelProperty(name = "is_send_message", notes = "发送短信", example = "y")
    private String isSendMessage;

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

    /** 产品状态 0 未上架 1 已上架 */
    @JsonProperty("status")
    @JSONField(name = "status")
    @ApiModelProperty(name = "status", notes = "产品状态(供应商分页查询参数)", example = "1")
    private String status;

    /** 游玩前一天退票 */
    @JsonProperty("refund_one_day_ago")
    @JSONField(name = "refund_one_day_ago")
    @ApiModelProperty(name = "refund_one_day_ago", notes = "门票是否上架标识", example = "2")
    private BigDecimal refundOneDayAgo;

    /** 游玩前两天退票 */
    @JsonProperty("refund_two_days_ago")
    @JSONField(name = "refund_two_days_ago")
    @ApiModelProperty(name = "refund_two_days_ago", notes = "门票是否上架标识", example = "1")
    private BigDecimal refundTwoDaysAgo;

    /** 游玩前三天及以上退票 */
    @JsonProperty("refund_three_days_ago")
    @JSONField(name = "refund_three_days_ago")
    @ApiModelProperty(name = "refund_three_days_ago", notes = "门票是否上架标识", example = "1")
    private BigDecimal refundThreeDaysAgo;

    /** 产品编号 */
    @JsonProperty("product_num")
    @JSONField(name = "product_num")
    @ApiModelProperty(name = "product_num", notes = "产品编号", example = "T1000")
    private String productNum;

    /** 销售价 */
    @JsonProperty("sales_price")
    @JSONField(name = "sales_price")
    @ApiModelProperty(name = "sales_price", notes = "销售价", example = "80.00")
    private BigDecimal salesPrice;

    /** 结算价 */
    @JsonProperty("settlement_price")
    @JSONField(name = "settlement_price")
    @ApiModelProperty(name = "settlement_price", notes = "结算价", example = "80.00")
    private BigDecimal settlementPrice;

    /** 预定须知 */
    @JsonProperty("predetermined_instructions")
    @JSONField(name = "predetermined_instructions")
    @ApiModelProperty(name = "predetermined_instructions", notes = "预定须知", example = "预定须知")
    private String predeterminedInstructions;

    /** 信息点名称 */
    @JsonProperty("poi_name")
    @JSONField(name = "poi_name")
    @ApiModelProperty(name = "poi_name", notes = "信息点名称(后台业务用)", example = "都江堰景区")
    private String poiName;

    /** 信息点名称 */
    @JsonProperty("poi_id")
    @JSONField(name = "poi_id")
    @ApiModelProperty(name = "poi_id", notes = "信息点名称(后台业务用)", example = "都江堰景区")
    private Long poiId;

    /** 消费点名称 */
    @JsonProperty("consume_name")
    @JSONField(name = "consume_name")
    @ApiModelProperty(name = "consume_name", notes = "消费点名称", example = "都江堰景点")
    private String consumeName;

    /** 价格开始时间 */
    @JsonProperty("start_time")
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JSONField(name = "start_time",format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "start_time", notes = "价格开始时间", example = "2018-01-05 00:00:00")
    private Date startTime;

    /** 价格结束时间 */
    @JsonProperty("end_time")
    @JSONField(name = "end_time")
    @ApiModelProperty(name = "end_time", notes = "价格结束时间", example = "2018-01-05 00:00:00")
    private Date endTime;

    /** 固定费率 */
    @JsonProperty("fixed_rate")
    @JSONField(name = "fixed_rate")
    @ApiModelProperty(name = "fixed_rate", notes = "固定费率", example = "80.00")
    private BigDecimal fixedRate;

    /** 关联公共产品id */
    @JsonProperty("common_product_id")
    @JSONField(name = "common_product_id")
    @ApiModelProperty(name = "common_product_id", notes = "关联公共产品id")
    private Long commonProductId;

    /** 产品类型 */
    @JsonProperty("product_type")
    @JSONField(name = "product_type")
    @ApiModelProperty(name = "product_type", notes = "产品类型", example = "TICKET_PRODUCT")
    private String productType;

    /** 是否实名制 */
    @JsonProperty("is_real_name")
    @JSONField(name = "is_real_name")
    @ApiModelProperty(name = "is_real_name", notes = "是否实名制(0:是，1:不是)")
    private Integer isRealName;

    /** 产品代码 */
    @JsonProperty("product_code")
    @JSONField(name = "product_code")
    @ApiModelProperty(name = "product_code", notes = "产品代码 ", example = "T3000")
    private String productCode;

    /** 驳回原因 */
    @JsonProperty("reject_reason")
    @JSONField(name = "reject_reason")
    @ApiModelProperty(name = "reject_reason", notes = "驳回原因", example = "原因")
    private String rejectReason;

    /** 验证码类型 */
    @Transient
    @JsonProperty("verification_type")
    @JSONField(name = "verification_type")
    @ApiModelProperty(name = "verification_type", notes = "验证码类型")
    private List<String> verificationType;

    /** 是否需要游客信息(畅游通) */
    @JsonProperty("book_person_type")
    @JSONField(name = "book_person_type")
    @ApiModelProperty(name = "book_person_type", notes = "是否需要游客信息(畅游通)", example = "CONTACT_PERSON")
    private String bookPersonType;

}