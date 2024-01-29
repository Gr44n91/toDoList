package com.todolist.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task extends TaskAbstract{

    //Validar not null
    private Long id;
    private String descripcion;
    //Validar con codigo min 1 y max 4
    private Integer status;
    private LocalDate fechaCreacion;
    private LocalDate fechaModificacion;
}
