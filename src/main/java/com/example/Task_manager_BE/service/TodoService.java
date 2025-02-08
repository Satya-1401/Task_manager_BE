package com.example.Task_manager_BE.service;


import com.example.Task_manager_BE.exception.ResourceNotFoundException;
import com.example.Task_manager_BE.model.Todo;
import com.example.Task_manager_BE.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    public Todo addTodo(Todo todo){
        if (!todo.isEditing()) {
            todo.setEditing(false);
        }
        return todoRepository.save(todo);
    }

    public void deleteTodo(Long id){
        Todo existingTodo = todoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Todo not found with id:" + id)
        );
        todoRepository.deleteById(id);
    }

    public Todo updateTodo(Todo todo, Long id){
        Todo existingTodo = todoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Todo not found with id:" + id)
        );

        existingTodo.setTask(todo.getTask());
        existingTodo.setCompleted(todo.isCompleted());
        return todoRepository.save(existingTodo);
    }
}

