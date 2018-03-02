package com.cloud.drore.eboss.operation.mapper;


import com.cloud.drore.eboos.common.base.MyMapper;
import com.cloud.drore.eboos.common.entity.operation.POI;
import com.cloud.drore.eboss.operation.entity.Merchant;
import com.cloud.drore.eboss.operation.entity.POIOperation;
import com.cloud.drore.eboss.operation.mapper.provider.POIProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/6 0006 下午 5:52 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
public interface POIMapper extends MyMapper<POIOperation> {
    String selectPoiList = "select * from eboos_poi where poi_type = '${poiCode}' and is_deleted=0";
    String findOperationList = "select * from eboos_poi where poi_name ='${poiName}' and is_deleted=0";

    @Select(selectPoiList)
    List<POIOperation> SelectPoiList(@Param("poiCode") String poiCode);

    @Select(findOperationList)
    List<POIOperation> findOperationList(@Param("poiName") String poiName);

    //更新POI相关信息
    @UpdateProvider(type = POIProvider.class, method = "updatePOI")
    int updatePOI(POIOperation POIOperation);

    //根据商户id，对poi进行下架
    String deletePoiList="update eboos_poi set is_deleted=1 where merchant_id = ${merchantId}";
    @Update(deletePoiList)
    int deletePoiList(@Param("merchantId") Object merchantId);
    //通过商户id查询到poi的id列表
    @Select("select id from eboos_poi  where merchant_id = ${merchantId}")
    List<POI> selectPOIList(@Param("merchantId") Object merchantId);

    //根据poi的id查询poi对象中商户id的信息
    @Select("select merchant_id as id from eboos_poi where id = ${id}")
    Merchant queryMerchantByPoiId(@Param("id") Long id);
}
