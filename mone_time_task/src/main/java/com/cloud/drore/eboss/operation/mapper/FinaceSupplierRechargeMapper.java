package com.cloud.drore.eboss.operation.mapper;

import com.cloud.drore.eboos.common.base.MyMapper;

import com.cloud.drore.eboss.operation.entity.FinaceSettlementHistoryOperation;
import com.cloud.drore.eboss.operation.entity.FinaceSupplierSettlementVoucherHistory;
import com.cloud.drore.eboss.operation.entity.vo.SupplierSelectRechargeHistoryVo;
import com.cloud.drore.eboss.operation.entity.vo.SupplierSettlementVoucherHistoryVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * 浙江卓锐科技股份有限公司 版权所有 © Copyright 2018<br>
 *
 * @Description: 分销商充值记录mapper<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/4 12:42 <br>
 * @Author: <a href="836327318@qq.com">夏凯</a>
 */
public interface FinaceSupplierRechargeMapper extends MyMapper<FinaceSupplierSettlementVoucherHistory> {

    @Update("update eboss_finace_settlement_history set settlement_count= ${count},total_amount_aleady=${addSettlementAleady},recenetly_recharge_time='${settlementTime}' where id=${finaceSettlementHistoryId} ")
    int updateSupplierRechargeCounts(@Param("addSettlementAleady") BigDecimal addSettlementAleady, @Param("count") int count,
                                     @Param("finaceSettlementHistoryId") Long finaceSettlementHistoryId,@Param("settlementTime") String settlementTime);

    //查询当前结算期数历史已经充值的金额记录，用于供应商核对结算历史记录信息
    @Select("select total_amount_aleady from eboss_finace_settlement_history where id ='${finaceSettlementHistoryId}'")
    FinaceSettlementHistoryOperation selectFinaceSettlementHistory(@Param("finaceSettlementHistoryId") Long finaceSettlementHistoryId);
    //根据供应商id和供应商结算历史记录表的id查询供应商的充值凭证
    @Select("select settlement_amount,settlement_time,voucher,(select merchant_name from eboos_merchant where id = ${supplierId}) as supplier_name from eboss_supplier_settlement_voucher where " +
            "supplier_id=${supplierId} and finace_settlement_history_id=${settlementStageId}")
    List<SupplierSettlementVoucherHistoryVo> finaceSupplierRecharge(@Param("supplierId") Long supplierId,@Param("settlementStageId") Long settlementStageId);

    //查询删除供应商的充值凭证之后得到对应的结算周期剩余已结算
    @Select("select (a.total_amount_aleady -sum(b.settlement_amount)) as settlement_amount_total,settlement_count\n" +
            "from  eboss_finace_settlement_history a \n" +
            "left join eboss_supplier_settlement_voucher b on a.id=b.finace_settlement_history_id\n" +
            "where b.finace_settlement_history_id=${id}")
    SupplierSelectRechargeHistoryVo selectSettlementAmountTotal(@Param("id") Long id);
    //根据结算周期的id更新供应商已结算的金额
    @Update("update eboss_finace_settlement_history set total_amount_aleady='${totalAmountAleady}',settlement_count=${count}  where id=${id}")
    int updateSettlementHistoryAleady(@Param("id") Long id,@Param("totalAmountAleady") BigDecimal totalAmountAleady,@Param("count") Integer count);
    //将供应商的充值记录变为无效状态
    @Update("update eboss_supplier_settlement_voucher set is_deleted=1 where finace_settlement_history_id=${id}")
    int updateSupplierSettlementVoucher(@Param("id") Long id);

}
