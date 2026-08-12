package com.example;

import org.springframework.stereotype.Component;

@Component("action-genre")
public class ActionGenre implements Genre {

  @Override
  public void showGenre() {
    System.out.println("genre:action");
  }
}
