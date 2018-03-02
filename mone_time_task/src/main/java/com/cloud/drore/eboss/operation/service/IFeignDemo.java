package com.cloud.drore.eboss.operation.service;


import com.cloud.drore.eboss.operation.entity.Demo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 浙江卓锐科技股份有限公司 版权所有 © Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/6 17:38 <br>
 * @Author: <a href="836327318@qq.com">吴昌益</a>
 */
@FeignClient("eboss-operation")
public interface IFeignDemo {

    @RequestMapping(value = "demo/{id}", method = RequestMethod.GET)
    public Demo getDemo(@PathVariable("id") Long id);

    @RequestMapping(value = "demo/save", method = RequestMethod.POST)
    public String saveDemo(Demo user);

    @RequestMapping(value = "demo/delete/{id}", method = RequestMethod.GET)
    public Boolean deleteDemo(@PathVariable("id") String id);

}
