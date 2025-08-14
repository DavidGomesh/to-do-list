package com.petize.todolist.api.controllers;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.petize.todolist.api.dtos.request.TaskRequest;
import com.petize.todolist.api.dtos.response.TaskResponse;
import com.petize.todolist.domain.models.enums.Priority;
import com.petize.todolist.domain.models.enums.TaskStatus;

import jakarta.validation.Valid;

@RequestMapping("v1/tasks")
public interface TaskController {

    @PostMapping
    ResponseEntity<Void> save(@Valid @RequestBody TaskRequest dto);

    @GetMapping
    ResponseEntity<Page<TaskResponse>> getAll(
        @RequestParam(name = "due-date", required = false) LocalDate dueDate,
        @RequestParam(required = false) TaskStatus status,
        @RequestParam(required = false) Priority priority,
        Pageable pageable
    );

    @GetMapping("{id}")
    ResponseEntity<TaskResponse> getById(@PathVariable Integer id);

    @PatchMapping("{id}/status/{status}")
    ResponseEntity<Void> updateStatus(@PathVariable Integer id, @PathVariable TaskStatus status);

    @DeleteMapping("{id}")
    ResponseEntity<Void> delete(@PathVariable Integer id);


}
