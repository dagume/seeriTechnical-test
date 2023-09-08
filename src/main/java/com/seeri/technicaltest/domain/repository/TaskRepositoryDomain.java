package com.seeri.technicaltest.domain.repository;

import com.seeri.technicaltest.domain.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepositoryDomain {
    List<Task> getAll();
    Optional<Task> getTask(int id);
    Task save(Task task);
    void delete(int id);
}
