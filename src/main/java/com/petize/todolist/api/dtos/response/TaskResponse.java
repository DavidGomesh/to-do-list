package com.petize.todolist.api.dtos.response;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.petize.todolist.domain.models.enums.Priority;
import com.petize.todolist.domain.models.enums.TaskStatus;

public record TaskResponse (
    UUID id,
    String title,
    String description,
    LocalDate dueDate,
    TaskStatus status,
    Priority priority,
    List<UUID> subTasks 
) {}
