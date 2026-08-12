package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Anime {

  private String name = "isekai cheat magician";
  private Genre genre;

  @Autowired
  public Anime(@Qualifier("action-genre") Genre genre) {
    this.genre = genre;
  }

  public void animeDetails() {
    System.out.println("name:" + name);
    genre.showGenre();
  }
}
