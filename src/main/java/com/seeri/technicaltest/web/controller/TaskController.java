package com.seeri.technicaltest.web.controller;

import com.seeri.technicaltest.domain.Task;
import com.seeri.technicaltest.domain.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public List<Task> getAll(){

        return taskService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Task> getTask(@PathVariable("id") int id){
        return taskService.getTask(id);
    }
    @PostMapping("/")
    public Task save(@RequestBody Task task){
        return taskService.save(task);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id){
        return taskService.delete(id);
    }
}
