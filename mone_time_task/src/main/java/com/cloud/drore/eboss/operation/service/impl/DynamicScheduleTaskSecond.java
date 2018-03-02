/*
package com.cloud.drore.eboss.operation.service.impl;

*/
/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/3/1 0001 下午 2:04 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 *//*


import java.util.Date;
import java.util.concurrent.ScheduledFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
@SpringBootApplication
public class DynamicScheduleTaskSecond{
    @Resource
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    private ScheduledFuture<?> future;
    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler(){
        return new ThreadPoolTaskScheduler();
    }

    private String cron = "";


    public String getCron() {
        return cron;
    }


    public void setCron(String cron) {
        this.cron = cron;
       // stopCron();
        future = threadPoolTaskScheduler.schedule(() -> {
            try {
                System.out.println("Msg:定时生成文件成功");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error:定时生成文件错误");
            }
        }, triggerContext -> {
            if ("".equals(cron) || cron == null)
                return null;
            CronTrigger trigger = new CronTrigger(cron);// 定时任务触发，可修改定时任务的执行周期
            Date nextExecDate = trigger.nextExecutionTime(triggerContext);
            return nextExecDate;
        });
    }


    public void stopCron() {
        if (future != null) {
            future.cancel(true);//取消任务调度
        }
    }
}
*/
