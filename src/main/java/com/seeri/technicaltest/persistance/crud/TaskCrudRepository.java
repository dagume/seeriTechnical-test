package com.seeri.technicaltest.persistance.crud;

import com.seeri.technicaltest.persistance.entity.TaskEntity;
import org.springframework.data.repository.CrudRepository;

public interface TaskCrudRepository extends CrudRepository<TaskEntity, Integer> {
}
