package com.todolist.core.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IdNotFoundException extends RuntimeException{

    public static final String MESSAGE_ERROR = "El id enviado no existe en la tabla %s";

    public IdNotFoundException(String tableName){
        super(String.format(MESSAGE_ERROR, tableName));
        log.info("El id enviado no existe en la tabla " + tableName);
    }
}
