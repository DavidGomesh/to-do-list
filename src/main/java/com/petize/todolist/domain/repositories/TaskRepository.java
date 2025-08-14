package com.petize.todolist.domain.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.petize.todolist.domain.models.Task;
import com.petize.todolist.domain.models.User;
import com.petize.todolist.domain.models.enums.Priority;
import com.petize.todolist.domain.models.enums.TaskStatus;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Query("""
        SELECT t FROM Task t
        WHERE (
            t.user = :user
            AND :dueDate IS NULL OR t.dueDate = :dueDate
            AND :status IS NULL OR t.status = :status
            AND :priority IS NULL OR t.priority = :priority
        )
    """)
    Page<Task> findAllWithFilters(
        @Param("user") User user,
        @Param("dueDate") LocalDate dueDate,
        @Param("status") TaskStatus status,
        @Param("priority") Priority priority,
        Pageable pageable
    );
}
