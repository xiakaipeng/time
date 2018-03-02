package com.cloud.drore.eboss.operation.service.impl;

import com.cloud.drore.eboos.common.base.BaseServiceImpl;
import com.cloud.drore.eboos.common.base.MyMapper;
import com.cloud.drore.eboss.operation.entity.MerchantMulti;
import com.cloud.drore.eboss.operation.mapper.MerchantMultiMapper;
import com.cloud.drore.eboss.operation.service.IBaseDataFeign;
import com.cloud.drore.eboss.operation.service.IMerchantMultiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/6 0006 下午 1:08 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Service
public class MerchantMultiServiceImpl extends BaseServiceImpl implements IMerchantMultiService {
    @Autowired
    MerchantMultiMapper merchantMultiMapper;
    @Autowired
    IBaseDataFeign iBaseDataFeign;

    @Override
    public MyMapper getMapper() {
        return merchantMultiMapper;
    }

    /**
     * @param id
     * @ClassName: MerchantMultiServiceImpl
     * @Return: java.lang.String
     * @Decription: 根据商户id找到对应的多选信息
     * @CreateDate: Created in 2018/1/12 0012 上午 10:10
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public List findMerchantMulti(Long id) {
        Example example = new Example(MerchantMulti.class);
        example.createCriteria().andEqualTo("merchantId", id);

        List merchantMultiList = merchantMultiMapper.selectByExample(example);
        List merchantMultiListHavedRemoved = new ArrayList();

        //遍历将多选的数据信息送到前端
        for (int i = 0; i < merchantMultiList.size(); i++) {
            MerchantMulti merchantMulti = (MerchantMulti) merchantMultiList.get(i);
            // 状态是1的时候返回到前段code
            if ("1".equals(merchantMulti.getState())) {
                merchantMultiListHavedRemoved.add(merchantMulti.getDicCode());
            }
        }
        return merchantMultiListHavedRemoved;
    }
}
