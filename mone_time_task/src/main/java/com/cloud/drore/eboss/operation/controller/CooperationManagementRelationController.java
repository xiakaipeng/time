package com.cloud.drore.eboss.operation.controller;

import com.cloud.drore.eboos.common.base.PagePo;
import com.cloud.drore.eboos.common.base.ResultMessage;
import com.cloud.drore.eboss.operation.entity.po.CooperationSetPriceForRelationPo;
import com.cloud.drore.eboss.operation.entity.po.DistributorsAllRelationPo;
import com.cloud.drore.eboss.operation.supplierApiService.IDistributorInfoApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 关联列表controller<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/2/9 9:15 <br>
 * @Author: <a href="1451173193@qq.com">杨亮</a>
 */
@RequestMapping("/cooperationRelation")
@Api(value = "/运营商_合作管理_关系列表接口", description = "运营商_合作管理_关系列表接口-杨亮")
@RestController
public class CooperationManagementRelationController {
    @Resource
    IDistributorInfoApiService distributorService;
    @ApiOperation(value = "根据分销商id,产品名称获取已上架的产品列表")
    @PostMapping("/getDistributorsAllRelation")
    public ResultMessage getDistributorsAllRelation(@RequestBody PagePo<DistributorsAllRelationPo> pagePo){

        return distributorService.getDistributorsAllRelation(pagePo);
    }

    @ApiOperation(value = "设置协议价格")
    @PutMapping("/setPriceForRelation")
    public ResultMessage setPriceForRelation(@RequestBody CooperationSetPriceForRelationPo po){

        return distributorService.setPriceForRelation(po);
    }

    @ApiOperation(value = "删除协议关联")
    @DeleteMapping("/deleteRelation/{relationId}")
    public ResultMessage deleteRelation(@PathVariable Long relationId){

        return distributorService.deleteRelation(relationId);
    }
}
