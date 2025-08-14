package com.petize.todolist.api.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petize.todolist.api.dtos.request.UserRequest;
import com.petize.todolist.api.dtos.response.UserResponse;

import jakarta.validation.Valid;

@RequestMapping("v1/users")
public interface UserController {

    @PostMapping
    ResponseEntity<Void> save(@Valid @RequestBody UserRequest dto);

    @GetMapping
    ResponseEntity<List<UserResponse>> getAll();

    @GetMapping("{id}")
    ResponseEntity<UserResponse> getById(@PathVariable UUID id);
        
}
