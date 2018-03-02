package com.cloud.drore.eboss.operation.controller;

import com.cloud.drore.eboos.common.base.PagePo;
import com.cloud.drore.eboos.common.base.ResultMessage;
import com.cloud.drore.eboss.operation.entity.po.CooperationManagementAddPo;
import com.cloud.drore.eboss.operation.entity.po.DistributorProductAssociationListPo;
import com.cloud.drore.eboss.operation.entity.po.DistributorsAllRelationPo;
import com.cloud.drore.eboss.operation.entity.vo.CooperationManagementAddVo;
import com.cloud.drore.eboss.operation.entity.vo.CooperationProductTypeVo;
import com.cloud.drore.eboss.operation.supplierApiService.IDistributorInfoApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 新增产品关联关系 <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/2/9 13:42 <br>
 * @Author: <a href="1451173193@qq.com">杨亮</a>
 */
@RequestMapping("/cooperationAddRelation")
@Api(value = "/运营商_合作管理_新增产品关联关系", description = "运营商_合作管理_新增产品关联关系-杨亮")
@RestController
public class CooperationManagementAddController {
    @Autowired
    private IDistributorInfoApiService distributorService;
    @ApiOperation(value = "获取产品类型列表")
    @GetMapping("/getAllProductTypeList")
    public ResultMessage<List<CooperationProductTypeVo>> getAllProductTypeList(){
        return distributorService.getProductTypeList();
    }
    @ApiOperation(value = "根据产品类型，poi，分销商id，查询分销商可添加产品列表")
    @PostMapping("/getNewRelationListByParam")
    public ResultMessage<List<CooperationManagementAddVo>> getNewRelationListByParam(@RequestBody CooperationManagementAddPo po){
        return distributorService.getNewRelationListByParam(po);
    }
    @ApiOperation(value = "批量添加协议")
    @PostMapping("/addRelationByInsertList")
    public ResultMessage addRelationByInsertList(@RequestBody DistributorProductAssociationListPo po){
        return distributorService.addRelationByInsertList(po);
    }
}
