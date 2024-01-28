package com.todolist.core.services;

import com.todolist.core.dao.entities.TaskEntity;
import com.todolist.core.dao.repositories.ITaskRepository;
import com.todolist.core.dto.Task;
import com.todolist.core.dto.TaskAbstract;
import com.todolist.core.dto.TaskSinFechaModificacion;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService{

    private final ITaskRepository taskRepository;

    public TaskServiceImpl(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<?> getTasks() {
        List<TaskEntity> tasksFromDb = taskRepository.findAll();
        List<?> tasks = tasksFromDb.stream()
                .map(t -> {
                    //Si fecha modificacion es null enviamos Task sin fecha modificacion
                        if(t.getFechaModificacion() == null) {
                            TaskSinFechaModificacion task = new TaskSinFechaModificacion(t.getId(), t.getDescripcion(), t.getStatus(),
                                    t.getFechaCreacion());
                            return task;
                     //Si tiene fecha modificacion enviamos Task con fecha modificacion
                        }else{
                            Task task = new Task(t.getId(), t.getDescripcion(), t.getStatus(),
                                    t.getFechaCreacion(), t.getFechaModificacion());
                            return task;
                        }
                        })
                        .collect(Collectors.toList());
        return tasks;
    }

    @Override
    public TaskSinFechaModificacion saveTask(TaskSinFechaModificacion task) {
        task.setFechaCreacion(LocalDate.now());
        TaskEntity taskSaved = this.taskToTaskEntity(task);
        taskRepository.save(taskSaved);
        task.setId(taskSaved.getId());
        return task;
    }

    @Override
    public TaskAbstract getTaskById(Long id) {
        TaskEntity taskFromDb = taskRepository.findById(id).orElseThrow();
        if(taskFromDb.getFechaModificacion() == null) {
            TaskSinFechaModificacion task = new TaskSinFechaModificacion(taskFromDb.getId(), taskFromDb.getDescripcion(), taskFromDb.getStatus(),
                    taskFromDb.getFechaCreacion());
            return task;
        }else{
            Task task = new Task(taskFromDb.getId(), taskFromDb.getDescripcion(), taskFromDb.getStatus(),
                    taskFromDb.getFechaCreacion(), taskFromDb.getFechaModificacion());
            return task;
        }

    }

    @Override
    public Task updateTask(Task task) {
        TaskEntity taskFromDb = taskRepository.findById(task.getId()).orElseThrow();
        taskFromDb.setDescripcion(task.getDescripcion());
        taskFromDb.setStatus(task.getStatus());
        taskFromDb.setFechaModificacion(LocalDate.now());
        taskRepository.save(taskFromDb);
        Task taskResponse = this.TaskEntityToTask(taskFromDb);
        return taskResponse;
    }

    @Override
    public void deleteTaskById(Long id) {
        TaskEntity taskFromDb = taskRepository.findById(id).orElseThrow();
        taskRepository.delete(taskFromDb);
    }

    //Mapeo Task to TaskEntity y viceversa

    private TaskEntity taskToTaskEntity(TaskSinFechaModificacion task){
        TaskEntity taskEntity = new TaskEntity();
        BeanUtils.copyProperties(task, taskEntity);
        return taskEntity;
    }

    private Task TaskEntityToTask(TaskEntity taskEntity){
        Task task = new Task();
        BeanUtils.copyProperties(taskEntity, task);
        return task;
    }
}
