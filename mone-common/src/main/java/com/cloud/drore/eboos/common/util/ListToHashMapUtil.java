package com.cloud.drore.eboos.common.util;

import com.cloud.drore.eboos.common.entity.operation.HashMapVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos list转map<string,string><br>
 * @CreateDate: Created in 2018/3/20 0020 上午 11:27 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
public class ListToHashMapUtil {
    /**
     * @param hashMapVoList
     * @ClassName: DistributorAccountServiceImpl
     * @Return: java.util.Map<java.lang.String   ,   java.lang.String>
     * @Decription: 接收list转map<string   ,   string></>
     * @CreateDate: Created in 2018/3/20 0020 上午 11:21
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public static Map<String, String> listToHashMap(List<HashMapVo> hashMapVoList) {
        Map<String, String> dHashMap = new HashMap<>();
        for (HashMapVo hashMapVo : hashMapVoList) {
            dHashMap.put(hashMapVo.getId(), hashMapVo.getName());
        }
        return dHashMap;
    }
}
