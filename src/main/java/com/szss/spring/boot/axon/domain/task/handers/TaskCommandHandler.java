package com.szss.spring.boot.axon.domain.task.handers;

import com.szss.spring.boot.axon.domain.task.Task;
import com.szss.spring.boot.axon.domain.task.commands.CreateTaskCommand;
import com.szss.spring.boot.axon.domain.task.commands.UpdateTaskCommand;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zcg on 15/12/22.
 */
@Component
public class TaskCommandHandler {

    @Autowired
    private Repository<Task> taskRepository;

    @CommandHandler
    public void createTaskCommandHandler(CreateTaskCommand command) {
        Task task = new Task(command);
        taskRepository.add(task);
    }

    @CommandHandler
    public void updateTaskCommandHandler(UpdateTaskCommand command){
        Task task=taskRepository.load(command.getTaskId().getIdentifier());
        task.editTask(command);
    }
}
