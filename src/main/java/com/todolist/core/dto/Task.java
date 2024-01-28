package com.todolist.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task extends TaskAbstract{

    private Long id;
    private String descripcion;
    private Integer status;
    private LocalDate fechaCreacion;
    private LocalDate fechaModificacion;
}
