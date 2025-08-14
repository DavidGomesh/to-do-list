package com.petize.todolist.api.dtos.request;

import jakarta.validation.constraints.NotBlank;

public record UserRequest(
    @NotBlank
    String username,

    @NotBlank
    String password
) {}
