package com.example;

import org.springframework.stereotype.Component;

@Component("isekai-genre")
public class IsekaiGenre implements Genre {

  @Override
  public void showGenre() {
    System.out.println("genre:isekai");
  }
}
