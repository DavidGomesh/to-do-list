package com.petize.todolist.exceptions;

public class NotCompletedSubtaskException extends RuntimeException {
    
    public NotCompletedSubtaskException(Integer id) {
        super("Task '" + id + "' cannot be completed because it has incomplete subtasks");
    }
}
