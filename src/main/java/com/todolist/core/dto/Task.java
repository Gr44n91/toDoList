package com.todolist.core.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
    private LocalDate fechaCreacion;
    private LocalDate fechaModificacion;
}
