package com.petize.todolist.api.controllers.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.petize.todolist.api.controllers.UserController;
import com.petize.todolist.api.dtos.mappers.UserMapper;
import com.petize.todolist.api.dtos.request.UserRequest;
import com.petize.todolist.api.dtos.response.UserResponse;
import com.petize.todolist.domain.services.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserMapper userMapper;
    private final UserService userService;

    @Override
    public ResponseEntity<Void> save(@Valid UserRequest dto) {
        var user = userMapper.toEntity(dto);
        userService.save(user);

        return ResponseEntity.created(ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(user.getId())
            .toUri()
        ).build();
    }

    @Override
    public ResponseEntity<List<UserResponse>> getAll() {
        return ResponseEntity.ok(userMapper.toResponseList(
            userService.getAll()
        ));
    }

    @Override
    public ResponseEntity<UserResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(userMapper.toResponse(
            userService.getById(id)
        ));
    }

}
