package com.petize.todolist.exceptions;

import java.util.UUID;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(Class<?> clazz, UUID id) {
        super("Entity '" + clazz.getSimpleName() + "' not found with id '" + id + "'");
    }
}
