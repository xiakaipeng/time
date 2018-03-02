package com.cloud.drore.eboss.operation.controller;


import com.cloud.drore.eboos.common.base.PagePo;
import com.cloud.drore.eboos.common.base.ResultMessage;

import com.cloud.drore.eboss.operation.entity.*;

import com.cloud.drore.eboss.operation.entity.po.*;

import com.cloud.drore.eboos.exception.BusinessException;


import com.cloud.drore.eboss.operation.entity.vo.FinaceSourseDataOperationAndSupplierVo;
import com.cloud.drore.eboss.operation.entity.vo.FundSettlementTotalVo;
import com.cloud.drore.eboss.operation.entity.vo.FundSettlementVo;
import com.cloud.drore.eboss.operation.service.IBaseDataFeign;
import com.cloud.drore.eboss.operation.service.impl.FinaceSettlementHistoryServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 浙江卓锐科技股份有限公司 版权所有 © Copyright 2018<br>
 *
 * @Description: finace<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/01/24 11:23 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@RestController
@RequestMapping("/finaceOperation")
@Api(value = "/运营商财务资金结算模块", description = "运营商财务管理资金结算模块-夏凯")
public class FinaceOperationFundController {
    @Autowired
    ThreadPoolTaskScheduler threadPoolTaskScheduler;
    @Resource
    FinaceSettlementHistoryServiceImpl finaceSettlementHistoryServiceImpl;

    @Autowired
    IBaseDataFeign iBaseDataFeign;


    @ApiOperation(value = "test")
    @PostMapping(value = "/test")
    public ResultMessage test(@RequestBody FinaceSettlementFlagOperation finaceSettlementFlagOperation) throws BusinessException {
        // FinaceSettlementHistoryOperation finaceSettlementHistoryOperation = test.buildStage(finaceSettlementFlagOperation.getSupplierId(), finaceSettlementFlagOperation.getAutoSettlementTime());
        finaceSettlementHistoryServiceImpl.addJob();
        return new ResultMessage("success");
    }

    @ApiOperation(value = "供应商自动结算触发事件，页面加载的时候调用改接口，返回false表示已经点击过自动结算，true表示执行自动结算成功")
    @GetMapping(value = "/supplierSettlementFlag/{id}")
    public ResultMessage supplierSettlementFlag(@PathVariable("id") Long id) {
        return ResultMessage.success(finaceSettlementHistoryServiceImpl.queryEarliestOrderFlag(id));
    }





    @ApiOperation(value = "通过供应商id和结算期查询运营商的结算记录")
    @PostMapping(value = "/queryFinaceSettlementHistoryTotalList")
    public ResultMessage<List<FinaceSettlementHistoryOperation>> queryFinaceSettlementHistoryTotalList(@RequestBody @Valid PagePo<FinaceSourseOperationTotalPo> page) {
        return finaceSettlementHistoryServiceImpl.queryFinaceSettlementHistoryTotalList(page);
    }


    @ApiOperation(value = "运营商结算记录通过供应商的id查询结算期下拉列表")
    @GetMapping(value = "/selectManage/{id}")
    public ResultMessage<List<FinaceSettlementHistoryOperation>> selectManage(@PathVariable("id") Long id) {
        return ResultMessage.success(finaceSettlementHistoryServiceImpl.queryStageOperationList(id));
    }




    @ApiOperation(value = "通过分销商id和产品编号以及供应商的id（必传）、起止时间（必传）搜索供应商账单（运营商、供应商）")
    @PostMapping(value = "/queryFinaceFormListByChoice")
    public ResultMessage<List<FinaceSourseDataOperationAndSupplierVo>> queryFinaceFormListByChoice(@RequestBody @Valid PagePo<FinaceSourseDataOperationPo> page) throws BusinessException {
        return finaceSettlementHistoryServiceImpl.queryFinaceSettlementOperationTotalList(page);
    }



    @ApiOperation(value = "资金结算，供应商id作为非毕传字段")
    @PostMapping(value = "/fundSettlement")
    public ResultMessage<List<FundSettlementVo>> fundSettlement(@RequestBody PagePo<FundSettlementPo> page) {
        return finaceSettlementHistoryServiceImpl.queryFundSettlementList(page);
    }

    @ApiOperation(value = "资金结算，三个平台收入")
    @GetMapping(value = "/queryFundSettlement")
    public ResultMessage<FundSettlementTotalVo> queryFundSettlement() {
        return ResultMessage.success(finaceSettlementHistoryServiceImpl.queryFundSettlementFundSettlementTotalVo());
    }




}