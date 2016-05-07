package com.szss.spring.boot.axon.domain.task.query;


import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by zcg on 15/12/22.
 */
public interface TaskQueryRepository extends PagingAndSortingRepository<TaskEntry, String> {
    TaskEntry findById(String id);

    TaskEntry findByTaskNameAndTaskGroup(String taskName, String taskGroup);
}
