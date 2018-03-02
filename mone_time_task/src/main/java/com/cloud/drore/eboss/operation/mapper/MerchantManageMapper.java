package com.cloud.drore.eboss.operation.mapper;

import com.cloud.drore.eboos.common.base.MyMapper;
import com.cloud.drore.eboss.operation.entity.MerchantManage;
import com.cloud.drore.eboss.operation.mapper.provider.MerchantProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/6 0006 下午 1:11 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */

@Repository
public interface MerchantManageMapper extends MyMapper<MerchantManage> {
    String addMerchantManageSql = "update eboos_merchant set merchant_manager = ${merchantManagerId} where id= ${id}";

    String updatePassword = "update eboos_merchant_manage set account_pwd = '123456' where id= ${merchantManagerId} ";
    @Update(addMerchantManageSql)
        //给商户添加管理员
    int addMerchantManageSql(@Param("merchantManagerId") Long merchantManagerId, @Param("id") Long id);

    @Update(updatePassword)
        //重置管理员密码为初始密码
    int updatePassword(@Param("merchantManagerId") Long merchantManagerId);
}
