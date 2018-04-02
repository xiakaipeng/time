package com.cloud.drore.eboss.operation.mapper;


import com.cloud.drore.eboos.common.base.MyMapper;
import com.cloud.drore.eboss.operation.entity.POIOperation;
import com.cloud.drore.eboss.operation.entity.TaskModel;
import com.cloud.drore.eboss.operation.mapper.provider.TaskProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.HashMap;
import java.util.List;

/**
 * TaskMapper
 *
 * @author leihz
 * @date 2017/7/5 17:18
 */
@Mapper
public interface TaskMapper extends MyMapper<POIOperation> {
     //查询状态正常的定时任务 task_status=1
     @Select("SELECT * FROM nc_task WHERE task_status = '1'")
     List<TaskModel> getTaskList();
     //查询满足条件的定时任务
     @SelectProvider(type = TaskProvider.class, method = "getTaskListByParam")
     List<TaskModel> getTaskListByParam(TaskModel taskModel);
}
