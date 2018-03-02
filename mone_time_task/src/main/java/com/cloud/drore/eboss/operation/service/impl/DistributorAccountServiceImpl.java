package com.cloud.drore.eboss.operation.service.impl;

import com.cloud.drore.eboos.common.base.BaseServiceImpl;
import com.cloud.drore.eboos.common.base.MyMapper;
import com.cloud.drore.eboos.common.base.PagePo;
import com.cloud.drore.eboos.common.base.ResultMessage;

import com.cloud.drore.eboss.operation.entity.DistributorAccount;
import com.cloud.drore.eboss.operation.entity.FinaceSettlementHistoryOperation;
import com.cloud.drore.eboss.operation.entity.vo.DistributorAccountVo;
import com.cloud.drore.eboss.operation.mapper.DistributorMapper;
import com.cloud.drore.eboss.operation.mapper.FinaceSettlementHistoryMapper;
import com.cloud.drore.eboss.operation.service.IDistributorAccountService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
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
public class DistributorAccountServiceImpl extends BaseServiceImpl implements IDistributorAccountService {

    @Resource
    DistributorMapper distributorMapper;
    @Resource
    FinaceSettlementHistoryMapper finaceSettlementHistoryMapper;

    @Override
    public MyMapper getMapper() {
        return distributorMapper;
    }


    /**
     * @param
     * @ClassName: DistributorAccountServiceImpl
     * @Return: java.util.List<com.cloud.drore.eboss.operation.entity.DistributorAccount>
     * @Decription: 查询分销商账户列表
     * @CreateDate: Created in 2018/1/20 0020 上午 10:48
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public ResultMessage<List<DistributorAccount>> findByName(PagePo page) {
        //如果分销商id不为空，则查询账户对象
        DistributorAccount distributorAccount = (DistributorAccount) page.getFields();
        String distributorName = distributorAccount.getDistributorName();
        if (!(null == distributorName || "".equals(distributorName))) {
            return new ResultMessage(distributorMapper.selectDistributorAccount(distributorAccount.getDistributorName()));
        }

        PageHelper.startPage(page);
        List list = distributorMapper.selectAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultMessage.success(pageInfo);
    }


    /**
     * @param distributorAccount
     * @ClassName: DistributorAccountServiceImpl
     * @Return: int
     * @Decription: 修改分销商最低余额
     * @CreateDate: Created in 2018/1/17 0017 上午 10:21
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public int updateMinBalance(DistributorAccount distributorAccount) {
        return distributorMapper.updateMinBalance(distributorAccount.getId(), distributorAccount.getAccountMinBalance());
    }


    /**
     * @param
     * @ClassName: DistributorAccountServiceImpl
     * @Return: com.cloud.drore.eboss.operation.entity.vo.DistributorAccountVo
     * @Decription: 运营商查询账户信息
     * @CreateDate: Created in 2018/2/9 0009 下午 3:42
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public DistributorAccountVo queryAccountDetail() {
        DistributorAccountVo distributorAccountVo = new DistributorAccountVo();
        //查询账户余额信息
        BigDecimal distriButorAccountTotal = finaceSettlementHistoryMapper.queryFinaceSettlementDistriButorAccountBalance();
        //查询供应商已结算信息
        BigDecimal finaceSettlementHistorySupplier = finaceSettlementHistoryMapper.queryFinaceSettlementHistorySettleShould();
        distributorAccountVo.setTotalAmountAleady(finaceSettlementHistorySupplier);
        distributorAccountVo.setAccountBalance(distriButorAccountTotal);
        return distributorAccountVo;
    }

}
