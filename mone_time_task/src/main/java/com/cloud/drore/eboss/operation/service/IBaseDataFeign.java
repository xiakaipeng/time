package com.cloud.drore.eboss.operation.service;


import com.cloud.drore.eboos.common.base.Dictionary;
import com.cloud.drore.eboos.common.entity.base.DictionaryVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 浙江卓锐科技股份有限公司 版权所有 © Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/6 17:38 <br>
 * @Author: <a href="836327318@qq.com">吴昌益</a>
 */
@FeignClient("eboss-basedata")
public interface IBaseDataFeign {

    @GetMapping(value = "dict/getDicionaryInfoByCode/{code}")
    public Dictionary getDictionary(@PathVariable("code") String code);

    @GetMapping(value = "dict/getDicListMapByCode/{code}")
    public List<Dictionary> getDicListMapByCode(@PathVariable("code") String code);

    @GetMapping(value = "dict/getDicionaryInfoByCode/{id}")
    public Dictionary deleteDemo(@PathVariable("id") Long id);

    @GetMapping(value = "dict/getDicionaryInfoByCode/{code}")
    public DictionaryVo getDictionaryVo(@PathVariable("code") String code);

    @GetMapping(value = "dict/getDicListMapByCode/{code}")
    public List<DictionaryVo> getDicListMapByCodeVo(@PathVariable("code") String code);

}

