package com.petize.todolist.exceptions;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(Class<?> clazz, Integer id) {
        super("Entity '" + clazz.getSimpleName() + "' not found with id '" + id + "'");
    }
}
