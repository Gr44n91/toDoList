package com.todolist.core.controllers;


import com.todolist.core.dto.Task;
import com.todolist.core.dto.TaskAbstract;
import com.todolist.core.dto.TaskSinFechaModificacion;
import com.todolist.core.services.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Lista todas las tareas en la base de datos")
    @GetMapping
    public ResponseEntity<List<?>> getTasks() {
        return ResponseEntity.ok(taskService.getTasks());
    }

    @Operation(summary = "Busca una tarea por Id")
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "Busca una tarea por Id",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Task.class))})
    )
    @GetMapping("/{id}")
    public ResponseEntity<TaskAbstract> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @Operation(summary = "Guarda una nueva tarea")
    @PostMapping
    public ResponseEntity<TaskSinFechaModificacion> saveTask(@Valid @RequestBody TaskSinFechaModificacion task) {
        return ResponseEntity.ok(taskService.saveTask(task));
    }

    @Operation(summary = "Actualiza una tarea existente por id")
    @PutMapping
    public ResponseEntity<Task> updateTask(@Valid @RequestBody Task task) {
        return ResponseEntity.ok(taskService.updateTask(task));
    }

    @Operation(summary = "Elimina una tarea existente por id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTaskById(@PathVariable Long id) {
        taskService.deleteTaskById(id);
        return ResponseEntity.noContent().build();
    }
}
