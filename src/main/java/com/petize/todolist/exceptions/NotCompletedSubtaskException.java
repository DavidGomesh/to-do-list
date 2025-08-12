package com.petize.todolist.exceptions;

import java.util.UUID;

public class NotCompletedSubtaskException extends RuntimeException {
    
    public NotCompletedSubtaskException(UUID id) {
        super("Task '" + id + "' cannot be completed because it has incomplete subtasks");
    }
}
