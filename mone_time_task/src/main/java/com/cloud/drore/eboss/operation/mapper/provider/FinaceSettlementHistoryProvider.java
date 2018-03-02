package com.cloud.drore.eboss.operation.mapper.provider;


import com.cloud.drore.eboos.common.base.PagePo;
import com.cloud.drore.eboos.common.entity.dealer.FinaceSourseDataDealerPo;
import com.cloud.drore.eboos.common.util.DateToStringUtil;
import com.cloud.drore.eboos.common.util.LocalDateAndDateTransformUtil;
import com.cloud.drore.eboss.operation.entity.po.FinaceSettlementHistoryPo;
import com.cloud.drore.eboss.operation.entity.po.FinaceSourseDataOperationPo;
import com.cloud.drore.eboss.operation.entity.po.FundSettlementPo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/25 0025 上午 11:34 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
public class FinaceSettlementHistoryProvider {
    public FinaceSettlementHistoryProvider() {
    }

    public String queryFinaceSettlementHistoryList(FinaceSettlementHistoryPo finaceSettlementHistoryPo) {
        if ((null == finaceSettlementHistoryPo.getRechargeBeginTime()) && (null == finaceSettlementHistoryPo.getRechargeEndTime())
                || (("".equals(finaceSettlementHistoryPo.getRechargeBeginTime()) && "".equals(finaceSettlementHistoryPo.getRechargeEndTime())))
                ) {
            return "select * from eboss_finace_settlement_history";
        }

        String sql = "select * from eboss_finace_settlement_history where";
        int count = 0;
        if (!("".equals(finaceSettlementHistoryPo.getRechargeEndTime()) || null == finaceSettlementHistoryPo.getRechargeEndTime())) {
            if (count != 0) {
                sql += ",";
            }
            DateTimeFormatter sdfSqlHH = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            //充值开始时间
            LocalDateTime rechargeEndTime = LocalDateAndDateTransformUtil.dateToLocalDateTime(finaceSettlementHistoryPo.getRechargeEndTime());

            sql += " settlement_end_time<='" + sdfSqlHH.format(rechargeEndTime.plusDays(1)) + "'";
            count++;
        }
        if (!("".equals(finaceSettlementHistoryPo.getRechargeBeginTime()) || null == finaceSettlementHistoryPo.getRechargeBeginTime())) {
            if (count != 0) {
                sql += "and";
            }
            //充值开始时间
            String rechargeBeginTime = DateToStringUtil.getStringDateTime(finaceSettlementHistoryPo.getRechargeBeginTime());

            sql += " settlement_end_time>='" + rechargeBeginTime + "'";
            count++;
        }
        return sql;
    }


    public static String queryFundSettlementListSql = "select b.merchant_name,a.merchant_id,sum(a.total_amount_income) as total_amount_income,\n" +
            "sum(a.total_amount_should) as  total_amount_should,\n" +
            "sum(a.total_amount_aleady) as  total_amount_aleady,\n" +
            "(total_amount_income-total_amount_should) as net_profit\n" +
            "from eboss_finace_settlement_history a left join eboos_merchant b on a.merchant_id=b.id ";

    /**
     * @param fundSettlementPo
     * @ClassName: FinaceSettlementHistoryProvider
     * @Author: mone xia
     * @Return: java.lang.String
     * @Decription: 根据供应商id查询资金结算的数据
     * @CreateDate: Created in 2018/2/15 18:14
     * @Author: <a href="410508961@qq.com">夏凯</a>
     */
    public String queryFundSettlementList(FundSettlementPo fundSettlementPo) {
        String sql = queryFundSettlementListSql;
        if (!("".equals(fundSettlementPo.getSupplierId()) || null == fundSettlementPo.getSupplierId())) {
            sql += " where a.merchant_id=" + fundSettlementPo.getSupplierId();
        }
        sql += " group by merchant_id";
        return sql;
    }

    public static String queryFundSettlementDealerFormListSql = "select c.distributor_id,c.operation_settlement_price,c.product_num,c.sales_price,c.product_name,c.crowd,c.distributor_name,c.purchase_count,\n" +
            "b.merchant_name as supplier_name,a.merchant_id as supplier_id,\n" +
            "sum(total_amount_sales_price) as total_amount_sales_price ,sum(total_amount_settlement_ota) as total_amount_settlement_ota\n" +
            " from eboss_finace_form c left join eboos_product a on c.product_num=a.product_num left join eboos_merchant b on a.merchant_id=b.id";

    /**
     * @param page
     * @ClassName: FinaceSettlementHistoryProvider
     * @Return: java.lang.String
     * @Decription: 分销商查询收入报表
     * @CreateDate: Created in 2018/2/24 0024 下午 5:33
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public String queryFundSettlementFormDealer(PagePo<FinaceSourseDataDealerPo> page) {
        String sql = queryFundSettlementDealerFormListSql;
        String productNum = page.getFields().getProductNum();
        sql += " where c.distributor_id=" + page.getFields().getDistributorId();
        if (!("".equals(productNum) || null == productNum)) {
            sql += " and c.product_num='" + productNum+"'";
        }
        sql += " group by c.operation_settlement_price,c.supplier_settlement_price";
        return sql;
    }


    public static String queryFundSettlementOperationAndSupplierFormListSql = "select distributor_id,supplier_settlement_price,product_num," +
            "product_name,crowd,distributor_name,purchase_count,\n" +
            "sum(total_amount_settlement_supplier) as total_amount_settlement_supplier" +
            " from eboss_finace_form ";

    /**
     * @param page
     * @ClassName: FinaceSettlementHistoryProvider
     * @Return: java.lang.String
     * @Decription: 运营商、供应商查询收入报表(供应商id、上次结算时间、本次结算时间字段必须传)
     * @CreateDate: Created in 2018/2/24 0024 下午 5:33
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public String queryFundSettlementFormOperation(PagePo<FinaceSourseDataOperationPo> page) {
        String sql = queryFundSettlementOperationAndSupplierFormListSql;
        sql += " where supplier_id=" + page.getFields().getSupplierId()+" and settlement_end_time<='"
                + DateToStringUtil.getStringDateTime(page.getFields().getSettlementEndTime())+
                "' and settlement_end_time>='"+ DateToStringUtil.getStringDateTime(page.getFields().getSettlementStartTime())+"'";
        if (!("".equals(page.getFields().getProductNum()) || null == page.getFields().getProductNum())) {
            sql += " and product_num='" + page.getFields().getProductNum()+"'";
        }
        if (!("".equals(page.getFields().getDistributorId()) || null == page.getFields().getDistributorId())) {
            sql += " and distributor_id=" + page.getFields().getDistributorId();
        }
        sql += " group by operation_settlement_price,sales_price";
        System.out.println(sql);
        return sql;
    }
}
