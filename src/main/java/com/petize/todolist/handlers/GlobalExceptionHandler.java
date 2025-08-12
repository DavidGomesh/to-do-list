package com.petize.todolist.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.petize.todolist.exceptions.EntityNotFoundException;
import com.petize.todolist.exceptions.NotCompletedSubtaskException;
import com.petize.todolist.handlers.errors.Error;
import com.petize.todolist.handlers.errors.ValidationError;
import com.petize.todolist.handlers.errors.ValidationError.InvalidField;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // (400) Bad Request
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Error handle(MethodArgumentNotValidException ex) {
        return new ValidationError((ex
            .getBindingResult().getFieldErrors()
            .stream().map(this::toInvalidField)
            .toList()
        ));
    }

    private InvalidField toInvalidField(FieldError error) {
        return new ValidationError.InvalidField(
            error.getField(), error.getDefaultMessage()
        );
    }

    // (404) Not Found
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EntityNotFoundException.class)
    public Error handle(EntityNotFoundException ex) {
        return Error.notFound(ex.getMessage());
    }

    // (409) Conflict
    @ResponseStatus(code = HttpStatus.CONFLICT)
    @ExceptionHandler(NotCompletedSubtaskException.class)
    public Error handle(NotCompletedSubtaskException ex) {
        return Error.conflict(ex.getMessage());
    }
    
    // (500) Internal Server Error
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public Error handle(RuntimeException ex) {
        return Error.internalServerError(ex.getMessage());
    }
}
