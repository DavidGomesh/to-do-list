package com.petize.todolist.domain.models;

import static com.petize.todolist.domain.models.enums.TaskStatus.PENDING;

import java.time.LocalDate;
import java.util.List;

import com.petize.todolist.domain.models.enums.Priority;
import com.petize.todolist.domain.models.enums.TaskStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_fk")
    private User user;

    @Size(max = 100)
    @NotBlank
    private String title;
    
    @Size(max = 500)
    @NotBlank
    private String description;

    @Future
    @NotNull
    private LocalDate dueDate;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private TaskStatus status = PENDING;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @ManyToOne
    @JoinColumn(name = "parent_task_fk")
    private Task parentTask;

    @OneToMany(mappedBy = "parentTask", cascade = CascadeType.PERSIST)
    private List<Task> subTasks;
}
