package com.apimelero.apirest.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException() {
        super("No data found");
    }
}
