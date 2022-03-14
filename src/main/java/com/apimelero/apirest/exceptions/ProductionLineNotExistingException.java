package com.apimelero.apirest.exceptions;

public class ProductionLineNotExistingException extends RuntimeException{
    public ProductionLineNotExistingException() {
        super("Production Line does not exist");
    }
}
