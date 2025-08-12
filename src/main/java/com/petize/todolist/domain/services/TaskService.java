package com.petize.todolist.domain.services;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.petize.todolist.domain.models.Task;
import com.petize.todolist.domain.models.enums.Priority;
import com.petize.todolist.domain.models.enums.TaskStatus;
import com.petize.todolist.domain.repositories.TaskRepository;
import com.petize.todolist.exceptions.EntityNotFoundException;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskService {
    
    private final TaskRepository taskRepository;
    
    public Task save(@Valid Task task) {
        return taskRepository.save(task);
    }

    public Task getById(UUID id) {
        return taskRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException(Task.class, id)
        );
    }

    public Page<Task> getAllWithFilters(LocalDate dueDate, TaskStatus status, Priority priority, Pageable pageable) {
        return taskRepository.findAllWithFilters(dueDate, status, priority, pageable);
    }

    public void updateStatus(Task task, TaskStatus status) {
        task.setStatus(status);
        save(task);
    }

    public void delete(Task task) {
        taskRepository.delete(task);
    }
}
