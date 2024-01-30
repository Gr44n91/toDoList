package com.todolist.core.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskSinFechaModificacion extends TaskAbstract{

    //validar not null
    @Positive
    @Null
    private Long id;
    private String descripcion;
    @NotNull(message = "El codigo de estado no puede estar vacio")
    @Min(value = 1, message="El codigo de estado debe ser 1,2,3 o 4")
    @Max(value = 4, message="El codigo de estado debe ser 1,2,3 o 4")
    //validar con codigo min 1 y max 4
    private Integer status;
    private LocalDate fechaCreacion;

}
