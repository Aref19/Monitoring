package com.example.user_service.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResponseHandler {


    @ExceptionHandler(BadRequestError.class)
    public ResponseEntity<String> handleBadRequest(BadRequestError e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<String> handleBadRequest(MissingServletRequestParameterException e) {
        if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fehler 400 " + e.getMessage());
        }
        return ResponseEntity.badRequest().body(e.getMessage());
    }


}
