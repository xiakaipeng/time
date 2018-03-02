package com.cloud.drore.eboss.operation.mapper.provider;

import com.cloud.drore.eboos.common.util.DateToStringUtil;
import com.cloud.drore.eboss.operation.entity.po.ProductToDistributorSettingPo;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/2/7 10:01 <br>
 * @Author: <a href="1451173193@qq.com">杨亮</a>
 */
public class ProductToDistributorSettingProvider {
    public String getUpdateProductRelationSql(ProductToDistributorSettingPo po) {
      /*  String dateStart = DateToStringUtil.getStringDateTime(po.getTermOfValidityStartTime());
        String dateEnd = DateToStringUtil.getStringDateTime(po.getTermOfValidityEndTime());
        String sql = "update eboos_distributor_product_association set modified_date=now(),settlement_price=" + po.getSettlementPrice() + ",sales_price=" + po.getSalesPrice() + ",product_stock=" + po.getProductStock() + "," +
                "term_of_validity_start_time='" + dateStart + "',term_of_validity_end_time='" + dateEnd + "' where id=" + po.getRelationId();*/

        String sql = "update eboos_distributor_product_association set modified_date=now(),sales_price=" + po.getSalesPrice() + " where id=" + po.getRelationId();
        return sql;
    }
}
