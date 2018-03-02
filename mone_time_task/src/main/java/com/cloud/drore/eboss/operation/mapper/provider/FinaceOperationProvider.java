package com.cloud.drore.eboss.operation.mapper.provider;


/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/25 0025 上午 11:34 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
public class FinaceOperationProvider {
    public FinaceOperationProvider() {
    }

    //给订单产品进行分组得到产品编号、  分销商id、产品数量、应付总额
    private static String selectFinaceDataSQL = "select product_num,distributor_id,count(product_num) as purchase_count," +
            "(sum(if(order_status>8,settlement_price*purchase_count,0))+" +
            "sum(if(order_status=8,settlement_price*refund_fee*purchase_count,0))) as total_amount_should" +
            " from eboos_order_product ";

    private static String queryFinaceDataVoListSql = "select product_name,crowd,supplier_id,supplier_name," +
            "product_type,sales_price,settlement_price from  eboos_order_product";

    public String queryFinace(String startTime, String endTime, Long supplierId) {

        String queryFinaceSql = selectFinaceDataSQL
                + "where supplier_id = " + supplierId + " and created_date < '" + endTime
                + "' and created_date>= '" + startTime +
                "' GROUP BY product_num,distributor_id";
        //对订单产品表格进行分组得到财务报表需要的信息
        return queryFinaceSql;
    }

    //查询订单产品基本信息
    public String queryFinaceDataVoList(String productNum) {
        String sql = queryFinaceDataVoListSql + " where product_num = '" + productNum+"'";
        System.out.println(sql);
        return sql;
    }

}
