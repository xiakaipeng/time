package com.cloud.drore.eboss.operation.mapper;

import com.cloud.drore.eboos.common.base.MyMapper;
import com.cloud.drore.eboos.common.base.PagePo;
import com.cloud.drore.eboss.operation.entity.DistributorAccount;
import com.cloud.drore.eboss.operation.entity.DistributorRecharge;

import com.cloud.drore.eboss.operation.entity.po.DistributorRechargePo;
import com.cloud.drore.eboss.operation.mapper.provider.DistributorRechargeProvider;
import com.cloud.drore.eboss.operation.mapper.provider.MerchantProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
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
public interface DistributorRechargeMapper extends MyMapper<DistributorRecharge> {
    String selctDistributorRechareList = "select * from eboss_distributor_recharge_record where distributor_id = ${id} and is_deleted=0  ";

    @Select(selctDistributorRechareList)
    List<DistributorRecharge> selctDistributorRechareList(@Param("id") Long id);

    //根据时间查询分销商充值历史记录表
    //@Select(selctDistributorRechareListByTime)
    @SelectProvider(type = DistributorRechargeProvider.class, method = "selctDistributorRechareListByTime")
    List<DistributorRecharge> selctDistributorRechareListByTime(PagePo<DistributorRechargePo> distributorRechargePo);

    //修改分销商账户充值信息
    @Update("update eboss_distributor_account set recent_recharge_time='${date}',account_balance=${distributorAccountAmountTotal}" +
            " where id=${id}")
    int updateDistributorRechargeTimeAndAmount(@Param("id") Long id,
                                               @Param("distributorAccountAmountTotal") BigDecimal distributorAccountAmountTotal,
                                               @Param("date") String date);

    //删除分销商历史充值记录信息
    @Update("update eboss_distributor_recharge_record set is_deleted=1 where id=${id}")
    int updateDistributorRechargeHistory(@Param("id") Long id);
}
