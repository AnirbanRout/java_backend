package com.example.springboot.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(AnimeNotFoundException.class)
  public ResponseEntity<String> handleAnimeNotFound(AnimeNotFoundException ex) {
    return ResponseEntity.status(404).body(ex.getMessage());
  }
}
