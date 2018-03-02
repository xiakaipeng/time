package com.cloud.drore.eboss.operation.service.impl;

import com.cloud.drore.eboos.common.base.BaseServiceImpl;
import com.cloud.drore.eboos.common.base.MyMapper;
import com.cloud.drore.eboos.common.base.PagePo;
import com.cloud.drore.eboos.common.base.ResultMessage;
import com.cloud.drore.eboos.common.util.DateToStringUtil;
import com.cloud.drore.eboos.common.util.LocalDateAndDateTransformUtil;

import com.cloud.drore.eboos.exception.BusinessException;
import com.cloud.drore.eboss.operation.entity.DistributorAccount;
import com.cloud.drore.eboss.operation.entity.DistributorRecharge;

import com.cloud.drore.eboss.operation.entity.po.DistributorRechargePo;
import com.cloud.drore.eboss.operation.entity.vo.DistributorAccountDeleteRechargeVo;
import com.cloud.drore.eboss.operation.mapper.DistributorMapper;
import com.cloud.drore.eboss.operation.mapper.DistributorRechargeMapper;
import com.cloud.drore.eboss.operation.service.IDistributorRechargeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 浙江卓锐科技股份有限公司 版权所有 © Copyright 2018<br>
 *
 * @Description: 分销商充值业务层<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/4 12:45 <br>
 * @Author: <a href="836327318@qq.com">吴昌益</a>
 */
@Service
public class DistributorRechargeServiceImpl extends BaseServiceImpl implements IDistributorRechargeService {

    @Resource
    DistributorRechargeMapper distributorRechargeMapper;

    @Resource
    DistributorMapper distributorMapper;

    @Override
    public MyMapper getMapper() {
        return distributorRechargeMapper;
    }


    /**
     * @param id
     * @ClassName: DistributorRechargeServiceImpl
     * @Return: com.cloud.drore.eboss.operation.entity.DistributorRecharge
     * @Decription: 分销商充值查看
     * @CreateDate: Created in 2018/1/19 0019 下午 12:02
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public DistributorRecharge findDistributorRecharge(Long id) {
        return distributorRechargeMapper.selectByPrimaryKey(id);
    }

    /**
     * @param distributorRechargePo
     * @ClassName: DistributorRechargeServiceImpl
     * @Return: java.util.List<com.cloud.drore.eboss.operation.entity.DistributorRecharge>
     * @Decription: 根据时间查询单个分销商历史记录充值列表 蒙哥凯特
     * @CreateDate: Created in 2018/1/19 0019 下午 4:27
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public ResultMessage<List<DistributorRecharge>> selectDistributorRechareListByTime(PagePo<DistributorRechargePo> distributorRechargePo) {

        PageHelper.startPage(distributorRechargePo);
        List<DistributorRecharge> distributorRechargeList = distributorRechargeMapper.selctDistributorRechareListByTime(distributorRechargePo);
        PageInfo pageInfo = new PageInfo<>(distributorRechargeList);
        return ResultMessage.success(pageInfo);
    }

    /**
     * @param id
     * @ClassName: DistributorRechargeServiceImpl
     * @Return: java.util.List<com.cloud.drore.eboss.operation.entity.DistributorRecharge>
     * @Decription: 根据分销商id，查询充值记录列表
     * @CreateDate: Created in 2018/1/19 0019 下午 4:17
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public List<DistributorRecharge> selctDistributorRechareList(Long id) {
        return distributorRechargeMapper.selctDistributorRechareList(id);
    }


    public ResultMessage findByName(PagePo page) {
        PageHelper.startPage(page);
        List list = distributorRechargeMapper.selectAll();
        return new ResultMessage(new PageInfo<>(list));
    }

    /**
     * @param distributorRecharge
     * @ClassName: FinaceSupplierRechargeServiceImpl
     * @Return: void
     * @Decription: 分销商充值金额的时候更新分销商账户列表
     * @CreateDate: Created in 2018/2/8 0008 下午 8:29
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */

    @Transactional
    public void addDistributorAccountAmount(DistributorRecharge distributorRecharge) throws BusinessException {

        Object insertFlag = insert(distributorRecharge);
        if (null == insertFlag || "".equals(insertFlag)) {
            throw new BusinessException("上传的字段数据类型有误!");
        }
        //查询得到分销商账户余额信息
        DistributorAccount distributorAccount = distributorMapper.selectDistributorId(distributorRecharge.getDistributorId());
        BigDecimal distributorAccountAmount = distributorAccount.getAccountBalance();
        //账户余额信息
        BigDecimal distributorAccountAmountTotal;
        //已结算金额更新
        if (null == distributorAccountAmount || "".equals(distributorAccountAmount)) {
            distributorAccountAmountTotal = new BigDecimal("0").add(distributorAccountAmount);
        } else {
            distributorAccountAmountTotal = distributorRecharge.getAccountArrivalAmount().add(distributorAccountAmount);
        }
        //修改分销商账户最新一次的充值时间，另外再修改账户余额信息
        Date date = LocalDateAndDateTransformUtil.localDateTimeToDate(LocalDateTime.now());
        //通过分销商id查询分销商账户信息
        distributorRechargeMapper.updateDistributorRechargeTimeAndAmount(distributorAccount.getId(), distributorAccountAmountTotal, DateToStringUtil.getStringDateTime(date));
    }


    /**
     * @param id
     * @ClassName: DistributorAccountServiceImpl
     * @Return: int
     * @Decription: 超级管理员通过表id删除分销商历史充值记录信息，这里要判断是否是管理员权限（蒙哥凯特）
     * @CreateDate: Created in 2018/2/24 0024 下午 1:28
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    @Transactional
    public int deleteDistributorRechargeHistoryById(Long id) {

        //查询得到分销商账户余额信息需要重新进行更新的账户余额信息
        DistributorAccountDeleteRechargeVo distributorAccountAmount = distributorMapper.selectWhenDeleteDistributorAccountAmount(id);
        //修改分销商账户余额信息
        distributorMapper.updateDistributorAccoutAmount(distributorAccountAmount.getDistributorId(),distributorAccountAmount.getDistributorAccountAmount());
        //逻辑删除分销商账户的充值信息
        return distributorRechargeMapper.updateDistributorRechargeHistory(id);
    }


}
