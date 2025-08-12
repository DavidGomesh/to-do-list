package com.petize.todolist.api.dtos.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.petize.todolist.api.dtos.request.TaskRequest;
import com.petize.todolist.domain.models.enums.Priority;
import com.petize.todolist.domain.models.enums.TaskStatus;

@SpringBootTest
public class TaskMapperTest {
    
    @Autowired
    private TaskMapper taskMapper;

    @Test
    void mustCreateTaskAndSubTasks() {

        var taskRequest = new TaskRequest("Task 01",  "Description 01", LocalDate.now().plusDays(4), TaskStatus.PENDING, Priority.LOW, Arrays.asList(
            new TaskRequest("SubTask 01",  "Description 01", LocalDate.now().plusDays(1), TaskStatus.PENDING, Priority.LOW, Arrays.asList()),
            new TaskRequest("SubTask 02",  "Description 02", LocalDate.now().plusDays(2), TaskStatus.PENDING, Priority.LOW, Arrays.asList()),
            new TaskRequest("SubTask 03",  "Description 03", LocalDate.now().plusDays(3), TaskStatus.PENDING, Priority.LOW, Arrays.asList())
        ));

        var task = taskMapper.toEntity(taskRequest);

        assertNotNull(task);

        assertNotNull(task.getSubTasks());
        assertEquals(task.getSubTasks().size(), 3);
        
        assertNotNull(task.getSubTasks().get(0));
        assertNotNull(task.getSubTasks().get(1));
        assertNotNull(task.getSubTasks().get(2));
    }
}
