package com.cloud.drore.eboss.operation.service.impl;

import java.util.Date;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/3/2 0002 上午 9:45 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
public class Say implements Runnable {
    @Override
    public void run(){
        System.out.println("" + new Date() + " hello");
    }
}
