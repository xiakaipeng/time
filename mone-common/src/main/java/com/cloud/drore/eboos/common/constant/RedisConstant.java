package com.cloud.drore.eboos.common.constant;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/3/19 0019 下午 3:27 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
public class RedisConstant {

    /**
     * 旅行社的现金池，在之前拼接商户编号
     */
    public static final String TRAVEL_CASH_POOL = "_TRAVEL_CASH_POOL";

    /**
     * OTA的现金池，在之前拼接商户编号
     */
    public static final String OTA_CASH_POOL = "_OTA_CASH_POOL";

    /**
     * 当前产品给分销商的库存，在之前拼接产品编号，在之后拼接分销商编号
     */
    public static final String PRODUCT_STOCK_FOR_DEALER = "_PRODUCT_STOCK_FOR_DEALER_";

}
