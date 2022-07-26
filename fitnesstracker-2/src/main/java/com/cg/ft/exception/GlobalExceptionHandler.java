package com.cg.ft.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(Exception e) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @ExceptionHandler(value = AdminNotFoundException.class)
    public ResponseEntity<String> handleAdminNotFoundException(Exception e) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @ExceptionHandler(value = AuthenticationFailedException.class)
    public ResponseEntity<String> handleAuthenticationFailedException(Exception e) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.UNAUTHORIZED);
        return responseEntity;
    }

    @ExceptionHandler(value = UserAlreadyExistsException.class)
    public ResponseEntity<String> handleUserAlreadyExists(Exception e) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.FOUND);
        return responseEntity;
    }

    @ExceptionHandler(value = AdminAlreadyExistsException.class)
    public ResponseEntity<String> handleAdminAlreadyExists(Exception e) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.FOUND);
        return responseEntity;
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
//      body.put("timestamp", new Date());
        body.put("status", status.value());

        // Get all errors
        List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());
        body.put("errors", errors);
        return new ResponseEntity<>(body, headers, status);
    }
}