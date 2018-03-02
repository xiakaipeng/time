package com.cloud.drore.eboss.operation.supplierApiService;

import com.cloud.drore.eboos.common.base.BaseService;
import com.cloud.drore.eboos.common.base.ResultMessage;
import com.cloud.drore.eboss.operation.entity.Merchant;
import com.cloud.drore.eboss.operation.entity.vo.DictionaryMerchantVo;

import java.util.List;

/**
 * 浙江卓锐科技股份有限公司 版权所有 © Copyright 2018<br>
 *
 * @Description: 供应商商户接口使用<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/4 12:45 <br>
 * @Author: <a href="836327318@qq.com">夏凯</a>
 */
public interface IMerchantSupplierApiService extends BaseService {
    //全部供应商
    public List<Merchant> selectMerchantList();

    //全部分销商
    public List<Merchant> selectMerchantListDistributor();
}
