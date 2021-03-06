package com.cloud.drore.eboss.operation.mapper;

import com.cloud.drore.eboos.common.base.MyMapper;
import com.cloud.drore.eboss.operation.entity.Demo;
import com.cloud.drore.eboss.operation.mapper.provider.DemoProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * 浙江卓锐科技股份有限公司 版权所有 © Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/4 12:42 <br>
 * @Author: <a href="836327318@qq.com">吴昌益</a>
 */
public interface DemoMapper extends MyMapper<Demo> {

    @SelectProvider(type = DemoProvider.class, method = "isContain")
    List<Demo> findByParms(Demo parms);
    @Select("select * from demo")
    List<Demo> query();
}
