package com.cloud.drore.eboss.operation.mapper.provider;

import com.cloud.drore.eboss.operation.entity.TaskModel;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class TaskProvider {


    /**
     * @ClassName: TaskProvider
     * @param taskModel
     * @Return: java.lang.String
     * @Decription:  查询满足条件的定时任务
     * @CreateDate: Created in 2018/4/2 0002 下午 1:38
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public String getTaskListByParam(TaskModel taskModel) {

        StringBuffer stringBuffer = new StringBuffer("SELECT * FROM nc_task where ");
        int count = 0;
        if (!("".equals(taskModel.getTaskStatus()) || null == taskModel.getTaskStatus())) {
            if (count != 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append("task_status='" + taskModel.getTaskStatus() + "'");
            count++;
        }

        if (!("".equals(taskModel.getTaskType()) || null == taskModel.getTaskType())) {
            if (count != 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append("task_type='" + taskModel.getTaskType() + "'");
            count++;
        }

        if (!("".equals(taskModel.getTaskGroup()) || null == taskModel.getTaskGroup())) {
            if (count != 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append("task_group='" + taskModel.getTaskGroup() + "'");
            count++;
        }

        if (!("".equals(taskModel.getTaskName()) || null == taskModel.getTaskName())) {
            if (count != 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append("task_name='" + taskModel.getTaskName() + "'");
            count++;
        }

        if (!("".equals(taskModel.getId()) || null == taskModel.getId())) {
            if (count != 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append("id='" + taskModel.getId() + "'");
            count++;
        }
        if (count != 0) {
            stringBuffer.append(" and");
        }
        stringBuffer.append(" 1=1");
        log.info("查询当前满足条件的定时任务sql："+stringBuffer.toString());
        return stringBuffer.toString();
    }
}
