package com.cloud.drore.eboos.common.entity.supplier.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.entity.supplier.TicketPrice;
import com.cloud.drore.eboos.common.entity.supplier.TicketStock;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/11 16:14 <br>
 * @Author: <a href="575842778@qq.com">郑永涛</a>
 */
@Data
public class TicketVo {

    @JsonProperty("ticket")
    @JSONField(name = "ticket")
    @ApiModelProperty(name = "ticket", notes = "门票基本信息", example = "")
    private TicketAllVo ticket;

    @JsonProperty("ticket_stocks")
    @JSONField(name = "ticket_stocks")
    @ApiModelProperty(name = "ticket_stocks", notes = "门票库存", example = "")
    private List<TicketStock> ticketStocks;

    @JsonProperty("ticket_price")
    @JSONField(name = "ticket_price")
    @ApiModelProperty(name = "ticket_price", notes = "门票价格", example = "")
    private TicketPrice ticketPrice;

}