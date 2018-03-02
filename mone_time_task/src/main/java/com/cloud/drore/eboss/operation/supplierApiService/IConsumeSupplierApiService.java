package com.cloud.drore.eboss.operation.supplierApiService;

import com.cloud.drore.eboos.common.base.BaseService;
import com.cloud.drore.eboos.common.base.ResultMessage;
import com.cloud.drore.eboss.operation.entity.POIOperation;

/**
 * 浙江卓锐科技股份有限公司 版权所有 © Copyright 2018<br>
 *
 * @Description: 供应商消费点接口使用<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/4 12:45 <br>
 * @Author: <a href="836327318@qq.com">夏凯</a>
 */
public interface IConsumeSupplierApiService extends BaseService {
    //根据消费点id查询对应景区
    public POIOperation getPOIById(Long id);

    //根据POI的对象，查询对应的消费点集合的接口
    public ResultMessage findConsumeList(POIOperation poiOperation);

    //根查询poi列表的接口
    public ResultMessage findByName();
}
