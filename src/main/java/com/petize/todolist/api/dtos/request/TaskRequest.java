package com.petize.todolist.api.dtos.request;

import java.time.LocalDate;
import java.util.List;

import com.petize.todolist.domain.models.enums.Priority;
import com.petize.todolist.domain.models.enums.TaskStatus;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TaskRequest (

    @Max(100)
    @NotBlank
    String title,

    @Max(500)
    @NotBlank
    String description,

    @Future
    @NotNull
    LocalDate dueDate,

    @NotNull
    TaskStatus status,

    @NotNull
    Priority priority,

    @NotNull
    List<TaskRequest> subTasks
) {}
