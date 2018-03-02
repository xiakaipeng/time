package com.cloud.drore.eboos.common.util;

import com.cloud.drore.eboos.common.entity.base.UserInfo;

/**
 * 浙江卓锐科技股份有限公司 版权所有 © Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/2/28 15:59 <br>
 * @Author: <a href="836327318@qq.com">吴昌益</a>
 */
public class LocalData {

    public static UserInfo getCurrentUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1L);
        userInfo.setUserName("eboss");
        userInfo.setTenantId(1+"");
        userInfo.setType("dealer");
        return userInfo;
    }

}
