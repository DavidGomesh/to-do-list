package com.petize.todolist.domain.services;

import static com.petize.todolist.domain.models.enums.TaskStatus.COMPLETED;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.petize.todolist.domain.models.Task;
import com.petize.todolist.domain.models.User;
import com.petize.todolist.domain.models.enums.Priority;
import com.petize.todolist.domain.models.enums.TaskStatus;
import com.petize.todolist.domain.repositories.TaskRepository;
import com.petize.todolist.exceptions.EntityNotFoundException;
import com.petize.todolist.exceptions.NotCompletedSubtaskException;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskService {
    
    private final TaskRepository taskRepository;
    
    public Task save(@Valid Task task) {
        return taskRepository.save(task);
    }

    public void associate(Task task, User user) {
        task.setUser(user);
        task.getSubTasks().forEach(
            subtask -> associate(subtask, user)
        );
    }

    public Task getById(UUID id) {
        return taskRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException(Task.class, id)
        );
    }

    public Page<Task> getAllWithFilters(User user, LocalDate dueDate, TaskStatus status, Priority priority, Pageable pageable) {
        return taskRepository.findAllWithFilters(user, dueDate, status, priority, pageable);
    }

    public void updateStatus(Task task, TaskStatus status) {
        
        if (status == COMPLETED && containsNotCompletedSubtasks(task)) {
            throw new NotCompletedSubtaskException(task.getId());
        }

        task.setStatus(status);
        save(task);
    }

    private boolean containsNotCompletedSubtasks(Task task) {
        return (task.getSubTasks().stream().anyMatch(
            subTask -> subTask.getStatus() != COMPLETED || containsNotCompletedSubtasks(subTask)
        ));
    }

    public void delete(Task task) {
        taskRepository.delete(task);
    }
}
