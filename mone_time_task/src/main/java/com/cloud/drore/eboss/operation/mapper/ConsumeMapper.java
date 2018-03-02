package com.cloud.drore.eboss.operation.mapper;


import com.cloud.drore.eboos.common.base.MyMapper;
import com.cloud.drore.eboss.operation.entity.ConsumeOperation;
import com.cloud.drore.eboss.operation.mapper.provider.ConsumeProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 消费点的mapper<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/6 0006 下午 5:50 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
public interface ConsumeMapper extends MyMapper<ConsumeOperation> {


    @Select("select * from eboos_consume where consume_poi_id = ${id} and is_deleted=0")
    List<ConsumeOperation> queryListByPOI(@Param("id") Long id);

    //取开始三条数据
    @Select("select top 3 *  from eboos_consume where consume_poi_id = ${id} and is_deleted=0")
    List<ConsumeOperation> queryListTopThree(@Param("id") Long id);

    //修改消费点
    @UpdateProvider(type = ConsumeProvider.class, method = "updateConsume")
    int updateConsume(ConsumeOperation consumeOperation);

    //根据poi的id和消费点的名称查询消费点的列表信息，消费点列表信息可能传的是空
    @SelectProvider(type  = ConsumeProvider.class, method = "queryListByPOIAndConsumeName")
    List<ConsumeOperation> queryListByPOIAndConsumeName(ConsumeOperation consumeOperation);
    //根据poi的id修改消费点变成下架状态状态
    @Update("update eboos_consume set is_deleted=1 where merchant_id =${id}")
    int updateConsumeState(@Param("id") Object id);
}
