package com.seeri.technicaltest.persistance;

import com.seeri.technicaltest.domain.Task;
import com.seeri.technicaltest.domain.repository.TaskRepositoryDomain;
import com.seeri.technicaltest.persistance.crud.TaskCrudRepository;
import com.seeri.technicaltest.persistance.entity.TaskEntity;
import com.seeri.technicaltest.persistance.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TaskRepository implements TaskRepositoryDomain {

    @Autowired
    private TaskCrudRepository taskCrudRepository;

    @Autowired
    private TaskMapper mapper;

    @Override
    public List<Task> getAll(){
        List<TaskEntity> tasks = (List<TaskEntity>) taskCrudRepository.findAll();
        return mapper.toTasks(tasks);
    }

    @Override
    public Optional<Task> getTask(int id){
        return taskCrudRepository.findById(id).map(task -> mapper.toTask(task));
    }

    @Override
    public Task save(Task task) {
        TaskEntity taskEntity = mapper.toTaskEntity(task);
        return mapper.toTask(taskCrudRepository.save(taskEntity));
    }

    @Override
    public void delete (int id){
        taskCrudRepository.deleteById(id);
    }
}

