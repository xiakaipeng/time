package com.cloud.drore.eboss.operation.service.impl;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;

import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/3/2 0002 上午 9:36 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Component
public class ScheduleApplication {

  ThreadPoolTaskScheduler threadPoolTaskScheduler =new ThreadPoolTaskScheduler();

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler(){
        return new ThreadPoolTaskScheduler();
    }
    private ScheduledFuture<?> future;

    ///方法一
    public String startCron(){
        threadPoolTaskScheduler.initialize();
        System.out.println("x0");
        //threadPoolTaskScheduler.shutdown();
        future = threadPoolTaskScheduler.schedule(new Say(), new CronTrigger("*/5 * * * * *"));
        System.out.println("x1");
        return "x";
    }



    public String stopCron(){
        System.out.println("stop >>>>>");
        if(future != null) {
            future.cancel(true);
        }
        //future = threadPoolTaskScheduler.schedule(new Say(), new CronTrigger("*/5 * * * * *"));
        System.out.println("stop <<<<<");
        return "stop cron";
    }


    public String startCron10(){
        System.out.println("x100");
        future = threadPoolTaskScheduler.schedule(new Say(), new CronTrigger("*/12 * * * * *"));
        System.out.println("x101");
        return "x10";
    }


    ///方法二

    private String cronStr = "*/5 * * * * *";

    public String startCron1(String str){
        System.out.println("startCron1 >>>>");
        threadPoolTaskScheduler.initialize();
        threadPoolTaskScheduler.schedule(new Say(), triggerContext -> new CronTrigger(str).nextExecutionTime(triggerContext));
        System.out.println("startCron1 <<<<");
        return "cronStr";
    }



    public String changeCronStr(){
        cronStr = "*/12 * * * * *";
        System.out.println("change "  + cronStr);
        return  cronStr;
    }


    public String changeCronStr5(){
        cronStr = "*/5 * * * * *";
        System.out.println("change "  + cronStr);
        return  cronStr;
    }


    public static void main(String[] args) {
        SpringApplication.run(ScheduleApplication.class, args);
    }

}
