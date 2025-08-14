package com.petize.todolist.api.dtos.assemblers;

import org.springframework.stereotype.Component;

import com.petize.todolist.api.dtos.mappers.TaskMapper;
import com.petize.todolist.api.dtos.request.TaskRequest;
import com.petize.todolist.domain.models.Task;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TaskAssembler {

    private final TaskMapper taskMapper;
    
    public Task toEntity(TaskRequest dto) {
        var task = taskMapper.toEntity(dto);
        setParentTask(task);
        return task;
    }

    private void setParentTask(Task task) {
        if(task.getSubTasks() != null) {
            task.getSubTasks().forEach(subTask -> {
                subTask.setParentTask(task);
                setParentTask(subTask);
            });
        }
    }
}
