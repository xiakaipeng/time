package com.cloud.drore.eboss;

import com.cloud.drore.eboos.common.util.JedisPoll;
import com.cloud.drore.eboos.common.util.RedisKeysClockUtil;
import com.cloud.drore.eboss.operation.entity.TaskModel;
import com.cloud.drore.eboss.operation.service.impl.TaskService;
import com.cloud.drore.eboss.operation.service.quartz.plan.SchedulerManager;

import com.cloud.drore.eboss.operation.util.SpringContextUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.klock.KlockAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import java.util.List;

/**
 * @Author: wcy
 * @Description:
 * @Date: Created in 2017/12/27 13:40
 * @Modified By:
 */
@MapperScan(basePackages = {"com.cloud.drore.eboss.operation.mapper", "com.cloud.drore.eboss.supplier.mapper"})
@SpringBootApplication
@ServletComponentScan
@EnableDiscoveryClient
@EnableFeignClients
@EnableScheduling
@Import({JedisPoll.class, RedisKeysClockUtil.class, KlockAutoConfiguration.class})
public class EbossOperationApplication {

    public static void main(String[] args) throws Exception {
        ApplicationContext app = SpringApplication.run(EbossOperationApplication.class, args);
        /**将spring上下文set到SpringContextUtil中*/
        SpringContextUtil.setApplicationContext(app);

        SchedulerManager schedulerManager = (SchedulerManager) app.getBean("schedulerManager");
        TaskService taskService = (TaskService) app.getBean("taskService");
        TaskModel taskModel = new TaskModel();
        taskModel.setTaskStatus("1");
        List<TaskModel> taskList = taskService.getTaskListByParam(taskModel);
        for (TaskModel task : taskList) {
            System.out.println("数据库中设定的定时任务有：" + taskList);
            schedulerManager.createOrUpdateTask(task);
        }

    }
}