package com.cloud.drore.eboos.common.entity.supplier;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.base.BaseEntity;
import com.cloud.drore.eboos.jackson.JacksonDateDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 门票实体类<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/8 10:36 <br>
 * @Author: <a href="575842778@qq.com">郑永涛</a>
 */
@Data
@Table(name = "eboos_ticket")
public class Ticket extends BaseEntity<Long> {

    /** 门票名称 */
    @JsonProperty("name")
    @JSONField(name = "name")
    @ApiModelProperty(name = "name", notes = "门票名称", example = "西溪湿地门票")
    private String name;

    /** 消费点id */
    @JsonProperty("consume_id")
    @JSONField(name = "consume_id")
    @ApiModelProperty(name = "consume_id", notes = "消费点id", example = "14")
    private Long consumeId;

    /** 人群 */
    @JsonProperty("crowd")
    @JSONField(name = "crowd")
    @ApiModelProperty(name = "crowd", notes = "人群", example = "学生")
    private String crowd;

    /** 库存方式 */
    @JsonProperty("stock_method")
    @JSONField(name = "stock_method")
    @ApiModelProperty(name = "stock_method", notes = "库存方式", example = "CYCLICAL_INVENTORY")
    private String stockMethod;

    /** 支付类型 */
    @JsonProperty("payment_type")
    @JSONField(name = "payment_type")
    @ApiModelProperty(name = "payment_type", notes = "支付类型", example = "ONLINE_PREPAYMENT")
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

    /** 门票状态  */
    @JsonProperty("status")
    @JSONField(name = "status")
    @ApiModelProperty(name = "status", notes = "门票状态", example = "THE_SHELVES")
    private String status;

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

    /** 产品编号 */
    @JsonProperty("product_num")
    @JSONField(name = "product_num")
    @ApiModelProperty(name = "product_num", notes = "产品编号", example = "T1000")
    private String productNum;

    /** 预定须知 */
    @JsonProperty("predetermined_instructions")
    @JSONField(name = "predetermined_instructions")
    @ApiModelProperty(name = "predetermined_instructions", notes = "预定须知", example = "预定须知")
    private String predeterminedInstructions;

    /** 固定费率 */
    @JsonProperty("fixed_rate")
    @JSONField(name = "fixed_rate")
    @ApiModelProperty(name = "fixed_rate", notes = "固定费率", example = "80.00")
    private BigDecimal fixedRate;

    /** 驳回原因 */
    @JsonProperty("reject_reason")
    @JSONField(name = "reject_reason")
    @ApiModelProperty(name = "reject_reason", notes = "驳回原因", example = "原因")
    private String rejectReason;

    /** 供应商分销的产品总量(畅游通) */
    @JsonProperty("count")
    @JSONField(name = "count")
    @ApiModelProperty(name = "count", notes = "供应商分销的产品总量(畅游通)", example = "1")
    private Integer count;

    /** 景区名称(畅游通) */
    @JsonProperty("sight_name")
    @JSONField(name = "sight_name")
    @ApiModelProperty(name = "sight_name", notes = "景区名称(畅游通)", example = "西溪湿地")
    private String sightName;

    /** 目的地(畅游通) */
    @JsonProperty("city")
    @JSONField(name = "city")
    @ApiModelProperty(name = "city", notes = "目的地(畅游通)", example = "杭州")
    private String city;

    /** 提前预定天数(畅游通) */
    @JsonProperty("book_advance_day")
    @JSONField(name = "book_advance_day")
    @ApiModelProperty(name = "book_advance_day", notes = "提前预定天数(畅游通)", example = "1")
    private Integer bookAdvanceDay;

    /** 提前预定时间(畅游通) */
    @JsonProperty("book_advance_time")
    @JSONField(name = "book_advance_time")
    @ApiModelProperty(name = "book_advance_time", notes = "提前预定时间(畅游通)", example = "1")
    private Date bookAdvanceTime;

    /** 预定后几小时入园(畅游通) */
    @JsonProperty("use_advance_hour")
    @JSONField(name = "use_advance_hour")
    @ApiModelProperty(name = "use_advance_hour", notes = "预定后几小时入园(畅游通)", example = "2")
    private Integer useAdvanceHour;

    /** 不支付自动取消时间(畅游通) */
    @JsonProperty("auto_cancel_time")
    @JSONField(name = "auto_cancel_time")
    @ApiModelProperty(name = "auto_cancel_time", notes = "不支付自动取消时间(畅游通)", example = "2")
    private Integer autoCancelTime;

    /** 是否需要游客信息(畅游通) */
    @JsonProperty("book_person_type")
    @JSONField(name = "book_person_type")
    @ApiModelProperty(name = "book_person_type", notes = "是否需要游客信息(畅游通)", example = "CONTACT_PERSON")
    private String bookPersonType;

    /** 每几个游客共享一个游客信息(畅游通) */
    @JsonProperty("visit_person_required_for_quantity")
    @JSONField(name = "visit_person_required_for_quantity")
    @ApiModelProperty(name = "visit_person_required_for_quantity", notes = "每几个游客共享一个游客信息(畅游通)", example = "2")
    private Integer visitPersonRequiredForQuantity;

    /** 有效期限制(畅游通) */
    @JsonProperty("valid_type")
    @JSONField(name = "valid_type")
    @ApiModelProperty(name = "valid_type", notes = "有效期限制(畅游通)", example = "2")
    private String validType;

    /** 不支付自动取消时间(畅游通) */
    @JsonProperty("days_after_use_date_valid")
    @JSONField(name = "days_after_use_date_valid")
    @ApiModelProperty(name = "days_after_use_date_valid", notes = "不支付自动取消时间(畅游通)", example = "2")
    private Integer daysAfterUseDateValid;

    /** 游客选定的游玩日期起几天内有效(畅游通) */
    @JsonProperty("use_date")
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JSONField(name = "use_date",format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "use_date", notes = "游客选定的游玩日期起几天内有效(畅游通) ", example = "2018-1-5 14:38:04")
    private Date useDate;

    /** 票面价(畅游通) */
    @JsonProperty("market_price")
    @JSONField(name = "market_price")
    @ApiModelProperty(name = "market_price", notes = "票面价(畅游通) ", example = "2.0")
    private BigDecimal marketPrice;

    /** 销售价(畅游通) */
    @JsonProperty("sell_price")
    @JSONField(name = "sell_price")
    @ApiModelProperty(name = "sell_price", notes = "销售价(畅游通) ", example = "2.0")
    private BigDecimal sellPrice;

    /** 是否支持退款(畅游通) */
    @JsonProperty("can_refund")
    @JSONField(name = "can_refund")
    @ApiModelProperty(name = "can_refund", notes = "是否支持退款(畅游通) ", example = "TRUE")
    private String canRefund;

    /** 是否支持过去退款(畅游通) */
    @JsonProperty("can_overdue_refund")
    @JSONField(name = "can_overdue_refund")
    @ApiModelProperty(name = "can_overdue_refund", notes = "是否支持过去退款(畅游通) ", example = "TRUE")
    private String canOverdueRefund;

    /** 最晚有效期前几天几点可退款(畅游通) */
    @JsonProperty("refund_apply_time_before_valid_end_day")
    @JSONField(name = "refund_apply_time_before_valid_end_day")
    @ApiModelProperty(name = "refund_apply_time_before_valid_end_day", notes = "最晚有效期前几天几点可退款(畅游通) ", example = "12")
    private String refundApplyTimeBeforeValidEndDay;

    /** 退款手续费(畅游通) */
    @JsonProperty("refund_charge")
    @JSONField(name = "refund_charge")
    @ApiModelProperty(name = "refund_charge", notes = "退款手续费(畅游通) ", example = "12")
    private String refundCharge;

    /** 退款手续费类型(畅游通) */
    @JsonProperty("refund_charge_type")
    @JSONField(name = "refund_charge_type")
    @ApiModelProperty(name = "refund_charge_type", notes = "退款手续费类型(畅游通) ", example = "REFUND")
    private String refundChargeType;

    /** 退款规则(畅游通) */
    @JsonProperty("refund_info")
    @JSONField(name = "refund_info")
    @ApiModelProperty(name = "refund_info", notes = "退款规则(畅游通) ", example = "退款规则")
    private String refundInfo;

    /** 短信模板(畅游通) */
    @JsonProperty("sms_templet")
    @JSONField(name = "sms_templet")
    @ApiModelProperty(name = "sms_templet", notes = "短信模板(畅游通) ", example = "短信模板")
    private String smsTemplet;

    /** 电子票类型(畅游通) */
    @JsonProperty("e_ticket_type")
    @JSONField(name = "e_ticket_type")
    @ApiModelProperty(name = "e_ticket_type", notes = "电子票类型(畅游通) ", example = "C-CODE")
    private String eTicketType;

    /** 关联公共产品id */
    @JsonProperty("common_product_id")
    @JSONField(name = "common_product_id")
    @ApiModelProperty(name = "common_product_id", notes = "关联公共产品id")
    private Long commonProductId;

    /** 产品代码 */
    @JsonProperty("product_code")
    @JSONField(name = "product_code")
    @ApiModelProperty(name = "product_code", notes = "产品代码 ", example = "T3000")
    private String productCode;

    /** 验证码类型 */
    @Transient
    @JsonProperty("verification_type")
    @JSONField(name = "verification_type")
    @ApiModelProperty(name = "verification_type", notes = "验证码类型")
    private List<String> verificationType;

    /** 是否实名制 */
    @JsonProperty("is_real_name")
    @JSONField(name = "is_real_name")
    @ApiModelProperty(name = "is_real_name", notes = "是否实名制(0:是，1:不是)")
    private Integer isRealName;

    public interface SAVE{};

}