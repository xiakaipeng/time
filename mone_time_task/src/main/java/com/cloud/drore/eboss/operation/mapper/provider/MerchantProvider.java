package com.cloud.drore.eboss.operation.mapper.provider;


import com.cloud.drore.eboss.operation.entity.Merchant;
import com.cloud.drore.eboss.operation.entity.po.DistributorInfoPo;
import com.cloud.drore.eboss.operation.entity.po.ProductToDistributorPo;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/6 0006 下午 1:12 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
public class MerchantProvider {

    /**
     * @ClassName: MerchantProvider
     * @param merchant
     * @Return: java.lang.String
     * @Decription: 商户状态已审核通过修改基本信息
     * @CreateDate: Created in 2018/1/10 0010 下午 12:07
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public String updateSql(Merchant merchant) {
        String sql = "update eboos_merchant set";
        int count = 0;
        if (!"".equals(merchant.getMerchantName())) {
            sql += " merchant_name='" + merchant.getMerchantName() + "'";
            count++;
        }
        if (!"".equals(merchant.getLinkMan())) {
            if (count != 0) {
                sql += ",";
            }
            sql += "link_man='" + merchant.getLinkMan() + "'";
            count++;
        }
        if (!"".equals(merchant.getMobile())) {
            if (count != 0) {
                sql += ",";
            }
            sql += "mobile='" + merchant.getMobile() + "'";
            count++;
        }
        if (!"".equals(merchant.getTelephone())) {
            if (count != 0) {
                sql += ",";
            }
            sql += "telephone='" + merchant.getTelephone() + "'";
            count++;
        }
        if (!"".equals(merchant.getEmailAddress())) {
            if (count != 0) {
                sql += ",";
            }
            sql += "email_address='" + merchant.getEmailAddress() + "'";
            count++;
        }
        if (!"".equals(merchant.getPostalAddressProvince())) {
            if (count != 0) {
                sql += ",";
            }
            sql += "postal_address_province='" + merchant.getPostalAddressProvince() + "'";
            count++;
        }
        if (!"".equals(merchant.getPostalAddressCity())) {
            if (count != 0) {
                sql += ",";
            }
            sql += "postal_address_city='" + merchant.getPostalAddressCity() + "'";
            count++;
        }
        if (!"".equals(merchant.getPostalAddressCounty())) {
            if (count != 0) {
                sql += ",";
            }
            sql += "postal_address_county='" + merchant.getPostalAddressCounty() + "'";
            count++;
        }
        if (!"".equals(merchant.getDetailAddress())) {
            if (count != 0) {
                sql += ",";
            }
            sql += "detail_address='" + merchant.getDetailAddress() + "'";
            count++;
        }

        sql += "where id='" + merchant.getId() + "'";
        return sql;
    }

    /**
     * @ClassName: MerchantProvider
     * @param po
     * @Return: java.lang.String
     * @Decription:分销商列表信息
     * @CreateDate: Created in 2018/1/29 17:23
     * @Author: <a href="1451173193@qq.com">杨亮</a>
     * @Modify:
     */
    public String getDistributorListSql(DistributorInfoPo po) {

        StringBuffer sql = new StringBuffer("");
        sql.append("select a.id,a.merchant_name distributor_name,a.merchant_num distributor_num, a.link_man,a.mobile,b.name distributor_type from eboos_merchant a inner join eboos_dictionary b" +
                " on a.merchant_industry=b.dic_code where a.merchant_type='MERCHANT_DISTRIBUTE' and a.is_deleted=0");
        if (po.getDistributorName() != null && !po.getDistributorName().equals("")) {
            sql.append(" and instr(a.merchant_name,'" + po.getDistributorName() + "')>0");
        }
        if (po.getDistributorNum() != null && !po.getDistributorNum().equals("")) {
            sql.append("  and instr(a.merchant_num,'" + po.getDistributorNum() +"')>0");

        }
        return sql.toString();
    }

    /**
     * @ClassName: MerchantProvider
     * @param mainId
     * @param type
     * @Return: java.lang.String
     * @Decription:根据产品id获取分销商关联关系列表
     * @CreateDate: Created in 2018/1/30 19:57
     * @Author: <a href="1451173193@qq.com">杨亮</a>
     * @Modify:
     */
    public String getDistributorListByTicketIdSql(Long mainId) {
       String sql="select a.main_id,a.id relation_id,b.merchant_name distributor_name,a.sales_price, a.settlement_price,a.term_of_validity_start_time,a.term_of_validity_end_time from eboos_distributor_product_association a\n" +
               "left join eboos_merchant b on a.distributor_id=b.id\n" +
               "where main_id="+mainId;
        return sql;
    }
    /**
     * @ClassName: MerchantProvider
     * @param mainId
     * @Return: java.lang.String
     * @Decription:根据组合产品id获取分销商关联关系列表
     * @CreateDate: Created in 2018/2/2 15:06
     * @Author: <a href="1451173193@qq.com">杨亮</a>
     * @Modify:
     */
    public String getDistributorListByCombinationIdSql(Long mainId){
        String sql = "select a.merchant_name distributor_name,c.product_name,a.id distributor_id,c.id main_id,\n" +
                "\tIFNULL(b.product_stock, 0) product_stock,\n" +
                "\tIFNULL(b.id ,- 1) relation_id,\n" +
                "case when b.term_of_validity_start_time is null then e.term_of_validity_start_time else b.term_of_validity_start_time end term_of_validity_start_time,\n" +
                "case when b.term_of_validity_end_time is null then e.term_of_validity_end_time else b.term_of_validity_end_time end term_of_validity_end_time,\n" +
                " CASE WHEN b.id IS NULL THEN sum(d.settlement_price) ELSE b.settlement_price END settlement_price,\n" +
                " CASE WHEN b.id IS NULL THEN 'unchecked' ELSE 'checked' END check_state\n" +
                "FROM eboos_merchant a\n" +
                "LEFT JOIN eboos_distributor_product_association b ON (\n" +
                "\ta.id = b.distributor_id AND b.main_id = 45\n" +
                ")\n" +
                "LEFT JOIN eboos_product c ON c.id = 45\n" +
                "LEFT JOIN eboos_combination_product_price d ON d.combination_product_id = c.product_id\n" +
                "left join eboos_combination_product e on (e.id=c.product_id) \n" +
                "WHERE\n" +
                "\ta.merchant_type = 'MERCHANT_DISTRIBUTE' AND a.is_deleted = 0 GROUP BY a.id";
        return sql;
    }
}
