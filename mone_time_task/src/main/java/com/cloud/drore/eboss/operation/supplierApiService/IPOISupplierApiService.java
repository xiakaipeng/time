package com.cloud.drore.eboss.operation.supplierApiService;

import com.cloud.drore.eboos.common.base.BaseService;
import com.cloud.drore.eboos.common.base.ResultMessage;
import com.cloud.drore.eboss.operation.entity.POIOperation;

/**
 * 浙江卓锐科技股份有限公司 版权所有 © Copyright 2018<br>
 *
 * @Description: 供应商POI接口使用<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/4 12:45 <br>
 * @Author: <a href="836327318@qq.com">夏凯</a>
 */
public interface IPOISupplierApiService extends BaseService {
    //全部poi的接口
    public ResultMessage findByName();
}
