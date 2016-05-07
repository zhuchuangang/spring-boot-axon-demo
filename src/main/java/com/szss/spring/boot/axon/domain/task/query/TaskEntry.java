package com.szss.spring.boot.axon.domain.task.query;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * Created by zcg on 16/5/7.
 */
@Data
public class TaskEntry{
    @Id
    private String id;

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
     * 运行状态
     */
//    @Transient
//    private Trigger.TriggerState state;
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
     * 参数类型
     */
    private String paramType;

    /**
     * 任务参数说明
     */
    private String paramDescription;

}
