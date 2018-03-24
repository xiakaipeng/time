package com.cloud.drore.eboss.operation.mapper;

import com.cloud.drore.eboos.common.base.MyMapper;

import com.cloud.drore.eboss.operation.entity.po.DistributorsAllRelationPo;

import com.cloud.drore.eboss.operation.entity.vo.CooperationProductTypeVo;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/2/9 9:12 <br>
 * @Author: <a href="1451173193@qq.com">杨亮</a>
 */
public interface CooperationManagementMapper extends MyMapper<DistributorsAllRelationPo> {
    @Delete("delete from eboos_distributor_product_association where id=${relationId} ")
    Integer deleteRelation(@Param("relationId") Long relationId);
    @Select("select name,dic_code from eboos_dictionary where parent_code='product_type'")
    List<CooperationProductTypeVo> getProductTypeList();

   @Select("select GROUP_CONCAT( distinct poi_name) from eboos_poi a \n" +
           "INNER JOIN eboos_product_consume_relation b on a.id=b.poi_id\n" +
           "INNER JOIN eboos_product c on c.id=b.product_id\n" +
           "where c.id=${mainId} ")
    String getConsumNameByMainId(@Param("mainId") Long mainId);
}
