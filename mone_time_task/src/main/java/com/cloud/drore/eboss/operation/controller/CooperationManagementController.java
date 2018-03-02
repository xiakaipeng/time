package com.cloud.drore.eboss.operation.controller;

import com.cloud.drore.eboos.common.base.PagePo;
import com.cloud.drore.eboos.common.base.ResultMessage;
import com.cloud.drore.eboss.operation.entity.po.DistributorInfoPo;
import com.cloud.drore.eboss.operation.entity.po.DistributorsAllRelationPo;
import com.cloud.drore.eboss.operation.entity.vo.DistributorInfoVo;
import com.cloud.drore.eboss.operation.supplierApiService.IDistributorInfoApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/distributorInfo")
@Api(value = "/运营商_合作管理接口", description = "运营商_合作管理接口-杨亮")
@RestController
public class CooperationManagementController {
    @Resource
    IDistributorInfoApiService distributorService;
    @ApiOperation(value = "查询分销商列表")
    @PostMapping("/getDistributorList")
    public ResultMessage<List<DistributorInfoVo>> getDistributorList(@RequestBody PagePo<DistributorInfoPo> pagePo){

        return distributorService.getDistributorList(pagePo);
    }


}
