package com.petize.todolist.domain.services;

import static com.petize.todolist.domain.models.enums.TaskStatus.COMPLETED;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.petize.todolist.domain.models.Task;
import com.petize.todolist.domain.models.User;
import com.petize.todolist.domain.models.enums.Priority;
import com.petize.todolist.domain.models.enums.TaskStatus;
import com.petize.todolist.domain.repositories.TaskRepository;
import com.petize.todolist.domain.services.auth.AuthenticationService;
import com.petize.todolist.exceptions.AccessDeniedException;
import com.petize.todolist.exceptions.EntityNotFoundException;
import com.petize.todolist.exceptions.NotCompletedSubtaskException;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskService {
    
    private final AuthenticationService authenticationService;
    private final TaskRepository taskRepository;
    
    public Task save(@Valid Task task) {
        return taskRepository.save(task);
    }

    public void associate(Task task, User user) {
        task.setUser(user);
        if(task.getSubTasks() != null) {
            task.getSubTasks().forEach(
                subtask -> associate(subtask, user)
            );
        }
    }

    public Task getById(Integer id) {
        var task = taskRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException(Task.class, id)
        );

        validateTaskOwnership(task);
        return task;
    }

    public Page<Task> getAllWithFilters(LocalDate dueDate, TaskStatus status, Priority priority, Pageable pageable) {
        var user = authenticationService.getUserAuthenticated().getUser();
        return taskRepository.findAllWithFilters(user, dueDate, status, priority, pageable);
    }

    public void updateStatus(Integer id, TaskStatus status) {
        var task = getById(id);
        
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
        validateTaskOwnership(task);
        taskRepository.delete(task);
    }

    public void validateTaskOwnership(Task task) {
        var user = authenticationService.getUserAuthenticated().getUser();
        if(!task.getUser().equals(user)){
            throw new AccessDeniedException("This user is not allowed to access this task");
        }
    }
}
