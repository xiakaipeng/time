package com.cloud.drore.eboss.operation.util;

import com.cloud.drore.eboos.common.entity.base.DictionaryVo;
import com.cloud.drore.eboss.operation.service.IBaseDataFeign;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 字典map工具类<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/2/28 20:18 <br>
 * @Author: <a href="747639122@qq.com">冯腾</a>
 */
public class DictionaryMapUtil {

    /**
     * @ClassName: DictionaryMapUtil
     * @param parentCode
     * @Return: java.util.Map<java.lang.String,java.lang.String>
     * @Decription:通过字典父节点code得到所有子节点code和name的map集合
     * @CreateDate: Created in 2018/2/28 20:53
     * @Author: <a href="747639122@qq.com">冯腾</a>
     * @Modify:
     */
    public static Map<String,String> getMapByParentCode(String parentCode){
        Map<String, String> dictionaryHashMap = new HashMap<>();
        IBaseDataFeign baseDataFeign = ApplicationContextUtil.getBean(IBaseDataFeign.class);
        List<DictionaryVo> dictionaryVoList = baseDataFeign.getDicListMapByCodeVo(parentCode);
        for (DictionaryVo dictionaryVo : dictionaryVoList){
            dictionaryHashMap.put(dictionaryVo.getDicCode(),dictionaryVo.getName());
        }
        return dictionaryHashMap;
    }

}
