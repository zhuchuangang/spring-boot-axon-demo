package com.szss.spring.boot.axon.domain.task;

import com.szss.spring.boot.axon.PropertyUtilsEx;
import com.szss.spring.boot.axon.domain.task.commands.CreateTaskCommand;
import com.szss.spring.boot.axon.domain.task.commands.UpdateTaskCommand;
import com.szss.spring.boot.axon.domain.task.events.TaskCreatedEvent;
import com.szss.spring.boot.axon.domain.task.events.TaskUpdatedEvent;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;

/**
 * Created by zcg on 16/5/7.
 */
public class Task extends AbstractAnnotatedAggregateRoot<TaskId> {
    /**
     * 任务聚合的ID
     */
    @AggregateIdentifier
    private TaskId taskId;

    /**
     * 任务名称
     */
    private String taskName;
    /**
     * 任务分组
     */
    private String taskGroup;
    /**
     * 任务状态 是否启动任务  0为不启用  1为启用
     */
    private Boolean taskStatus;
    /**
     * cron表达式
     */
    private String cronExpression;
    /**
     * 描述
     */
    private String description;
    /**
     * 任务执行时调用哪个类的方法 包名+类名
     */
    private String beanClass;
    /**
     * 任务是否有状态
     */
    private Boolean isConcurrent;
    /**
     * spring bean
     */
    private String springId;
    /**
     * 任务调用的方法名
     */
    private String methodName;

    /**
     * 任务相关参数
     */
    private String param;

    /**
     * 任务参数说明
     */
    private String paramDescription;

    public Task() {
    }

    public Task(CreateTaskCommand command){
        TaskCreatedEvent event = new TaskCreatedEvent();
        PropertyUtilsEx.copyProperties(event, command);
        apply(event);
    }

    public void editTask(UpdateTaskCommand command){
        TaskUpdatedEvent event=new TaskUpdatedEvent();
        PropertyUtilsEx.copyProperties(event, command);
        apply(event);
    }

    @EventSourcingHandler
    public void on(TaskCreatedEvent event){
        this.taskId=event.getTaskId();
        this.taskName=event.getTaskName();
        this.taskGroup=event.getTaskGroup();
        this.taskStatus=event.getTaskStatus();
        this.cronExpression=event.getCronExpression();
        this.description=event.getDescription();
        this.beanClass=event.getBeanClass();
        this.isConcurrent=event.getIsConcurrent();
        this.springId=event.getSpringId();
        this.methodName=event.getMethodName();
        this.param=event.getParam();
        this.paramDescription=event.getParamDescription();
    }

    @EventSourcingHandler
    private void on(TaskUpdatedEvent event) {
        this.taskName = event.getTaskName();
        this.taskGroup = event.getTaskGroup();
        this.taskStatus = event.getTaskStatus();
        this.cronExpression = event.getCronExpression();
        this.description = event.getDescription();
        this.beanClass = event.getBeanClass();
        this.isConcurrent = event.getIsConcurrent();
        this.springId = event.getSpringId();
        this.methodName = event.getMethodName();
        this.param = event.getParam();
        this.paramDescription = event.getParamDescription();
    }
}
