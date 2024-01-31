package com.todolist.core.controllers.error_handler;

import com.todolist.core.dto.BaseErrorResponse;
import com.todolist.core.dto.ErrorResponse;
import com.todolist.core.exceptions.IdNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestController {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(IdNotFoundException.class)
    public BaseErrorResponse handleIdNotFound(IdNotFoundException exception){
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .status((HttpStatus.BAD_REQUEST.name()))
                .code(HttpStatus.BAD_REQUEST.value())
                .build();

    }
}
