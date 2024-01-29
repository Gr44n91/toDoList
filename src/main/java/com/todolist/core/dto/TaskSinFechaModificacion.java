package com.todolist.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskSinFechaModificacion extends TaskAbstract{

    //validar not null
    private Long id;
    private String descripcion;
    //validar con codigo min 1 y max 4
    private Integer status;
    private LocalDate fechaCreacion;

}
