package com.cloud.drore.eboos.common.entity.supplier;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 门票价格实体类<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/10 10:27 <br>
 * @Author: <a href="575842778@qq.com">郑永涛</a>
 */
@Data
@Table(name = "eboos_ticket_price")
public class TicketPrice extends BaseEntity<Long> {

    /** 关联门票id */
    @JsonProperty("ticket_id")
    @JSONField(name = "ticket_id")
    @ApiModelProperty(name = "ticket_id", notes = "关联门票id", example = "80")
    private Long ticketId;

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

    /** 结束时间 */
    @JsonProperty("end_time")
    @JSONField(name = "end_time",format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "end_time", notes = "结束时间", example = "2018-1-5 14:38:04")
    private Date endTime;

    /** 开始时间 */
    @JsonProperty("start_time")
    @JSONField(name = "start_time",format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "start_time", notes = "开始时间", example = "2018-1-5 14:38:04")
    private Date startTime;

    public interface SAVE{};

}