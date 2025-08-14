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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Tasks", description = "Endpoints for managing tasks.")
@RequestMapping("v1/tasks")
public interface TaskController {

    @Operation(summary = "Creates a new task", description = "Persists a new task with the provided data.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Task created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request data")
    })
    @PostMapping
    ResponseEntity<Void> save(@Valid @RequestBody TaskRequest dto);



    @Operation(summary = "Retrieves all tasks of the logged user", description = "Returns a paginated list of tasks, with optional filters.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved tasks")
    })
    @GetMapping
    ResponseEntity<Page<TaskResponse>> getAll(
        @Parameter(description = "Due date for filtering tasks (format YYYY-MM-DD)", example = "2025-12-31")
        @RequestParam(name = "due-date", required = false) LocalDate dueDate,

        @Parameter(description = "Task status for filtering")
        @RequestParam(required = false) TaskStatus status,

        @Parameter(description = "Task priority for filtering")
        @RequestParam(required = false) Priority priority,

        @Parameter(hidden = true)
        Pageable pageable
    );



    @Operation(summary = "Retrieves a task by ID", description = "Returns a single task if the ID exists.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved task"),
        @ApiResponse(responseCode = "404", description = "Task not found")
    })
    @GetMapping("{id}")
    ResponseEntity<TaskResponse> getById(
        @Parameter(description = "ID of the task to retrieve")
        @PathVariable Integer id
    );



    @Operation(summary = "Updates the status of a task", description = "Modifies the status of a specific task.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Task status updated successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid status provided"),
        @ApiResponse(responseCode = "404", description = "Task not found")
    })
    @PatchMapping("{id}/status/{status}")
    ResponseEntity<Void> updateStatus(
        @Parameter(description = "ID of the task to update")
        @PathVariable Integer id,

        @Parameter(description = "New status for the task")
        @PathVariable TaskStatus status
    );



    @Operation(summary = "Deletes a task by ID", description = "Removes a task from the system.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Task deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Task not found")
    })
    @DeleteMapping("{id}")
    ResponseEntity<Void> delete(
        @Parameter(description = "ID of the task to delete")
        @PathVariable Integer id
    );

}
