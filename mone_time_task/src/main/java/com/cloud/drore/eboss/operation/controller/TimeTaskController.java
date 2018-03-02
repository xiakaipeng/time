package com.cloud.drore.eboss.operation.controller;



import com.cloud.drore.eboos.common.base.ResultMessage;



import com.cloud.drore.eboss.operation.entity.po.*;


import com.cloud.drore.eboss.operation.service.IBaseDataFeign;
import com.cloud.drore.eboss.operation.service.impl.FinaceSettlementHistoryServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;


/**
 * 浙江卓锐科技股份有限公司 版权所有 © Copyright 2018<br>
 *
 * @Description: finace<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/01/24 11:23 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@RestController
@RequestMapping("/timeTask")
@Api(value = "/定时任务", description = "定时任务-夏凯")
public class TimeTaskController {

    @Resource
    FinaceSettlementHistoryServiceImpl finaceSettlementHistoryServiceImpl;

    @Autowired
    IBaseDataFeign iBaseDataFeign;


    @ApiOperation(value = "设定定时任务为（*/5 * * * * *）")
    @PostMapping(value = "/sinpleSetUp")
    public ResultMessage sinpleSetUp(@RequestBody @Valid SinpleSetUpTimeTaskCronPo sinpleSetUpTimeTaskPo) {
        ResultMessage resultMessage = new ResultMessage();
        try {
            finaceSettlementHistoryServiceImpl.addJob(sinpleSetUpTimeTaskPo.getSinpleTimeTaskCycle());
        } catch (Exception e) {
            resultMessage.setIsSuccess(false);
            e.printStackTrace();
            return resultMessage;
        }
        resultMessage.setIsSuccess(true);
        return resultMessage;
    }

    @ApiOperation(value = "设定定时任务为")
    @PostMapping(value = "/timeTaskNoneCron")
    public ResultMessage timeTaskNoneCron(@RequestBody @Valid SinpleSetUpTimeTaskTimerPo sinpleSetUpTimeTaskPo) {
        ResultMessage resultMessage = new ResultMessage();
        try {
            finaceSettlementHistoryServiceImpl.addTimeTaskNoneCron(sinpleSetUpTimeTaskPo.getSinpleTimeTaskCycle());
        } catch (Exception e) {
            resultMessage.setIsSuccess(false);
            e.printStackTrace();
            return resultMessage;
        }
        resultMessage.setIsSuccess(true);
        return resultMessage;
    }


}