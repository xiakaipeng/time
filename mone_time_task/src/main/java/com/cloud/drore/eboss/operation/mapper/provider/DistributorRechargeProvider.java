package com.cloud.drore.eboss.operation.mapper.provider;


import com.cloud.drore.eboos.common.base.PagePo;
import com.cloud.drore.eboos.common.util.LocalDateAndDateTransformUtil;
import com.cloud.drore.eboss.operation.entity.Merchant;
import com.cloud.drore.eboss.operation.entity.po.DistributorInfoPo;
import com.cloud.drore.eboss.operation.entity.po.DistributorRechargePo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/6 0006 下午 1:12 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
public class DistributorRechargeProvider {

    private static String selctDistributorRechareListByTime = "select * from eboss_distributor_recharge_record ";

    /**
     * @param distributorRechargePo
     * @ClassName: DistributorRechargeProvider
     * @Return: java.lang.String
     * @Decription: 通过分销商id和起止时间查询分销商的充值记录
     * @CreateDate: Created in 2018/2/24 0024 下午 12:00
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public String selctDistributorRechareListByTime(PagePo<DistributorRechargePo> distributorRechargePo) {
        String sql = selctDistributorRechareListByTime;
        DistributorRechargePo fields = distributorRechargePo.getFields();
        sql += " where distributor_id = " + fields.getDistributorId()+" and is_deleted=0";

        DateTimeFormatter sdfSqlHH = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


        if (!(null == fields.getRechargeBeginTime() || "".equals(fields.getRechargeBeginTime()))) {
            //充值开始时间
            LocalDateTime rechargeBeginTime = LocalDateAndDateTransformUtil.dateToLocalDateTime(fields.getRechargeBeginTime());
            sql += " and recharge_time>='" + sdfSqlHH.format(rechargeBeginTime) + "'";
        }
        if (!(null == fields.getRechargeEndTime() || "".equals(fields.getRechargeEndTime()))) {
            //充值结束时间
            LocalDateTime rechargeEndTime = LocalDateAndDateTransformUtil.dateToLocalDateTime(fields.getRechargeEndTime());

            sql += " and recharge_time<='" + sdfSqlHH.format(rechargeEndTime.plusDays(1)) + "'";
        }
        System.out.println(sql);
        return sql;
    }


}
