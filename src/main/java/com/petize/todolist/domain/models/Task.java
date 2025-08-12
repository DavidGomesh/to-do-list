package com.petize.todolist.domain.models;

import static com.petize.todolist.domain.models.enums.TaskStatus.PENDING;

import java.time.LocalDate;
import java.util.UUID;

import com.petize.todolist.domain.models.enums.Priority;
import com.petize.todolist.domain.models.enums.TaskStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Max(100)
    @NotBlank
    private String title;
    
    @Max(500)
    @NotBlank
    private String description;

    @Future
    @NotNull
    private LocalDate dueDate;
    
    @NotNull
    private TaskStatus status = PENDING;

    @NotNull
    private Priority priority;
}
