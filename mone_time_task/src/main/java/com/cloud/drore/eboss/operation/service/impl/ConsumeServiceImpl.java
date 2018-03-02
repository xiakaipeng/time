package com.cloud.drore.eboss.operation.service.impl;

import com.cloud.drore.eboos.common.base.BaseServiceImpl;
import com.cloud.drore.eboos.common.base.MyMapper;
import com.cloud.drore.eboos.common.base.PagePo;
import com.cloud.drore.eboos.common.base.ResultMessage;


import com.cloud.drore.eboos.common.util.Pinyin4jUtil;
import com.cloud.drore.eboss.operation.entity.ConsumeOperation;
import com.cloud.drore.eboss.operation.entity.Merchant;
import com.cloud.drore.eboss.operation.entity.POIOperation;
import com.cloud.drore.eboss.operation.mapper.ConsumeMapper;
import com.cloud.drore.eboss.operation.mapper.POIMapper;
import com.cloud.drore.eboss.operation.service.IBaseDataFeign;
import com.cloud.drore.eboss.operation.service.IConsumeService;
import com.cloud.drore.eboss.operation.supplierApiService.IConsumeSupplierApiService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/6 0006 下午 5:48 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Service
public class ConsumeServiceImpl extends BaseServiceImpl implements IConsumeService, IConsumeSupplierApiService {

    @Autowired
    IBaseDataFeign iBaseDataFeign;

    @Resource
    ConsumeMapper consumeMapper;
    @Resource
    POIMapper POIMapper;

    @Override
    public MyMapper getMapper() {
        return consumeMapper;
    }

    /**
     * @param page
     * @ClassName: MerchantServiceImpl
     * @Return:
     * @Decription:
     * @CreateDate: Created in 2018/1/6 0006 下午 1:19
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public ResultMessage findByName(PagePo page) {
        PageHelper.startPage(page);
        List list = consumeMapper.selectAll();
        PageInfo pageInfo = new PageInfo(list);

        return ResultMessage.success(pageInfo);
    }

    /**
     * @param
     * @ClassName: ConsumeServiceImpl
     * @Return: com.cloud.drore.eboos.common.base.ResultMessage
     * @Decription: 查询所有消费点信息列表，给涛哥使用
     * @CreateDate: Created in 2018/1/15 0015 下午 6:40
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public ResultMessage findTotalConsumeList() {
        List list = consumeMapper.selectAll();
        return new ResultMessage(list);
    }


    /**
     * @param id
     * @ClassName: ConsumeServiceImpl
     * @Return: com.cloud.drore.eboos.common.base.ResultMessage
     * @Decription: 根据POI的id，查询对应的消费点集合的接口
     * @CreateDate: Created in 2018/1/15 0015 下午 2:47
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public ResultMessage findConsumeListByPOI(Long id) {
        return new ResultMessage(consumeMapper.queryListByPOI(id));
    }


    /**
     * @param pagePo
     * @ClassName: ConsumeServiceImpl
     * @Return: com.cloud.drore.eboos.common.base.ResultMessage
     * @Decription: 根据POI的id，查询对应的消费点集合的接口,可以传入消费点名称进行模糊查询
     * @CreateDate: Created in 2018/1/15 0015 下午 2:47
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public ResultMessage findConsumeListByPoiId(PagePo<ConsumeOperation> pagePo) {
        ConsumeOperation consumeOperation = pagePo.getFields();
        PageHelper.startPage(pagePo);
        List<ConsumeOperation> consumeOperations = consumeMapper.queryListByPOIAndConsumeName(consumeOperation);
        long total = new PageInfo(consumeOperations).getTotal();
        List<ConsumeOperation> collect = consumeOperations.stream().map(consume ->
        {
            consume.setConsumeNum(Pinyin4jUtil.getPinyinString(consume.getConsumePoiName()) + consume.getId());
            return consume;
        }).collect(Collectors.toList());
        PageInfo pageInfo = new PageInfo(collect);
        pageInfo.setTotal(total);
        return ResultMessage.success(pageInfo);
    }


    /**
     * @param POIOperation
     * @ClassName: ConsumeServiceImpl
     * @Return: com.cloud.drore.eboos.common.base.ResultMessage
     * @Decription: 根据POI的对象，查询对应的消费点集合的接口,供应商接口使用
     * @CreateDate: Created in 2018/1/15 0015 下午 2:47
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public ResultMessage findConsumeList(POIOperation POIOperation) {
        Long poiId = POIOperation.getId();
        if (null == poiId || "".equals(poiId)) {
            return new ResultMessage(consumeMapper.selectAll());
        }
        return new ResultMessage(consumeMapper.queryListByPOI(POIOperation.getId()));
    }

    /**
     * @param
     * @ClassName: ConsumeServiceImpl
     * @Return: com.cloud.drore.eboos.common.base.ResultMessage
     * @Decription: 查询消费点的列表接口
     * @CreateDate: Created in 2018/1/19 0019 下午 6:04
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    @Override
    public ResultMessage findByName() {
        List list = consumeMapper.selectAll();
        return new ResultMessage(list);
    }


    /**
     * @param id
     * @ClassName: ConsumeServiceImpl
     * @Return: com.cloud.drore.eboss.operation.entity.POIOperation
     * @Decription: 根据消费点id查询对应景区
     * @CreateDate: Created in 2018/1/15 0015 下午 4:39
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public POIOperation getPOIById(Long id) {
        Example consumeExample = new Example(ConsumeOperation.class);
        consumeExample.createCriteria().andEqualTo("id", id);
        //得到消费点信息
        List<ConsumeOperation> consumeOperationList = consumeMapper.selectByExample(consumeExample);
        POIOperation poiOperation = null;
        if (consumeOperationList.size() > 0) {
            ConsumeOperation consumeOperation = consumeMapper.selectByExample(consumeExample).get(0);
            Example POIExample = new Example(POIOperation.class);
            POIExample.createCriteria().andEqualTo("id", consumeOperation.getConsumePoiId());
            List<POIOperation> poiOperationList = POIMapper.selectByExample(POIExample);
            if (poiOperationList.size() > 0) {
                //得到poi信息
                poiOperation = POIMapper.selectByExample(POIExample).get(0);
            }
        }
        //得到poi信息
        return poiOperation;
    }


    /**
     * @param consumeOperation
     * @ClassName: ConsumeServiceImpl
     * @Return: com.cloud.drore.eboos.common.base.ResultMessage<com.cloud.drore.eboss.operation.entity.ConsumeOperation>
     * @Decription: 消费点信息更新
     * @CreateDate: Created in 2018/1/26 0026 上午 10:25
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public int updateConsume(ConsumeOperation consumeOperation) {
        return consumeMapper.updateConsume(consumeOperation);
    }

    /**
     * @param consumeOperation
     * @ClassName: ConsumeServiceImpl
     * @Return: com.cloud.drore.eboss.operation.entity.Merchant
     * @Decription: 新增消费点的时候根据poi的id得到商户id插入到消费点数据中
     * @CreateDate: Created in 2018/2/28 0028 下午 2:46
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    @Transactional
    public ConsumeOperation insertConsume(ConsumeOperation consumeOperation) {
        //查到商户的信息
        Merchant merchant = POIMapper.queryMerchantByPoiId(consumeOperation.getConsumePoiId());
        consumeOperation.setMerchantId(merchant.getId());
        consumeOperation = (ConsumeOperation) insert(consumeOperation);
        return consumeOperation;
    }
}
