package com.example.springboot.exceptions;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(AnimeNotFoundException.class)
  public ResponseEntity<String> handleAnimeNotFound(AnimeNotFoundException ex) {
    return ResponseEntity.status(404).body(ex.getMessage());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> handleValidationErrors(
    MethodArgumentNotValidException exp
  ) {
    Map<String, String> errorMap = new HashMap<>();

    exp
      .getBindingResult()
      .getFieldErrors()
      .forEach(error ->
        errorMap.put(error.getField(), error.getDefaultMessage())
      );

    return ResponseEntity.badRequest().body(errorMap);
  }
}
