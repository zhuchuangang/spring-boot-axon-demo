package com.szss.spring.boot.axon;

import com.szss.spring.boot.axon.domain.task.Task;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventstore.mongo.DefaultMongoTemplate;
import org.axonframework.eventstore.mongo.MongoEventStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AxonConfig.class)
public class TaskConfig {
	
	@Autowired
	AxonConfig axonconf;
	
	@Bean
	public EventSourcingRepository<Task> taskRepository() {
		DefaultMongoTemplate template = new DefaultMongoTemplate(axonconf.mongo);
		MongoEventStore eventStore = new MongoEventStore(template);
		EventSourcingRepository<Task> repository = new EventSourcingRepository<Task>(Task.class, eventStore);
		repository.setEventBus(axonconf.eventBus());
		return repository;
	}
	
}
