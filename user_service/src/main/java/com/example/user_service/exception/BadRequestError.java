package com.example.user_service.exception;

public class BadRequestError extends RuntimeException {

    String message;

    public BadRequestError(String message) {
        this.message = message;
    }
}
