package com.szss.spring.boot.axon.domain.task.handers;

import com.szss.spring.boot.axon.PropertyUtilsEx;
import com.szss.spring.boot.axon.domain.task.events.TaskCreatedEvent;
import com.szss.spring.boot.axon.domain.task.events.TaskUpdatedEvent;
import com.szss.spring.boot.axon.domain.task.query.TaskEntry;
import com.szss.spring.boot.axon.domain.task.query.TaskQueryRepository;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskEventHandler {
    @Autowired
    private TaskQueryRepository taskQueryRepository;

    @EventHandler
    public void on(TaskCreatedEvent event) {
        TaskEntry task = new TaskEntry();
        task.setId(event.getTaskId().getIdentifier());
        PropertyUtilsEx.copyProperties(task, event);
        taskQueryRepository.save(task);
    }

    @EventHandler
    public void on(TaskUpdatedEvent event) {
        TaskEntry task = taskQueryRepository.findById(event.getTaskId().getIdentifier());
        PropertyUtilsEx.copyProperties(task, event);
        taskQueryRepository.save(task);
    }
}
