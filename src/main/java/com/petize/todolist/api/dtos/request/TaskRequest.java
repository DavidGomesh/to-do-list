package com.petize.todolist.api.dtos.request;

import java.time.LocalDate;
import java.util.List;

import com.petize.todolist.domain.models.enums.Priority;
import com.petize.todolist.domain.models.enums.TaskStatus;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TaskRequest (

    @Size(max = 100)
    @NotBlank
    String title,

    @Size(max = 500)
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
