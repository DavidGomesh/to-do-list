package com.petize.todolist.api.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petize.todolist.api.dtos.request.UserRequest;
import com.petize.todolist.api.dtos.response.UserResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Users", description = "Endpoints for managing users.")
@RequestMapping("v1/users")
public interface UserController {

    @Operation(summary = "Creates a new user", description = "Persists a new user with the provided data.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "User created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request data")
    })
    @PostMapping
    ResponseEntity<Void> save(@Valid @RequestBody UserRequest dto);



    @Operation(summary = "Retrieves all users", description = "Returns a list of all registered users.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved users")
    })
    @GetMapping
    ResponseEntity<List<UserResponse>> getAll();



    @Operation(summary = "Retrieves a user by ID", description = "Returns a single user if the ID exists.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved user"),
        @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping("{id}")
    ResponseEntity<UserResponse> getById(
        @Parameter(description = "ID of the user to retrieve")
        @PathVariable Integer id
    );
}
