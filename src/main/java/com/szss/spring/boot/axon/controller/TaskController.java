package com.szss.spring.boot.axon.controller;

import com.szss.spring.boot.axon.domain.task.TaskId;
import com.szss.spring.boot.axon.domain.task.commands.CreateTaskCommand;
import com.szss.spring.boot.axon.domain.task.commands.UpdateTaskCommand;
import com.szss.spring.boot.axon.domain.task.query.TaskEntry;
import org.apache.commons.beanutils.PropertyUtils;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zcg on 16/5/7.
 */
@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private CommandGateway gateway;

    @RequestMapping(value = "/task", method = RequestMethod.POST)
    public String addTask(@RequestBody TaskEntry task) {
        try {
            CreateTaskCommand command=new CreateTaskCommand();
            command.setTaskId(new TaskId());
            PropertyUtils.copyProperties(command,task);
            gateway.send(command);
        } catch (Exception e) {
            return "failure";
        }
        return "success";
    }

    @RequestMapping(value = "/task/{id}", method = RequestMethod.POST)
    public String addTask(@RequestBody TaskEntry task,@PathVariable("id") String id) {
        try {
            UpdateTaskCommand command=new UpdateTaskCommand();
            PropertyUtils.copyProperties(command,task);
            command.setTaskId(new TaskId(id));
            gateway.send(command);
        } catch (Exception e) {
            return "failure";
        }
        return "success";
    }
}
