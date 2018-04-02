package com.cloud.drore.eboss.operation.service.impl;


import com.cloud.drore.eboss.operation.entity.TaskModel;
import com.cloud.drore.eboss.operation.mapper.TaskMapper;
import com.cloud.drore.eboss.operation.service.quartz.plan.SchedulerManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * TaskService
 *
 * @author leihz
 * @date 2017/7/5 17:17
 */
@Service
public class TaskService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TaskMapper taskMapper;
    @Autowired
    SchedulerManager schedulerManager;


    /**
     * @param
     * @ClassName: TaskService
     * @Return: java.util.List<com.cloud.drore.eboss.operation.entity.TaskModel>
     * @Decription: 查询当前所有任务
     * @CreateDate: Created in 2018/4/2 0002 上午 11:40
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public List<TaskModel> getTaskList() {
        return taskMapper.getTaskList();
    }

    /**
     * @ClassName: TaskService
     * @param taskModel
     * @Return: java.util.List<com.cloud.drore.eboss.operation.entity.TaskModel>
     * @Decription: 查询满足条件的
     * @CreateDate: Created in 2018/4/2 0002 下午 12:01
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public List<TaskModel> getTaskListByParam(TaskModel taskModel) {

        return taskMapper.getTaskListByParam(taskModel);
    }

    public List<TaskModel> getAllJobDetail() {
        return schedulerManager.getAllJobDetail();
    }
}
