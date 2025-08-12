package com.petize.todolist.api.dtos.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.petize.todolist.api.dtos.request.TaskRequest;
import com.petize.todolist.api.dtos.response.TaskResponse;
import com.petize.todolist.domain.models.Task;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "parentTask", ignore = true)
    Task toEntity(TaskRequest dto);

    TaskResponse toResponse(Task entity);
    List<TaskResponse> toResponseList(List<Task> entities);
}
