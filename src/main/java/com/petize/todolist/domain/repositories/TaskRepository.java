package com.petize.todolist.domain.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petize.todolist.domain.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
    
}
