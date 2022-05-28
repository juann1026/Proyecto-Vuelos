package com.example.demo.exception;

public class VueloNotFoundException extends RuntimeException {

    public VueloNotFoundException() {
        super();
    }

    public VueloNotFoundException(String message) {
        super(message);
    }

    public VueloNotFoundException(long id) {
        super("Vuelo not found: " + id);
    }
}
