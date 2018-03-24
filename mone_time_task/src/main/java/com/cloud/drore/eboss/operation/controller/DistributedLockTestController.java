package com.cloud.drore.eboss.operation.controller;

import com.cloud.drore.eboos.common.base.ResultMessage;
import com.cloud.drore.eboss.operation.service.impl.DistributedLockServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 分布式锁测试接口<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/6 0006 下午 5:45 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@RestController
@RequestMapping("/lock")
@Api(value = "/分布式锁接口", description = "分布式锁测试接口-夏凯")
public class DistributedLockTestController {
    @Resource
    DistributedLockServiceImpl distributedLockServiceImpl;
    @ApiOperation(value = "分布式锁测试接口）")
    @PostMapping(value = "/test")
    public ResultMessage test() {
        return distributedLockServiceImpl.testDistributedLock();
    }
}
