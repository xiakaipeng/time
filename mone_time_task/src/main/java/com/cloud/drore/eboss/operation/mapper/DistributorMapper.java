package com.cloud.drore.eboss.operation.mapper;

import com.cloud.drore.eboos.common.base.MyMapper;
import com.cloud.drore.eboss.operation.entity.DistributorAccount;
import com.cloud.drore.eboss.operation.entity.FinaceSourseDataOperation;
import com.cloud.drore.eboss.operation.entity.po.DistributorInfoPo;
import com.cloud.drore.eboss.operation.entity.po.ProductToDistributorPo;
import com.cloud.drore.eboss.operation.entity.vo.DistributorAccountDeleteRechargeVo;
import com.cloud.drore.eboss.operation.entity.vo.DistributorInfoVo;
import com.cloud.drore.eboss.operation.entity.vo.ProductToDistributorSettingVo;
import com.cloud.drore.eboss.operation.mapper.provider.MerchantProvider;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
import java.util.List;


/**
 * 浙江卓锐科技股份有限公司 版权所有 © Copyright 2018<br>
 *
 * @Description: 分销商账户mapper<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/4 12:42 <br>
 * @Author: <a href="836327318@qq.com">夏凯</a>
 */
public interface DistributorMapper extends MyMapper<DistributorAccount> {
    String updateMinBalance = "update eboss_distributor_account set account_min_balance = ${accountMinBalance} where id = ${id}";
    String selectDistributorAccount = "select * from eboss_distributor_account where distributor_name like '%${distributor_name}%'";

    @Update(updateMinBalance)
    int updateMinBalance(@Param("id") Long id, @Param("accountMinBalance") BigDecimal accountMinBalance);

    //根据分销商id查询分销商账户
    @Select(selectDistributorAccount)
    List<DistributorAccount> selectDistributorAccount(@Param("distributor_name") String distributorName);

    //获取分销商列表
    @SelectProvider(type = MerchantProvider.class, method = "getDistributorListSql")
    List<DistributorInfoVo> getDistributorListByParam(DistributorInfoPo po);

    //获取分销商列表（门票-设置分销商）
    @SelectProvider(type = MerchantProvider.class, method = "getDistributorListByTicketIdSql")
    List<ProductToDistributorSettingVo> getDistributorListByTicket(Long id);

    //获取分销商列表（组合门票-设置分销商）
    @SelectProvider(type = MerchantProvider.class, method = "getDistributorListByCombinationIdSql")
    List<ProductToDistributorSettingVo> getDistributorListByCombination(Long id);

    //根据分销商id查询分销商账户id
    @Select("select id,account_balance  from eboss_distributor_account where distributor_id=${distributorId}")
    DistributorAccount selectDistributorId(@Param("distributorId") Long id);

    //根据分销商id修改分销商账户的余额，进行结算
    @Update("update eboss_distributor_account set account_balance= '${accountBalance}' where distributor_id=${id}")
    int updateDistributorAccountAmount(@Param("accountBalance") BigDecimal accountBalance,@Param("id")Long id);
    //根据分销商id查询得到当前账户的余额并进行结算
    @Select("select account_balance from eboss_distributor_account where  distributor_id=${id}")
    BigDecimal selectDistributorAccountAmount(@Param("id")Long id);
    //根据分销商充值记录的id查询得到分销商账户的余额
    @Select("select (b.account_balance-a.recharge_amount) as distributorAccountAmount,a.distributor_id\n" +
            "from  eboss_distributor_recharge_record a  left join  eboss_distributor_account b on a.distributor_id=b.distributor_id \n" +
            "where a.id = ${id}\n")
    DistributorAccountDeleteRechargeVo selectWhenDeleteDistributorAccountAmount(@Param("id")Long id);
    //超级管理员删除分销商充值记录信息的时候跟新分销商账户余额信息
    @Update("update eboss_distributor_account set account_balance='${distributorAccountAmount}' where distributor_id=${id}")
    int updateDistributorAccoutAmount(@Param("id")Long id,@Param("distributorAccountAmount")BigDecimal distributorAccountAmount);
}
