package com.petize.todolist.api.dtos.mappers;

import org.mapstruct.Mapper;

import com.petize.todolist.api.dtos.response.TaskResponse;
import com.petize.todolist.domain.models.Task;

@Mapper
public interface TaskMapper {

    TaskResponse toResponse(Task task);
}
