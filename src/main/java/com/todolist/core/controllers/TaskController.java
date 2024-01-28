package com.todolist.core.controllers;

import com.todolist.core.dao.entities.TaskEntity;
import com.todolist.core.dto.Task;
import com.todolist.core.dto.TaskAbstract;
import com.todolist.core.dto.TaskSinFechaModificacion;
import com.todolist.core.services.TaskService;
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
    public List<?> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping("/{id}")
    public TaskAbstract getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping
    public TaskSinFechaModificacion saveTask(@RequestBody TaskSinFechaModificacion task) {
        return taskService.saveTask(task);
    }

    @PutMapping
    public Task updateTask(@RequestBody Task task) {
        return taskService.updateTask(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTaskById(@PathVariable Long id) {
        taskService.deleteTaskById(id);
        return ResponseEntity.noContent().build();
    }
}
