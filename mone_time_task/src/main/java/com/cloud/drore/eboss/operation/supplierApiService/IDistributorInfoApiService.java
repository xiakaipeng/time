package com.cloud.drore.eboss.operation.supplierApiService;

import com.cloud.drore.eboos.common.base.BaseService;
import com.cloud.drore.eboos.common.base.PagePo;
import com.cloud.drore.eboos.common.base.ResultMessage;
import com.cloud.drore.eboss.operation.entity.po.*;
import com.cloud.drore.eboss.operation.entity.vo.CooperationManagementAddVo;
import com.cloud.drore.eboss.operation.entity.vo.CooperationProductTypeVo;

import java.util.List;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 获取分销商列表使用接口<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/29 16:09 <br>
 * @Author: <a href="1451173193@qq.com">杨亮</a>
 */
public interface IDistributorInfoApiService extends BaseService {
    // 根据查询条件获取分销商列表信息
    public ResultMessage getDistributorList(PagePo<DistributorInfoPo> pagePo);
    //根据条件获取分销商的关系列表
    ResultMessage getDistributorsAllRelation(PagePo<DistributorsAllRelationPo> pagePo);
    //设置价格
    ResultMessage setPriceForRelation(CooperationSetPriceForRelationPo po);
    //删除协议关联
     ResultMessage deleteRelation(Long relationId);
    //获取所有产品类型
    ResultMessage<List<CooperationProductTypeVo>> getProductTypeList();
    //根据产品类型，poi，分销商id，查询分销商可添加产品列表
    ResultMessage<List<CooperationManagementAddVo>> getNewRelationListByParam(CooperationManagementAddPo po);
    //批量添加协议
    ResultMessage addRelationByInsertList(DistributorProductAssociationListPo po);
}
