package com.cloud.drore.eboss.operation.service.quartz.plan;


import com.cloud.drore.eboss.operation.entity.Constans;
import com.cloud.drore.eboss.operation.entity.TaskModel;
import com.cloud.drore.eboss.operation.util.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * created by IntelliJ IDEA
 * 查看定时任务 执行情况
 *
 * @author leihz
 * @date 2017/7/6 13:51
 */
public class ExcuteTask {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SchedulerManager schedulerManager;

    public void prinltTaskExecuteDetail(Object data){
        ApplicationContext app = SpringContextUtil.getApplicationContext();
        // SchedulerManager schedulerManager = (SchedulerManager)app.getAutowireCapableBeanFactory().autowire(SchedulerManager.class,1,false);
        SchedulerManager schedulerManager = (SchedulerManager)app.getBean("schedulerManager");
        if(logger.isInfoEnabled()){
            logger.info(DataInfoFormat.printlnJobDetailFormat(schedulerManager.getAllJobDetail()));
        }
    }

    public void addTask(){
        ApplicationContext app = SpringContextUtil.getApplicationContext();
        SchedulerManager schedulerManager = (SchedulerManager)app.getBean("schedulerManager");
        TaskModel task = new TaskModel();
        task.setTaskGroup("nc_report");
        task.setTaskName("look_task"/*+ Application.TASK_COUNT*/);
        task.setTaskAliasName("alias_addTask");
        task.setTaskTarget("com.cloud.drore.eboss.operation.service.quartz.plan.ExcuteTask");
        task.setTaskMethod("prinltTaskExecuteDetail");
        task.setTaskDesc("查看所有任务信息");
        task.setTaskCron("0 15 0 * * ? *");//每分钟执行一次
        try {
            //targetObject = Class.forName(taskScheduled.getTaskTarget()).newInstance();
            schedulerManager.createOrUpdateTask(task);
            Constans.TASK_COUNT++;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception",e.getMessage());
        }
    }

    public void removeTask(){
        ApplicationContext app = SpringContextUtil.getApplicationContext();
        SchedulerManager schedulerManager = (SchedulerManager)app.getBean("schedulerManager");
        TaskModel task = new TaskModel();
        task.setTaskGroup("data-gather");
        task.setTaskName("printTask4");
        try {
            schedulerManager.getAllJobDetail();
            schedulerManager.delJob(task);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception",e.getMessage());
        }
    }


}

