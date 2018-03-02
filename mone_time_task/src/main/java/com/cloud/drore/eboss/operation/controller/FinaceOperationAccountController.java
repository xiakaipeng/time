package com.cloud.drore.eboss.operation.controller;


import com.cloud.drore.eboos.common.base.PagePo;
import com.cloud.drore.eboos.common.base.ResultMessage;
import com.cloud.drore.eboos.common.util.Pinyin4jUtil;
import com.cloud.drore.eboos.exception.BusinessException;
import com.cloud.drore.eboss.operation.entity.DistributorAccount;
import com.cloud.drore.eboss.operation.entity.DistributorRecharge;
import com.cloud.drore.eboss.operation.entity.po.DistributorRechargePo;
import com.cloud.drore.eboss.operation.entity.vo.DistributorAccountVo;
import com.cloud.drore.eboss.operation.service.impl.DistributorAccountServiceImpl;
import com.cloud.drore.eboss.operation.service.impl.DistributorRechargeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 浙江卓锐科技股份有限公司 版权所有 © Copyright 2018<br>
 *
 * @Description: 财务模块分销商充值接口<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2017/12/29 11:23 <br>
 * @Author: <a href="836327318@qq.com">夏凯</a>
 */
@RestController
@RequestMapping("/distributorAccount")
@Api(value = "/运营商财务模块账户信息模块", description = "运营商财务模块账户信息模块-夏凯")
public class FinaceOperationAccountController {

    @Resource
    DistributorAccountServiceImpl distributorAccountServiceImpl;
    @Resource
    DistributorRechargeServiceImpl distributorRechargeServiceImpl;


    @ApiOperation(value = "新增充值记录")
    @PostMapping(value = "/saveDistributorRechargeHistory")
    public ResultMessage saveDistributorRecharge(@RequestBody @Valid DistributorRecharge distributorRecharge) throws BusinessException {

        //新增充值记录
        distributorRechargeServiceImpl.addDistributorAccountAmount(distributorRecharge);
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setId(distributorRecharge.getId() + "");
        return resultMessage;
    }

    @ApiOperation(value = "根据时间开始和结束时间，查询充值记录列表(分销商id一定要传)")
    @PostMapping(value = "/selectRechargeListByTime")
    public ResultMessage<List<DistributorRecharge>> selectRechargeListByTime(@RequestBody @Valid PagePo<DistributorRechargePo> distributorRechargePo) throws BusinessException {
        if(null==distributorRechargePo.getFields().getDistributorId()||"".equals(distributorRechargePo.getFields().getDistributorId())){
            throw new BusinessException("分销商id不能为空！");
        }
        ResultMessage<List<DistributorRecharge>> listResultMessage = distributorRechargeServiceImpl.selectDistributorRechareListByTime(distributorRechargePo);
        return listResultMessage;
    }


    @ApiOperation(value = "根据表格id查询充值记录")
    @GetMapping(value = "/saveDistributorRechargeHistory/{id}")
    public ResultMessage<DistributorRecharge> saveDistributorRecharge(@PathVariable("id") Long id) {
        DistributorRecharge distributorRecharge =(DistributorRecharge)distributorRechargeServiceImpl.selectByPrimaryKey(id);
       //分销商充值账号显示
        String pinyinString = Pinyin4jUtil.getPinyinString(distributorRecharge.getDistributorName() + distributorRecharge.getDistributorId());
        distributorRecharge.setDistributorAccountNum(pinyinString);
        return new ResultMessage(distributorRecharge);
    }


    @ApiOperation(value = "设置预警余额,id传的是数据列的id")
    @PutMapping(value = "/updateMinBalance")
    public ResultMessage<DistributorAccount> updateMinBalance(@RequestBody @Valid DistributorAccount distributorAccount) {
        return new ResultMessage(distributorAccountServiceImpl.updateMinBalance(distributorAccount));
    }


    @ApiOperation(value = "查询分销商账户列表,如果没有上传分销商名称则查询所有（模糊查询）")
    @PutMapping(value = "/findDistributorAccountList")
    public ResultMessage<List<DistributorAccount>> findDistributorAccountList(@RequestBody PagePo<DistributorAccount> pagePo) {
        return distributorAccountServiceImpl.findByName(pagePo);
    }

    @ApiOperation(value = "运营商账户信息查询账户余额和已结算金额（运营商账户信息）")
    @GetMapping(value = "/selectAccountDetail")
    public ResultMessage<DistributorAccountVo> selectAccountDetail() {
        DistributorAccountVo distributorAccountVo = distributorAccountServiceImpl.queryAccountDetail();
        return ResultMessage.success(distributorAccountVo);
    }

    @ApiOperation(value = "超级管理员删除充值记录信息(数据行的id)")
    @DeleteMapping(value = "/deleteRechargeHistoryById/{id}")
    public ResultMessage<DistributorAccountVo> deleteRechargeHistoryById(@PathVariable("id") Long id) throws BusinessException {

        if(distributorRechargeServiceImpl.deleteDistributorRechargeHistoryById(id)!=1){
            throw new BusinessException("删除充值记录信息失败!");
        }
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setId(id + "");
        return resultMessage;
    }

}
