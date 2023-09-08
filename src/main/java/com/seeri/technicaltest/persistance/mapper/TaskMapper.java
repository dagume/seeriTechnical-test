package com.seeri.technicaltest.persistance.mapper;

import com.seeri.technicaltest.domain.Task;
import com.seeri.technicaltest.persistance.entity.TaskEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "title", target = "title"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "status", target = "status"),
    })
    Task toTask(TaskEntity taskEntity);
    List<Task> toTasks(List<TaskEntity> tasks);
    @InheritInverseConfiguration
    TaskEntity toTaskEntity(Task task);
}
