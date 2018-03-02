package com.cloud.drore.eboss.operation.mapper.provider;

import com.cloud.drore.eboss.operation.entity.Demo;


public class DemoProvider {

    public DemoProvider(){
    }

    public String isContain(Demo parms){
        String sql = "select * from demo";
        return sql;
    }
}
