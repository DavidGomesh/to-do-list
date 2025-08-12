package com.petize.todolist.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.petize.todolist.domain.models.Task;
import com.petize.todolist.domain.repositories.TaskRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskService {
    
    private final TaskRepository taskRepository;
    
    public Task save(@Valid Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAll() {
        return taskRepository.findAll();
    }
}
