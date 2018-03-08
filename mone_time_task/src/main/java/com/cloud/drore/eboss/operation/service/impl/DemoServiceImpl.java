package com.cloud.drore.eboss.operation.service.impl;

import com.cloud.drore.eboos.common.base.MyMapper;
import com.cloud.drore.eboos.common.base.PagePo;
import com.cloud.drore.eboos.common.base.ResultMessage;
import com.cloud.drore.eboos.common.base.BaseServiceImpl;
import com.cloud.drore.eboss.operation.entity.Demo;
import com.cloud.drore.eboss.operation.mapper.DemoMapper;
import com.cloud.drore.eboss.operation.service.IDemoService;
import com.cloud.drore.eboss.operation.supplierApiService.IConsumeSupplierApiService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 浙江卓锐科技股份有限公司 版权所有 © Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/4 12:45 <br>
 * @Author: <a href="836327318@qq.com">吴昌益</a>
 */
@Service
public class DemoServiceImpl extends BaseServiceImpl implements IDemoService {

    @Autowired
    DemoMapper demoMapper;
    @Autowired
    IConsumeSupplierApiService IConsumeSupplierApiService;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Override
    public MyMapper getMapper() {
        return demoMapper;
    }

    /**
     * @ClassName: DemoServiceImpl
     * @param page
     * @Return: com.cloud.drore.eboos.common.base.ResultMessage
     * @Decription: 分页查询demo
     * @CreateDate: Created in 2018/1/5 9:31
     * @Author: <a href="836327318@qq.com">吴昌益</a>
     * @Modify:
     */
    public ResultMessage findByName(PagePo page) {
        PageHelper.startPage(page);
        List list = demoMapper.selectAll();
        return	new ResultMessage(new PageInfo<>(list));
    }

    /**
     * @ClassName: DemoServiceImpl
     * @param demo
     * @param page
     * @Return: com.cloud.drore.eboos.common.base.ResultMessage
     * @Decription: SelectProvider+分页查询 demo
     * @CreateDate: Created in 2018/1/5 9:33
     * @Author: <a href="836327318@qq.com">吴昌益</a>
     * @Modify:
     */
    public ResultMessage findByParms(Demo demo, PagePo page) {
        PageHelper.startPage(page);
        redisTemplate.opsForValue().get("mykey1");
        List page1 = demoMapper.findByParms(demo);
        return	ResultMessage.success(new PageInfo<>(page1));
    }
}
