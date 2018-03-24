package com.cloud.drore.eboos.common.entity.supplier;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.base.BaseEntity;
import com.cloud.drore.eboos.jackson.JacksonDateDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Table;
import java.util.Date;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 门票库存实体类<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/8 10:36 <br>
 * @Author: <a href="575842778@qq.com">郑永涛</a>
 */
@Data
@Table(name = "eboos_ticket_stock")
public class TicketStock extends BaseEntity<Long> {

    /** 库存 */
    @JsonProperty("inventory")
    @JSONField(name = "inventory")
    @ApiModelProperty(name = "inventory", notes = "库存", example = "80")
    private Integer inventory;

    /** 关联门票id */
    @JsonProperty("ticket_id")
    @JSONField(name = "ticket_id")
    @ApiModelProperty(name = "ticket_id", notes = "关联门票id", example = "80")
    private Long ticketId;

    /** 开始时间 */
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("start_time")
    @JSONField(name = "start_time",format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "start_time", notes = "开始时间", example = "2018-01-05 00:00:00")
    private Date startTime;

    /** 结束时间 */
    @JsonDeserialize(using = JacksonDateDeserializer.class)
    @JsonProperty("end_time")
    @JSONField(name = "end_time",format = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "end_time", notes = "结束时间", example = "2018-01-05 00:00:00")
    private Date endTime;

    /** 库存类型 */
    @JsonProperty("inventory_type")
    @JSONField(name = "inventory_type")
    @ApiModelProperty(name = "inventory_type", notes = "库存类型", example = "TOTAL_STOCK")
    private String inventoryType;

    public interface SAVE{};

}