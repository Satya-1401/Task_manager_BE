package com.example.Task_manager_BE.repository;

import com.example.Task_manager_BE.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
