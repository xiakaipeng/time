package com.cloud.drore.eboss.operation.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * created by IntelliJ IDEA
 *
 * @author leihz
 * @date 2017/7/5 15:17
 */
@Data
public class TaskModel implements Serializable{


    public TaskModel() {
    }

    public TaskModel(String taskGroup, String taskName) {
        this.taskGroup = taskGroup;
        this.taskName = taskName;
    }


    /**
     * 任务名称
     */
    private String taskName;
    /**
     * 任务名称
     */
    private String taskAliasName;
    /**
     * 任务分组
     */
    private String taskGroup;
    /**
     * 任务状态 0禁用 1启用 2删除
     */
    private String taskStatus;
    /**
     * 任务运行时间表达式
     */
    private String taskCron;
    /**
     * 最后一次执行时间
     */
    private Date previousFireTime;
    /**
     * 下次执行时间
     */
    private Date nextFireTime;
    /**
     * 任务执行时间类型
     */
    private String dateType;
    /**
     * 任务描述
     */
    private String taskDesc;
    // 任务类型(是否阻塞)
    private String jobType;
    // 本地任务/dubbo任务
    private String taskType;
    // 运行系统(dubbo任务必须)
    private String targetSystem;
    // 任务对象
    private String taskTarget;
    // 任务方法
    private String taskMethod;
    // jobClass
    private String jobClass;


    /**************************************/
    private String id;
    private Object targetObject;
    private String optConfig;
    private String dataSql;
}
