package com.cloud.drore.eboss.operation.service.impl;

import com.cloud.drore.eboos.common.base.BaseServiceImpl;
import com.cloud.drore.eboos.common.base.MyMapper;
import com.cloud.drore.eboos.common.base.ResultMessage;
import com.cloud.drore.eboos.common.util.RedisKeysClockUtil;
import com.cloud.drore.eboss.operation.mapper.DemoMapper;
import com.cloud.drore.eboss.operation.supplierApiService.IConsumeSupplierApiService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 浙江卓锐科技股份有限公司 版权所有 © Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/4 12:45 <br>
 * @Author: <a href="836327318@qq.com">夏凯</a>
 */
@Service
public class DistributedLockServiceImpl extends BaseServiceImpl {

    @Autowired
    DemoMapper demoMapper;
    @Autowired
    IConsumeSupplierApiService IConsumeSupplierApiService;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    RedisKeysClockUtil redisKeysClockUtil;

    @Override
    public MyMapper getMapper() {
        return demoMapper;
    }

    public ResultMessage testDistributedLock() {
        //需要上锁的key
        String key = "helloworld!";
        //操作的参数，我这里是金额
        BigDecimal bigDecimal = new BigDecimal("888");
        //开始调用加锁的方法
        redisKeysClockUtil.cashPoolChange(key, bigDecimal, false);
        return ResultMessage.success("success");
    }
}
