package com.cloud.drore.eboss.operation.mapper.provider;

import com.cloud.drore.eboos.exception.BusinessException;
import com.cloud.drore.eboss.operation.entity.po.CooperationManagementAddPo;
import com.cloud.drore.eboss.operation.entity.po.CooperationSetPriceForRelationPo;
import com.cloud.drore.eboss.operation.entity.po.DistributorsAllRelationPo;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 合作管理关联关系列表 <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/2/9 10:35 <br>
 * @Author: <a href="1451173193@qq.com">杨亮</a>
 */
public class CooperationManagementProvider {
    private static String TYPE_OF_TICKET = "TICKET_PRODUCT";
    private static String TYPE_OF_COMBINATION = "COMBINATION_PRODUCT";


    public String getSetPriceForRelationSql(CooperationSetPriceForRelationPo po) {
        String sql = "update eboos_distributor_product_association set modified_date=now(),sales_price=" + po.getSalesPrice() + " where id=" + po.getRelationId();
        return sql;
    }

    public String getDistributorsAllRelationSql(DistributorsAllRelationPo po) {
        String sql = "select b.product_num,b.product_name,c.poi_name,d.name,a.sales_price,a.id relation_id  from eboos_distributor_product_association a \n" +
                "left join eboos_product b on a.main_id=b.id \n" +
                "left join eboos_product_consume_relation e on e.product_id=b.id\n" +
                "left join eboos_poi c on e.poi_id=c.id\n" +
                "left join eboos_dictionary d on d.dic_code=b.product_type\n" +
                "where a.distributor_id=" + po.getDistributorId() + "" +
                " and d.parent_code='PRODUCT_TYPE'";
        if (po.getProductName() != null && !po.getProductName().equals("")) {
            sql = sql + " and instr(b.product_name,'" + po.getProductName() + "')>0";
        }
        return sql;
    }

    public String getNewRelationListByParamSql(CooperationManagementAddPo po) {
        //各表字段有异无法统一sql
        StringBuffer sql = new StringBuffer("");
        //门票表
        String poiSql="";
        if(po.getPoiId()==null||po.getPoiId().equals("")){//选择景点为空时
            poiSql="1=1";
        }else{
            poiSql="c.poi_id="+po.getPoiId();
        }
        if (TYPE_OF_TICKET.equals(po.getProductType())){
            sql.append("select a.id main_id,"+po.getDistributorId()+" distributor_id,a.product_name,b.name product_crowd,e.term_of_validity_start_time,e.term_of_validity_end_time, f.settlement_price from eboos_product a\n" +
                    "left join eboos_dictionary b on a.crowd=b.dic_code\n" +
                    "left join eboos_ticket e on a.product_id=e.id\n" +
                    "left join eboos_ticket_price f on f.ticket_id=e.id\n" +
                    "where "+poiSql+" and a.product_type='"+TYPE_OF_TICKET+"' and \n" +
                    "a.id not in (select main_id from eboos_distributor_product_association where distributor_id="+po.getDistributorId()+")");
        }else if(TYPE_OF_COMBINATION.equals(po.getProductType())){
            sql.append("select a.id main_id,"+po.getDistributorId()+" distributor_id,a.product_name,b.name product_crowd,e.term_of_validity_start_time,e.term_of_validity_end_time, f.settlement_price from eboos_product a\n" +
                    "left join eboos_dictionary b on a.crowd=b.dic_code\n" +
                    "left join eboos_combination_product e on a.product_id=e.id\n" +
                    "left join eboos_combination_product_price f on f.combination_product_id=e.id\n" +
                    "where  a.product_type='"+TYPE_OF_COMBINATION+"' and "+poiSql+" and\n" +
                    "a.id not in (select main_id from eboos_distributor_product_association where distributor_id="+po.getDistributorId()+")");
        }else{
           // throw new BusinessException(BUSINESS_CODE,NOT_SUPPORT_TYPE_ERROR);
        }


        return sql.toString();
    }
}
