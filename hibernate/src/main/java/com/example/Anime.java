package com.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "animetb")
public class Anime {

  @Id
  @GeneratedValue
  private int id;

  @Column
  private String name;

  @Column
  private String genre;

  public Anime() {}

  public void setName(String name) {
    if (name != null && !name.isEmpty()) {
      this.name = name;
    }
  }

  public void setGenre(String genre) {
    if (genre != null && !genre.isEmpty()) {
      this.genre = genre;
    }
  }

  public String getName() {
    return this.name;
  }

  public String getGenre() {
    return this.genre;
  }
}
