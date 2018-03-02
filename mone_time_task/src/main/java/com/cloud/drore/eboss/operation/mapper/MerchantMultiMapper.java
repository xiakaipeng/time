package com.cloud.drore.eboss.operation.mapper;

import com.cloud.drore.eboos.common.base.MyMapper;
import com.cloud.drore.eboss.operation.entity.Merchant;
import com.cloud.drore.eboss.operation.entity.MerchantManage;
import com.cloud.drore.eboss.operation.entity.MerchantMulti;
import com.cloud.drore.eboss.operation.mapper.provider.MerchantProvider;
import org.apache.ibatis.annotations.*;
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
public interface MerchantMultiMapper extends MyMapper<MerchantMulti> {
    String updateMerchantMultiStateYesSql = "update eboos_merchant_multi set state = \"1\" where dic_code = \"${dicCode}\" and merchant_id = \"${merchantId}\"";
    String updateMerchantMultiStateNoSql = "update eboos_merchant_multi set state = \"0\" where dic_code = \"${dicCode}\" and merchant_id = \"${merchantId}\"";
    String selectMerchantMultiList= "select dic_code from eboos_merchant_multi where merchant_id = ${merchantId}";

    //修改商户多选框信息为可使用
    @Update(updateMerchantMultiStateYesSql)
    int updateMerchantMultiStateYesSql(@Param("merchantId") Long merchantId, @Param("dicCode") String dicCode);

    //修改商户多选框信息为可使用
    @Update(updateMerchantMultiStateNoSql)
    int updateMerchantMultiStateNoSql(@Param("merchantId") Long merchantId, @Param("dicCode") String dicCode);

    //通过商户id查询销售产品类型所有信息
    @Select(selectMerchantMultiList)
    List<MerchantMulti> selectMerchantMultiList(@Param("merchantId") Long merchantId);
}
