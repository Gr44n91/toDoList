package com.todolist.core.controllers;


import com.todolist.core.dto.Task;
import com.todolist.core.dto.TaskAbstract;
import com.todolist.core.dto.TaskSinFechaModificacion;
import com.todolist.core.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<?>> getTasks() {
        return ResponseEntity.ok(taskService.getTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskAbstract> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @PostMapping
    public ResponseEntity<TaskSinFechaModificacion> saveTask(@Valid @RequestBody TaskSinFechaModificacion task) {
        return ResponseEntity.ok(taskService.saveTask(task));
    }

    @PutMapping
    public ResponseEntity<Task> updateTask(@Valid @RequestBody Task task) {
        return ResponseEntity.ok(taskService.updateTask(task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTaskById(@PathVariable Long id) {
        taskService.deleteTaskById(id);
        return ResponseEntity.noContent().build();
    }
}
