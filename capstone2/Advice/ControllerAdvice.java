package com.example.capstone2.Advice;

import com.example.capstone2.ApiResponce.ApiException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

//    //id not found
    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity ApiException(ApiException e){
        String message=e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

//    //for get and post delete put
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
        String message=e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    //for database type
    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity DataIntegrityViolationException(DataIntegrityViolationException e){
        String message=e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

//    //error in json
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity HttpMessageNotReadableException(HttpMessageNotReadableException e){
        String message=e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    //for validation
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity MethodArgumentNotValidException(MethodArgumentNotValidException e){
        String message=e.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(message);
    }

    //no endpoint with this path
    @ExceptionHandler(value = NoResourceFoundException.class)
    public ResponseEntity NoResourceFoundException(NoResourceFoundException e){
        String message=e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    //for pathvariable type
    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e){
        String message=e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    //add in text instead of json
    @ExceptionHandler(value = HttpMediaTypeNotSupportedException.class)
    public ResponseEntity HttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e){
        String message=e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    //refers to null
    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity NullPointerException(NullPointerException e){
        String message=e.getMessage();
        return ResponseEntity.status(400).body(message);
    }






}
