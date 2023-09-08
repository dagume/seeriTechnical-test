package com.seeri.technicaltest.domain.service;

import com.seeri.technicaltest.domain.Task;
import com.seeri.technicaltest.domain.repository.TaskRepositoryDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepositoryDomain taskRepositoryDomain;

    public List<Task> getAll(){
        return taskRepositoryDomain.getAll();
    }

    public Optional<Task> getTask(int id){
        return taskRepositoryDomain.getTask(id);
    }

    public Task save(Task task){
        return taskRepositoryDomain.save(task);
    }

    public boolean delete(int id){
        return taskRepositoryDomain.getTask(id).map(task -> {
            taskRepositoryDomain.delete(id);
            return true;
        }).orElse(false);
    }
}
