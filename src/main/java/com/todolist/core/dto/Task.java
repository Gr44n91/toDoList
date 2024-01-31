package com.todolist.core.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task extends TaskAbstract{

    //Validar not null
    @Positive
    @NotNull(message = "El Id es obligatorio")
    private Long id;
    private String descripcion;
    @NotNull(message = "El codigo de estado no puede estar vacio")
    @Min(value = 1, message="El codigo de estado debe ser 1,2,3 o 4")
    @Max(value = 4, message="El codigo de estado debe ser 1,2,3 o 4")
    private Integer status;
    @Null
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDate fechaCreacion;
    @Null
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDate fechaModificacion;
}
