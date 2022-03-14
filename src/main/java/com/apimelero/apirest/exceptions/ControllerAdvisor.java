package com.apimelero.apirest.exceptions;


import com.apimelero.apirest.model.MachineEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<MachineEntity> handleNotFoundException(NotFoundException ex, WebRequest request) {
        System.out.println("Running Exception Handler");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductionLineNotExistingException.class)
    public ResponseEntity<MachineEntity> ProductionLineNotExistingException(ProductionLineNotExistingException ex, WebRequest request) {
        System.out.println("Running Exception Handler");
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}