package com.todolist.core.services;

import com.todolist.core.dao.entities.TaskEntity;
import com.todolist.core.dto.Task;
import com.todolist.core.dto.TaskAbstract;
import com.todolist.core.dto.TaskSinFechaModificacion;

import java.util.List;

public interface TaskService {

    //En esta interfaz declaramos los metodos de la implementacion
    //pero no los implementamos o desarrollamos

    List<?> getTasks();
    TaskSinFechaModificacion saveTask(TaskSinFechaModificacion task);
    TaskAbstract getTaskById(Long id);
    Task updateTask(Task task);

    void deleteTaskById(Long id);
}
