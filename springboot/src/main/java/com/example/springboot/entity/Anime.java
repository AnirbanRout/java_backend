package com.example.springboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Anime {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column
  @NotBlank(message = "Anime name is required")
  @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
  private String name;

  @Column
  @NotBlank(message = "Genre is required")
  @Size(
    min = 2,
    max = 30,
    message = "Genre must be between 2 and 30 characters"
  )
  private String genre;
}
