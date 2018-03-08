package com.cloud.drore.eboss.operation.controller;

import com.cloud.drore.eboos.common.base.PagePo;
import com.cloud.drore.eboos.common.base.ResultMessage;

import com.cloud.drore.eboss.operation.entity.Demo;
import com.cloud.drore.eboss.operation.service.IFeignDemo;
import com.cloud.drore.eboss.operation.service.impl.DemoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.sql.ResultSet;

/**
 * 浙江卓锐科技股份有限公司 版权所有 © Copyright 2018<br>
 * @Description: demo<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2017/12/29 11:23 <br>
 * @Author: <a href="836327318@qq.com">吴昌益</a>
 */
@RestController
@RequestMapping("/demo")
@Api(value = "/测试接口", description = "测试接口-吴昌益fffff")
public class DemoController {

    @Resource
    DemoServiceImpl demoService;

    @Resource
    IFeignDemo iFeignDemo;

    /**
     * @ClassName: DemoController
     * @Return: java.sql.ResultSet
     * @param resultSet
     * @Decription:
     * @CreateDate: Created in 2017/12/29 11:58
     * @Author: <a href="836327318@qq.com">吴昌益</a>
     */
    public ResultSet get(ResultSet resultSet){

        return null;
                
    }

    @ApiOperation(value = "保存信息")
    @PostMapping(value = "/save")
    public ResultMessage<Demo> save(@RequestBody @Validated({Demo.SAVE.class})  Demo demo){
        return new ResultMessage(demoService.insert(demo));
    }

    @ApiOperation(value = "更新信息")
    @PutMapping(value = "/update")
    public ResultMessage<Demo> update(@RequestBody @Valid Demo demo){
        return new ResultMessage(demoService.updateByPrimaryKey(demo));
    }

    @ApiOperation(value = "删除信息")
    @DeleteMapping(value = "/delete/{id}")
    public ResultMessage<Demo> delete(@PathVariable("id") Long id){
        return new ResultMessage(demoService.deleteByPrimaryKey(id));
    }

    @ApiOperation(value = "通过id获取信息")
    @GetMapping(value = "/{id}")
    public ResultMessage<Demo> get(@PathVariable("id") Long id){
        ResultMessage resultMessage =new ResultMessage();
        resultMessage.setId(iFeignDemo.getDemo(id)+"");
        return resultMessage;
    }

    @ApiOperation(value = "查询信息")
    @PostMapping(value = "find")
    public ResultMessage find(@RequestBody PagePo<Demo> pagePo){
        Demo demo = pagePo.getFields();
            return demoService.findByParms(demo,pagePo);
    }

}
