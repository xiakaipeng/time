package com.cloud.drore.eboss.operation.service.impl;

import com.cloud.drore.eboos.common.base.BaseServiceImpl;
import com.cloud.drore.eboos.common.base.MyMapper;
import com.cloud.drore.eboos.common.util.DateToStringUtil;
import com.cloud.drore.eboos.common.util.Pinyin4jUtil;
import com.cloud.drore.eboos.exception.BusinessException;
import com.cloud.drore.eboss.operation.entity.FinaceSettlementHistoryOperation;
import com.cloud.drore.eboss.operation.entity.FinaceSupplierSettlementVoucherHistory;
import com.cloud.drore.eboss.operation.entity.po.SupplierRechargeHistoryPo;
import com.cloud.drore.eboss.operation.entity.vo.SupplierSelectRechargeHistoryVo;
import com.cloud.drore.eboss.operation.entity.vo.SupplierSettlementVoucherHistoryVo;
import com.cloud.drore.eboss.operation.mapper.DistributorRechargeMapper;
import com.cloud.drore.eboss.operation.mapper.FinaceSupplierRechargeMapper;
import com.cloud.drore.eboss.operation.service.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 浙江卓锐科技股份有限公司 版权所有 © Copyright 2018<br>
 *
 * @Description: 分销商订单查询财务相关信息<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/4 12:45 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Service
public class FinaceSupplierRechargeServiceImpl extends BaseServiceImpl implements IFinaceSupplierRechargeService {


    @Resource
    FinaceSupplierRechargeMapper finaceSupplierRechargeMapper;


    @Override
    public MyMapper getMapper() {
        return finaceSupplierRechargeMapper;
    }


    /**
     * @param finaceSupplierSettlementVoucherHistory
     * @ClassName: FinaceSupplierRechargeServiceImpl
     * @Return: com.cloud.drore.eboss.operation.entity.FinaceSupplierSettlementVoucherHistory
     * @Decription: 新增充值凭证-》对供应商的充值总数进行记录
     * @CreateDate: Created in 2018/2/8 0008 下午 4:29
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    @Transactional
    public FinaceSupplierSettlementVoucherHistory rechargeSupplier(FinaceSupplierSettlementVoucherHistory finaceSupplierSettlementVoucherHistory) {

        FinaceSupplierSettlementVoucherHistory finaceSupplierSettlementVoucher = (FinaceSupplierSettlementVoucherHistory) insert(finaceSupplierSettlementVoucherHistory);
        updateRechargeCount(finaceSupplierSettlementVoucher);
        return finaceSupplierSettlementVoucher;
    }

    /**
     * @param finaceSupplierSettlementVoucher
     * @ClassName: FinaceSupplierRechargeServiceImpl
     * @Return: void
     * @Decription: 对供应商的充值总数进行记录修改，需要加上新增充值记录的总和，同时改变历史记录金额总数（指的是资质凭证的添加），另外修改最近一次的充值时间
     * @CreateDate: Created in 2018/2/8 0008 下午 5:06
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public void updateRechargeCount(FinaceSupplierSettlementVoucherHistory finaceSupplierSettlementVoucher) {
        //查询得到目前待结算期数的金额给他进行相加
        FinaceSettlementHistoryOperation finaceSettlementHistoryOperation = finaceSupplierRechargeMapper.selectFinaceSettlementHistory(finaceSupplierSettlementVoucher.getFinaceSettlementHistoryId());

        BigDecimal addSettlementAleady;
        //已结算金额更新
        if (null == finaceSettlementHistoryOperation || "".equals(finaceSettlementHistoryOperation)) {
            addSettlementAleady = new BigDecimal("0").add(finaceSupplierSettlementVoucher.getSettlementAmount());
        } else {
            addSettlementAleady = finaceSettlementHistoryOperation.getTotalAmountAleady().add(finaceSupplierSettlementVoucher.getSettlementAmount());
        }


        FinaceSupplierSettlementVoucherHistory selectChoice = new FinaceSupplierSettlementVoucherHistory();
        selectChoice.setIsDeleted(0);
        selectChoice.setFinaceSettlementHistoryId(finaceSupplierSettlementVoucher.getFinaceSettlementHistoryId());
        //一次充值的次数
        int count = finaceSupplierRechargeMapper.selectCount(selectChoice);
        //修改充值的总次数
        finaceSupplierRechargeMapper.updateSupplierRechargeCounts(addSettlementAleady, count, finaceSupplierSettlementVoucher.getFinaceSettlementHistoryId(), DateToStringUtil.getStringDateTime(finaceSupplierSettlementVoucher.getSettlementTime()));

    }

    /**
     * @param supplierRechargeHistoryPo
     * @ClassName: FinaceSupplierRechargeServiceImpl
     * @Return: com.cloud.drore.eboss.operation.entity.vo.SupplierSettlementVoucherHistoryVo
     * @Decription: 根据分销商id和充值历史记录表的id查询对应的充值记录凭证
     * @CreateDate: Created in 2018/2/27 0027 下午 5:07
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public List<SupplierSettlementVoucherHistoryVo> querySuppplierRechargeHistory(SupplierRechargeHistoryPo supplierRechargeHistoryPo) {
        List<SupplierSettlementVoucherHistoryVo> supplierSettlementVoucherHistoryVos = finaceSupplierRechargeMapper.finaceSupplierRecharge(supplierRechargeHistoryPo.getSupplierId(), supplierRechargeHistoryPo.getSettlementStageId());
        List<SupplierSettlementVoucherHistoryVo> collect = supplierSettlementVoucherHistoryVos.stream().map(supplierSettlementVoucherHistoryVo ->
        {
            //获取到供应商的拼音拼接id
            String pinyinString = Pinyin4jUtil.getPinyinString(supplierSettlementVoucherHistoryVo.getSupplierName()) + "H" + supplierRechargeHistoryPo.getSettlementStageId() + "S" + supplierRechargeHistoryPo.getSupplierId();
            supplierSettlementVoucherHistoryVo.setSupplierAccountNum(pinyinString);
            return supplierSettlementVoucherHistoryVo;
        }).collect(Collectors.toList());
        return collect;
    }


    /**
     * @param id
     * @ClassName: DistributorAccountServiceImpl
     * @Return: int
     * @Decription: 超级管理员通过结算周期（表）id删除供应商历史充值记录信息，这里要判断是否是管理员权限（蒙哥凯特）
     * @CreateDate: Created in 2018/2/24 0024 下午 1:28
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    @Transactional
    public int deleteSupplierRechargeHistoryById(Long id) throws BusinessException {
        //查询得到当前结算周期已经结算掉的金额，查询当前凭证相加的总金额得到已经结算掉的金额-查询当前凭证相加的总金额
        SupplierSelectRechargeHistoryVo supplierSelectRechargeHistoryVo = finaceSupplierRechargeMapper.selectSettlementAmountTotal(id);
        //更新当前结算周期已结算金额
        if(supplierSelectRechargeHistoryVo.getSettlementCount()-1<0){
            throw new BusinessException("异常删除请求！");
        }
        finaceSupplierRechargeMapper.updateSettlementHistoryAleady(id,supplierSelectRechargeHistoryVo.getSettlementAmountTotal(),supplierSelectRechargeHistoryVo.getSettlementCount()-1);
        //将已充值的金额变为无效状态
        return finaceSupplierRechargeMapper.updateSupplierSettlementVoucher(id);
    }
}
