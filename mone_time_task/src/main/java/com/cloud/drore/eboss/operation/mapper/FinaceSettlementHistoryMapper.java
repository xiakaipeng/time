package com.cloud.drore.eboss.operation.mapper;

import com.cloud.drore.eboos.common.base.MyMapper;
import com.cloud.drore.eboos.common.base.PagePo;
import com.cloud.drore.eboss.operation.entity.FinaceSettlementFlagOperation;
import com.cloud.drore.eboss.operation.entity.FinaceSettlementHistoryOperation;
import com.cloud.drore.eboss.operation.entity.po.FinaceSettlementHistoryPo;
import com.cloud.drore.eboss.operation.entity.po.FinaceSourseDataOperationPo;
import com.cloud.drore.eboss.operation.entity.po.FundSettlementPo;
import com.cloud.drore.eboss.operation.entity.vo.FinaceSourseDataOperationAndSupplierVo;
import com.cloud.drore.eboss.operation.entity.vo.FundSettlementTotalVo;
import com.cloud.drore.eboss.operation.entity.vo.FundSettlementVo;
import com.cloud.drore.eboss.operation.entity.vo.SupplierSelectHistoryRecenetTimeVo;
import com.cloud.drore.eboss.operation.mapper.provider.FinaceSettlementHistoryProvider;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
import java.util.List;


/**
 * 浙江卓锐科技股份有限公司 版权所有 © Copyright 2018<br>
 *
 * @Description: 财务管理结算历史记录<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/31 12:42 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
public interface FinaceSettlementHistoryMapper extends MyMapper<FinaceSettlementHistoryOperation> {

    @Select("select auto_settlement_time,current_year_settlement_stage from eboss_finace_settlement_flag_time where supplier_id = ${id}")
        //根据供应商id查询当前结算期数的年份
    FinaceSettlementFlagOperation getCurrentSettlmentYear(@Param("id") Long id);

    @Update("update eboss_finace_settlement_flag_time set auto_settlement_time = '${time}',current_year_settlement_stage = '${stage}' where supplier_id = ${id}")
    int updateFinaceSettlementFlagOperation(@Param("time") String date, @Param("stage") int stage, @Param("id") Long id);

    @Insert("insert into eboss_finace_settlement_flag_time (supplier_id,auto_settlement_time,current_year_settlement_stage) values (id,'${time}','${stage}')")
    int insertFinaceSettlementFlagOperation(@Param("time") String date, @Param("stage") int stage, @Param("id") Long id);

    @SelectProvider(type = FinaceSettlementHistoryProvider.class, method = "queryFinaceSettlementHistoryList")
        //@Select("select * from eboss_finace_settlement_history where settlement_end_time<='${endTime}' and settlement_end_time>='${beginTime}'")
    List<FinaceSettlementHistoryOperation> findFinaceSettlementHistoryList(FinaceSettlementHistoryPo finaceSettlementHistoryPo);

    @Select("select settlement_stage from eboss_finace_settlement_history where merchant_id = ${id}")
    List<FinaceSettlementHistoryOperation> queryStageOperationList(@Param("id") Long id);

    //查询所有已结算的供应商金额
    @Select("select sum(total_amount_should) as total_amount_should from eboss_finace_settlement_history")
    BigDecimal queryFinaceSettlementHistorySettleShould();

    //查询所有账户余额
    @Select("select sum(account_balance) as account_balance from eboss_distributor_account")
    BigDecimal queryFinaceSettlementDistriButorAccountBalance();

    //运营商资金结算数据查询
    @SelectProvider(type = FinaceSettlementHistoryProvider.class, method = "queryFundSettlementList")
    List<FundSettlementVo> queryFundSettlement(FundSettlementPo fundSettlementPo);

    //资金结算平台三个收入数据
    String queryFundSettlementTotalData = "select sum(total_amount_income) as total_amount_income,sum(total_amount_aleady) as  total_amount_aleady,\n" +
            "sum(total_amount_income-total_amount_should) as net_profit\n" +
            "from eboss_finace_settlement_history";

    @Select(queryFundSettlementTotalData)
    FundSettlementTotalVo queryFundSettlementTotalData();

    //运营商、供应商查询收入报表
    @SelectProvider(type = FinaceSettlementHistoryProvider.class, method = "queryFundSettlementFormOperation")
    List<FinaceSourseDataOperationAndSupplierVo> queryFundSettlementFormOperation(PagePo<FinaceSourseDataOperationPo> page);

    //根据id判断当前结算记录供应商是否进行过充值
    @Select("select settlement_flag from eboss_finace_settlement_history where id=${id}")
    Object queryRechargeCount(@Param("id") Long id);
    //根据供应商id判断是否进行自动结算过
    @Select("select count(1) as supplierSettlementFlag,settlement_end_time from eboss_finace_settlement_history where merchant_id=${id} order by settlement_end_time limit 1")
    SupplierSelectHistoryRecenetTimeVo querySupplierSettlementCount(@Param("id") Long id);
    //根据供应商id判断当前供应商结算标识
}
