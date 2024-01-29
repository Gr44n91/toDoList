package com.todolist.core.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ErrorResponse extends BaseErrorResponse{

    private String message;

}
