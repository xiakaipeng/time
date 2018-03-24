package com.cloud.drore.eboos.common.entity.dealer.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: OTA获取产品信息接口入参<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/3/8 10:34 <br>
 * @Author: <a href="1451173193@qq.com">杨亮</a>
 */
@Data
public class OTAGetProductResponse {
    /** 产品编号 */
    @JsonProperty("product_num")
    @JSONField(name = "product_num")
    @ApiModelProperty(name = "product_num", notes = "产品编号", example = "T27")
    private String productNum;
    /** 景区名称 */
    @JsonProperty("poi_name")
    @JSONField(name = "poi_name")
    @ApiModelProperty(name = "poi_name", notes = "景区名称", example = "灵隐寺")
    private String poiName;
    /** 所在城市 */
    @JsonProperty("city")
    @JSONField(name = "city")
    @ApiModelProperty(name = "city", notes = "产品编号", example = "杭州")
    private String city;
    /** 产品名称 */
    @JsonProperty("product_name")
    @JSONField(name = "product_name")
    @ApiModelProperty(name = "product_name", notes = "产品名称", example = "灵隐寺半日游")
    private String productName;
    /** 支付方式*/
    @JsonProperty("payment_type")
    @JSONField(name = "payment_type")
    @ApiModelProperty(name = "payment_type", notes = "支付方式", example = "SCENIC_PAYMENT")
    private String paymentType;

    /** 提前预定天数（例如 0，即当天）*/
    @JsonProperty("payment_type")
    @JSONField(name = "payment_type")
    @ApiModelProperty(name = "payment_type", notes = "提前预定天数（例如 0，即当天）", example = "1")
    private Integer bookAdvanceDay;

    /** 提前预定时间（hh:mm 例如23:59，今日的23:59分之前可以预订，同bookadvanceDay共同生效*/
    @JsonProperty("book_advance_time")
    @JSONField(name = "book_advance_time")
    @ApiModelProperty(name = "book_advance_time", notes = "提前预定时间", example = "23:59")
    private String bookAdvanceTime;

    /** 预定后几小时才能入园*/
    @JsonProperty("use_advance_hour")
    @JSONField(name = "use_advance_hour")
    @ApiModelProperty(name = "use_advance_hour", notes = "预定后几小时才能入园", example = "1")
    private Integer useAdvanceHour;

    /** 未支付订单保存时间，单位：分钟*/
    @JsonProperty("auto_cancel_time")
    @JSONField(name = "auto_cancel_time")
    @ApiModelProperty(name = "auto_cancel_time", notes = "未支付订单保存时间，单位：分钟", example = "120")
    private Integer autoCancelTime;

    /** 所需预定人信息类型 */
    @JsonProperty("book_person_type")
    @JSONField(name = "book_person_type")
    @ApiModelProperty(name = "book_person_type", notes = "所需预定人信息类型", example = "CONTACT_PERSON_AND_VISIT_PERSON")
    private String bookPersonType;


    /** 每几个游客共享一个游客信息*/
    @JsonProperty("visit_person_required_for_quantity")
    @JSONField(name = "visit_person_required_for_quantity")
    @ApiModelProperty(name = "visit_person_required_for_quantity", notes = "每几个游客共享一个游客信息", example = "2")
    private Integer visitPersonRequiredForQuantity;

    /** 有效期限制 */
    @JsonProperty("valid_type")
    @JSONField(name = "valid_type")
    @ApiModelProperty(name = "valid_type", notes = "有效期限制", example = "BETWEEN_USE_DATE_AND_N_DAYSAFTER")
    private String validType;

    /** 游客选定的游玩日期起__天有效 */
    @JsonProperty("days_after_use_date_valid")
    @JSONField(name = "days_after_use_date_valid")
    @ApiModelProperty(name = "days_after_use_date_valid", notes = "游客选定的游玩日期起__天有效", example = "2")
    private Integer daysAfterUseDateValid;

    /** 日期：yyyy-MM-dd */
    @JsonProperty("days_after_use_date_valid")
    @JSONField(name = "days_after_use_date_valid")
    @ApiModelProperty(name = "days_after_use_date_valid", notes = "日期：yyyy-MM-dd ", example = "2018-03-08")
    private Date useDate;

    /** 票面价格 */
    @JsonProperty("market_price")
    @JSONField(name = "market_price")
    @ApiModelProperty(name = "market_price", notes = "票面价格 ", example = "68.88")
    private BigDecimal marketPrice;

    /** 销售产品单价(结算价) */
    @JsonProperty("sell_price")
    @JSONField(name = "sell_price")
    @ApiModelProperty(name = "sell_price", notes = "销售产品单价(结算价)", example = "58.88")
    private BigDecimal sellPrice;

    /** 单日库存 */
    @JsonProperty("sell_stock")
    @JSONField(name = "sell_stock")
    @ApiModelProperty(name = "sell_stock", notes = "单日库存", example = "30")
    private Integer sellStock;

    /** 使用说明 */
    @JsonProperty("instruction")
    @JSONField(name = "instruction")
    @ApiModelProperty(name = "instruction", notes = "使用说明", example = "first....second....")
    private String instruction;

    /** 是否支持退款 */
    @JsonProperty("can_refund")
    @JSONField(name = "can_refund")
    @ApiModelProperty(name = "can_refund", notes = "使用说明", example = "true")
    private String canRefund;

    /** 是否支持过期退款 */
    @JsonProperty("can_overdue_refund")
    @JSONField(name = "can_overdue_refund")
    @ApiModelProperty(name = "can_overdue_refund", notes = "是否支持过期退款", example = "true")
    private String canOverdueRefund;

    /** 最晚有效期前几天几点可退款。 */
    @JsonProperty("refund_apply_time_before_valid_end_day")
    @JSONField(name = "refund_apply_time_before_valid_end_day")
    @ApiModelProperty(name = "refund_apply_time_before_valid_end_day", notes = "最晚有效期前几天几点可退款", example = "2_22:00")
    private String refundApplyTimeBeforeValidEndDay;

    /** 退款手续费 */
    @JsonProperty("refund_charge")
    @JSONField(name = "refund_charge")
    @ApiModelProperty(name = "refund_charge", notes = "退款手续费", example = "8.88")
    private BigDecimal refundCharge;

    /** 退款手续费类型 */
    @JsonProperty("refund_charge_type")
    @JSONField(name = "refund_charge_type")
    @ApiModelProperty(name = "refund_charge_type", notes = "退款手续费类型", example = "REFUND")
    private String refundChargeType;

    /** 退款规则 */
    @JsonProperty("refund_info")
    @JSONField(name = "refund_info")
    @ApiModelProperty(name = "refund_info", notes = "退款规则", example = "退款规则")
    private String refundInfo;

    /** 退款规则 */
    @JsonProperty("sms_templet")
    @JSONField(name = "sms_templet")
    @ApiModelProperty(name = "sms_templet", notes = "退款规则", example = "您将会在3-5分钟内收到电子票，在景区售票处取票入园")
    private String smsTemplet;

    /** 电子票类型 */
    @JsonProperty("e_ticket_type")
    @JSONField(name = "e_ticket_type")
    @ApiModelProperty(name = "e_ticket_type", notes = "电子票类型", example = "NO_CODE")
    private String eTicketType;
}
