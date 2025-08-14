package com.petize.todolist.api.controllers.impl;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.petize.todolist.api.controllers.TaskController;
import com.petize.todolist.api.dtos.assemblers.TaskAssembler;
import com.petize.todolist.api.dtos.mappers.TaskMapper;
import com.petize.todolist.api.dtos.request.TaskRequest;
import com.petize.todolist.api.dtos.response.TaskResponse;
import com.petize.todolist.domain.models.enums.Priority;
import com.petize.todolist.domain.models.enums.TaskStatus;
import com.petize.todolist.domain.services.TaskService;
import com.petize.todolist.domain.services.auth.AuthenticationService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class TaskControllerImpl implements TaskController {

    private final TaskAssembler taskAssembler;
    private final TaskMapper taskMapper;
    private final TaskService taskService;
    private final AuthenticationService authenticationService;

    @Override
    public ResponseEntity<Void> save(@Valid TaskRequest dto) {
        var task = taskAssembler.toEntity(dto);
        var user = authenticationService.getUserAuthenticated().getUser();

        taskService.associate(task, user);
        taskService.save(task);

        return ResponseEntity.created(ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(task.getId())
            .toUri()
        ).build();
    }

    @Override
    public ResponseEntity<Page<TaskResponse>> getAll(
        LocalDate dueDate, TaskStatus status, Priority priority, Pageable pageable) {

        var user = authenticationService.getUserAuthenticated().getUser();
        System.out.println("RESULTADOS");
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(taskService
            .getAllWithFilters(user, dueDate, status, priority, pageable)
            .map(taskMapper::toResponse));
        return ResponseEntity.ok(taskService
            .getAllWithFilters(user, dueDate, status, priority, pageable)
            .map(taskMapper::toResponse)
        );
    }

    @Override
    public ResponseEntity<TaskResponse> getById(Integer id) {
        return ResponseEntity.ok(taskMapper.toResponse(
            taskService.getById(id)
        ));
    }

    @Override
    public ResponseEntity<Void> updateStatus(Integer id, TaskStatus status) {
        taskService.updateStatus(taskService.getById(id), status);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        taskService.delete(taskService.getById(id));
        return ResponseEntity.noContent().build();
    }
    
}
