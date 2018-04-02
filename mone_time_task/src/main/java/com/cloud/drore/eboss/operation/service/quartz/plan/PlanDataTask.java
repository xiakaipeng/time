package com.cloud.drore.eboss.operation.service.quartz.plan;


import com.cloud.drore.eboss.operation.entity.Constans;
import com.cloud.drore.eboss.operation.entity.TaskModel;
import com.cloud.drore.eboss.operation.util.DateConvertUtil;
import org.quartz.JobDataMap;

/**
 * Created by Youjie on 2017/7/5.
 */
public class PlanDataTask {

    public void ncPlanDataTask(Object dataMap){
        TaskModel task = null;
        if (dataMap instanceof JobDataMap) {
            JobDataMap jobDataMap = (JobDataMap) dataMap;
            task = (TaskModel) jobDataMap.get(Constans.QUARTZ_TEST);
        } else if (dataMap instanceof TaskModel) {
            task = (TaskModel) dataMap;
        }
        String desc = task.getTaskDesc();

        StringBuilder sb = new StringBuilder();

        sb.append("\n\n------ -------------------------------Job start------------------------------------------------------------------------").append("\n");

        sb.append("         now i execute job is "+desc+ ",  time now is--->"+ DateConvertUtil.generateDateTime("yyyy-MM-dd HH:mm:ss")).append("\n");

        sb.append("\n\n------ -------------------------------Job end------------------------------------------------------------------------").append("\n");

        System.out.println(sb.toString());

    }

}
