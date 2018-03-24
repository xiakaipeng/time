package com.cloud.drore.eboos.common.entity.dealer;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.entity.base.DictionaryVo;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/13 16:27 <br>
 * @Author: <a href="747639122@qq.com">冯腾</a>
 */
@Data
public class RefundOrderDicVo {

    /** 订单状态(1.待付款 2.已取消 3.已支付 4.退订失败 8.已退订 9.已消费 10.已验证 11.已过期) */
    @JsonProperty("order_status")
    @JSONField(name = "order_status")
    @ApiModelProperty(name = "order_status", notes = "订单状态(1.待付款 2.已取消 3.已支付 4.退订失败 8.已退订 9.已消费 10.已验证 11.已过期)")
    private List<DictionaryVo> orderStatus;

    /** 分销商列表 */
    @JsonProperty("distributor_list")
    @JSONField(name = "distributor_list")
    @ApiModelProperty(name = "distributor_list",notes = "分销商列表")
    private List<DistributorVo> distributorList;

    /** 付款方式 */
    /*@JsonProperty("payment_way")
    @JSONField(name = "payment_way")
    @ApiModelProperty(name = "payment_way", notes = "付款方式(询查字典):ALIPAY_PAYMENT:支付宝支付 WECHAT_PAYMENT:微信支付", example = "WECHAT_PAYMENT")
    private List<DictionaryVo> paymentWay;*/

    /** 产品类型 */
    /*@JsonProperty("product_type")
    @JSONField(name = "product_type")
    @ApiModelProperty(name = "product_type", notes = "产品类型: TICKET_PRODUCT:门票产品 COMBINATION_PRODUCT:组合产品 HOTEL_PRODUCT:酒店产品", example = "TICKET_PRODUCT")
    private List<DictionaryVo> productType;*/
}
