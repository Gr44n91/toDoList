package com.todolist.core.dto;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String descripcion;
    @NotNull(message = "El codigo de estado no puede estar vacio")
    @Min(value = 1, message="El codigo de estado debe ser 1,2,3 o 4")
    @Max(value = 4, message="El codigo de estado debe ser 1,2,3 o 4")
    //validar con codigo min 1 y max 4
    private Integer status;
    @Null
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDate fechaCreacion;

}
