package com.cloud.drore.eboss.operation.service.impl;

import com.cloud.drore.eboos.common.base.BaseServiceImpl;
import com.cloud.drore.eboos.common.base.MyMapper;
import com.cloud.drore.eboos.common.base.PagePo;
import com.cloud.drore.eboos.common.base.ResultMessage;
import com.cloud.drore.eboss.operation.entity.DistributorProductAssociation;
import com.cloud.drore.eboss.operation.entity.po.*;
import com.cloud.drore.eboss.operation.entity.vo.CooperationManagementAddVo;
import com.cloud.drore.eboss.operation.entity.vo.CooperationProductTypeVo;
import com.cloud.drore.eboss.operation.entity.vo.DistributorInfoVo;
import com.cloud.drore.eboss.operation.entity.vo.DistributorsAllRelationVo;
import com.cloud.drore.eboss.operation.mapper.CooperationAddRelationByInsertList;
import com.cloud.drore.eboss.operation.mapper.CooperationManagementMapper;
import com.cloud.drore.eboss.operation.mapper.DistributorMapper;
import com.cloud.drore.eboss.operation.supplierApiService.IDistributorInfoApiService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 获取分销商列表使用接口实现<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/29 16:17 <br>
 * @Author: <a href="1451173193@qq.com">杨亮</a>
 */
@Service
@Transactional
public class DistributorServiceImpl extends BaseServiceImpl implements IDistributorInfoApiService {
    @Resource
    DistributorMapper distributorMapper;
    @Resource
    CooperationManagementMapper cooperationManagementMapper;
    @Resource
    CooperationAddRelationByInsertList cooperationAddRelationByInsertList;
    @Override
    public MyMapper getMapper() {
        return distributorMapper;
    }
    /**
     * @ClassName: DistributorServiceImpl
     * @param pagePo
     * @Return: com.cloud.drore.eboos.common.base.ResultMessage
     * @Decription:分销商列表
     * @CreateDate: Created in 2018/1/29 17:42
     * @Author: <a href="1451173193@qq.com">杨亮</a>
     * @Modify:
     */
    @Override
    public ResultMessage<List<DistributorInfoVo>> getDistributorList(PagePo<DistributorInfoPo> pagePo) {
        DistributorInfoPo vo= pagePo.getFields();
        PageHelper.startPage(pagePo);
        List<DistributorInfoVo> list=distributorMapper.getDistributorListByParam(vo);
        PageInfo pageInfo = new PageInfo<>(list);
        return  ResultMessage.success(pageInfo);
    }

    @Override
    public ResultMessage getDistributorsAllRelation(PagePo<DistributorsAllRelationPo> pagePo) {
        PageHelper.startPage(pagePo);
        List<DistributorsAllRelationVo> list= cooperationManagementMapper.getDistributorsAllRelation(pagePo.getFields());
        PageInfo pageInfo = new PageInfo<>(list);
        return ResultMessage.success(pageInfo);
    }
    /**
     * @ClassName: DistributorServiceImpl
     * @param po
     * @Return: com.cloud.drore.eboos.common.base.ResultMessage
     * @Decription:设置价格
     * @CreateDate: Created in 2018/2/9 10:43
     * @Author: <a href="1451173193@qq.com">杨亮</a>
     * @Modify:
     */
    @Override
    public ResultMessage setPriceForRelation(CooperationSetPriceForRelationPo po) {
        cooperationManagementMapper.setPriceForRelation(po);
        return new ResultMessage();
    }
    /**
     * @ClassName: DistributorServiceImpl
     * @param relationId
     * @Return: com.cloud.drore.eboos.common.base.ResultMessage
     * @Decription:删除协议关系
     * @CreateDate: Created in 2018/2/9 10:43
     * @Author: <a href="1451173193@qq.com">杨亮</a>
     * @Modify:
     */
    @Override
    public ResultMessage deleteRelation(Long relationId) {
        cooperationManagementMapper.deleteRelation(relationId);
        return new ResultMessage();
    }
    /**
     * @ClassName: DistributorServiceImpl
     * @param
     * @Return: com.cloud.drore.eboos.common.base.ResultMessage<java.util.List < com.cloud.drore.eboss.operation.entity.vo.CooperationProductTypeVo>>
     * @Decription:获取所有产品类型
     * @CreateDate: Created in 2018/2/9 14:14
     * @Author: <a href="1451173193@qq.com">杨亮</a>
     * @Modify:
     */
    @Override
    public ResultMessage<List<CooperationProductTypeVo>> getProductTypeList() {
        return new ResultMessage(cooperationManagementMapper.getProductTypeList());
    }
    /**
     * @ClassName: DistributorServiceImpl
     * @param po
     * @Return: com.cloud.drore.eboos.common.base.ResultMessage<java.util.List < com.cloud.drore.eboss.operation.entity.vo.CooperationManagementAddVo>>
     * @Decription:根据产品类型，poi，分销商id，查询分销商可添加产品列表
     * @CreateDate: Created in 2018/2/9 20:01
     * @Author: <a href="1451173193@qq.com">杨亮</a>
     * @Modify:
     */
    @Override
    public ResultMessage<List<CooperationManagementAddVo>> getNewRelationListByParam(CooperationManagementAddPo po) {
        List<CooperationManagementAddVo> list = cooperationManagementMapper.getNewRelationListByParam(po);
        list.stream().map(item -> {
            item.setProductConsumeName(cooperationManagementMapper.getConsumNameByMainId(item.getMainId()));//组合产品可以有多个消费点，所以要分开写
            return item;
        }).collect(Collectors.toList());
        return new ResultMessage(cooperationManagementMapper.getNewRelationListByParam(po));
    }

    @Override
    public ResultMessage addRelationByInsertList(DistributorProductAssociationListPo po) {
        Date date = new Date();
        List<DistributorProductAssociation> insertList=po.getInsertList().stream().map(item->{item.setCreatedDate(date); return item;}).collect(Collectors.toList());
        return new ResultMessage(cooperationAddRelationByInsertList.insertList(po.getInsertList()));
    }

}
