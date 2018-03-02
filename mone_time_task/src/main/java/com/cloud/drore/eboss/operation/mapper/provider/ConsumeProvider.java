package com.cloud.drore.eboss.operation.mapper.provider;


import com.cloud.drore.eboss.operation.entity.ConsumeOperation;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/6 0006 下午 5:56 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
public class ConsumeProvider {

    public String updateConsume(ConsumeOperation consumeOperation) {
        String sql = "update eboos_consume set";
        if (!("".equals(consumeOperation.getLinkMan()) || null == consumeOperation.getLinkMan())) {
            sql += " link_man='" + consumeOperation.getLinkMan() + "',";
        }
        if (!("".equals(consumeOperation.getLinkTel()) || null == consumeOperation.getLinkTel())) {
            sql += " link_tel='" + consumeOperation.getLinkTel() + "',";
        }
        if (!"".equals(consumeOperation.getDescription())) {
            sql += " description='" + consumeOperation.getDescription() + "'";
        }
        sql += "where id=" + consumeOperation.getId();
        return sql;
    }


    /**
     * @param consumeOperation
     * @ClassName: ConsumeProvider
     * @Return: java.lang.String
     * @Decription: 根据poi的id和消费点的名称查询消费点的列表信息，消费点列表信息可能传的是空
     * @CreateDate: Created in 2018/2/10 0010 下午 2:42
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public String queryListByPOIAndConsumeName(ConsumeOperation consumeOperation) {
        String sql = "select * from eboos_consume where consume_poi_id = "+consumeOperation.getConsumePoiId();
        if (!(null == consumeOperation.getConsumeName() || "".equals(consumeOperation.getConsumeName()))) {
            sql += " and consume_name like '%" + consumeOperation.getConsumeName() + "%'";
        }
        sql +=" and is_deleted=0";
        return sql;
    }


}
