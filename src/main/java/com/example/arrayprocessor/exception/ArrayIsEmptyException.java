package com.example.arrayprocessor.exception;

public class ArrayIsEmptyException extends RuntimeException {
    public ArrayIsEmptyException() {
    }

    public ArrayIsEmptyException(String message) {
        super(message);
    }
}
