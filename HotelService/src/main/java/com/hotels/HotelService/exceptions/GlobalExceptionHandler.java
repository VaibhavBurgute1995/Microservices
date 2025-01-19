package com.hotels.HotelService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleResourceNotFoundException(ResourceNotFoundException ex) {
        Map<String,Object> map = new HashMap<>();
        map.put("message", ex.getMessage());
        map.put("Success", false);
        map.put("statusCode", HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }
}
