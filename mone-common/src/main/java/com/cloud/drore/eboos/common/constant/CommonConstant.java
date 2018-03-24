package com.cloud.drore.eboos.common.constant;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 配置业务所需常量<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/3/5 9:45 <br>
 * @Author: <a href="1451173193@qq.com">杨亮</a>
 */
public class CommonConstant {
    /*数据字典模块*/
    //产品人群
    public static final String PRODUCT_CROWD = "PRODUCT_CROWD";
    //产品类型_门票
    public static final String TYPE_OF_TICKET = "TICKET_PRODUCT";
    //产品类型_组合产品
    public static final String TYPE_OF_COMBINATION = "COMBINATION_PRODUCT";
    //产品类型
    public static final String PRODUCT_TYPE = "PRODUCT_TYPE";
    //库存不限
    public static final String UNLIMITED_STOCK = "UNLIMITED_STOCK";
    //日库存
    public static final String DAILY_INVENTORY = "DAILY_INVENTORY";
    //商户已生效
    public static final String MERCHANT_AUDIT_ALREADY = "MERCHANT_AUDIT_ALREADY";
    //商户类型_分销商
    public static final String MERCHANT_DISTRIBUTE = "MERCHANT_DISTRIBUTE";
    //商户行业
    public static final String MERCHANT_INDUSTRY = "MERCHANT_INDUSTRY";
    //产品状态—已上架
    public static final String THE_SHELVES="THE_SHELVES";
    //接口method,单条数据请求
    public static final String METHOD_SINGLE="SINGLE";
    //接口method,全部数据请求
    public static final String METHOD_ALL="ALL";
    //产品验证码
    public static final String VERIFYING_CODE_TYPE="VERIFYING_CODE_TYPE";

    /*状态码*/
    public static final Integer SUCCESS_CODE = 8200;

    /*提示信息*/
    public static final String REMOTE_CALL_ERROR = "远程调用出错!";
    public static final String VALIDATE_ERROR_OF_DIS="分销商状态不合法";
}
