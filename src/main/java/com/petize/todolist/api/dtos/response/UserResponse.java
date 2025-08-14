package com.petize.todolist.api.dtos.response;

import java.util.UUID;

public record UserResponse(
    UUID id,
    String username
) {}
