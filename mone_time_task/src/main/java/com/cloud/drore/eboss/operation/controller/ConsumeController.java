package com.cloud.drore.eboss.operation.controller;

import com.cloud.drore.eboos.common.base.PagePo;
import com.cloud.drore.eboos.common.base.ResultMessage;
import com.cloud.drore.eboos.exception.BusinessException;
import com.cloud.drore.eboss.operation.entity.ConsumeOperation;
import com.cloud.drore.eboss.operation.entity.Merchant;
import com.cloud.drore.eboss.operation.entity.POIOperation;
import com.cloud.drore.eboss.operation.service.impl.ConsumeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.sql.ResultSet;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 消费点接口<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/6 0006 下午 5:45 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@RestController
@RequestMapping("/consume")
@Api(value = "/消费点接口", description = "消费点管理接口-夏凯")
public class ConsumeController {
    @Resource
    ConsumeServiceImpl consumeServiceImpl;


    @ApiOperation(value = "保存信息（新增消费点）")
    @PostMapping(value = "/save")
    public ResultMessage save(@RequestBody @Validated ConsumeOperation consumeOperation) {
        consumeServiceImpl.insertConsume(consumeOperation);
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setId(consumeOperation.getId() + "");
        return resultMessage;
    }

    @ApiOperation(value = "更新信息")
    @PutMapping(value = "/update")
    public ResultMessage update(@RequestBody @Validated({ConsumeOperation.SAVE.class}) ConsumeOperation consumeOperation) throws BusinessException {

        if (consumeServiceImpl.updateConsume(consumeOperation) != 1) {
            throw new BusinessException("更新失败！");
        }
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setId(consumeOperation.getId() + "");
        return resultMessage;
    }

    @ApiOperation(value = "删除信息")
    @DeleteMapping(value = "/delete/{id}")
    public ResultMessage<ConsumeOperation> delete(@PathVariable("id") Long id) {
        return new ResultMessage(consumeServiceImpl.deleteByPrimaryKey(id));
    }

    @ApiOperation(value = "通过消费点id获取信息")
    @GetMapping(value = "/{id}")
    public ResultMessage<ConsumeOperation> get(@PathVariable("id") Long id) {

        return new ResultMessage(consumeServiceImpl.selectByPrimaryKey(id));
    }

    @ApiOperation(value = "查询消费点列表信息")
    @PostMapping(value = "find")
    public ResultMessage<ConsumeOperation> find(@RequestBody PagePo<ConsumeOperation> pagePo) {
        return consumeServiceImpl.findByName(pagePo);
    }


    @ApiOperation(value = "查询所有消费点信息（提供给供应商接口）")
    @GetMapping(value = "findTotalConsumeList")
    public ResultMessage<ConsumeOperation> findTotalConsumeList() {
        return consumeServiceImpl.findTotalConsumeList();
    }


    @ApiOperation(value = "根据POI的id，查询对应的消费点集合的接口")
    @GetMapping(value = "/getConsumeListByPOI/{consume_poi_id}")
    public ResultMessage<ConsumeOperation> getConsumeListByPOI(@PathVariable("consume_poi_id") Long id) {
        return consumeServiceImpl.findConsumeListByPOI(id);
    }

    @ApiOperation(value = "根据poi信息查询消费点列表信息，需要分页")
    @PostMapping(value = "findConsumeListByPoiId")
    public ResultMessage<ConsumeOperation> findConsumeListByPoiId(@RequestBody PagePo<ConsumeOperation> pagePo) {
        return consumeServiceImpl.findConsumeListByPoiId(pagePo);
    }


    @ApiOperation(value = "根据消费点id查询对应景区")
    @GetMapping(value = "/getPOIById/{id}")
    public ResultMessage<POIOperation> getPOIById(@PathVariable("id") Long id) throws BusinessException {
        if (null == consumeServiceImpl.getPOIById(id) || "".equals(consumeServiceImpl.getPOIById(id))) {
            throw new BusinessException("没有当前景区信息！");
        }
        return new ResultMessage(consumeServiceImpl.getPOIById(id));
    }

}
