package com.cloud.drore.eboos.common.entity.dealer.propertyenum;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 订单状态枚举类<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/2/5 15:00 <br>
 * @Author: <a href="747639122@qq.com">冯腾</a>
 */
public enum OrderEnum {

    ORDER_INIT("初始订单"),
    ORDER_BOOK_FAILED("预订失败"),
    ORDER_CANCEL("订单已取消"),
    ORDER_NOT_PAYED("预订成功，待支付"),
    ORDER_PRINTING("已付款，出票中"),
    ORDER_PRINT_FAILED("出票失败"),
    ORDER_PRINT_SUCCESS("出票成功"),
    ORDER_REFUND_FAILED("退订失败"),
    ORDER_REFUND_REVIEWING("退款待审核"),
    ORDER_REFUNDED("已退订"),
    ORDER_CONSUMED("已消费"),
    ORDER_VALIDATED("已验证"),
    ORDER_EXPIRED("已过期");

    private String name;

    OrderEnum(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return name;
    }
}
