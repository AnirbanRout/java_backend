package com.example.springboot.exceptions;

public class AnimeNotFoundException extends RuntimeException {

  public AnimeNotFoundException(String messsage) {
    super(messsage);
  }
}
