package com.cloud.drore.eboss.operation.service;

import com.cloud.drore.eboos.exception.BusinessException;
import com.cloud.drore.eboss.operation.entity.Merchant;


/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/9 0009 下午 1:32 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
public interface IMerchantService {

    public int update(Merchant merchant);

    public int delete(Object key);
    public int back(Object key);
    public Merchant selectDictory(Merchant merchant) throws BusinessException;
}
