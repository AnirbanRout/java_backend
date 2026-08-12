package com.example.springboot.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnimeDTO {

  @NotBlank(message = "Anime name is required")
  @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
  private String name;

  @NotBlank(message = "Genre is required")
  @Size(
    min = 2,
    max = 30,
    message = "Genre must be between 2 and 30 characters"
  )
  private String genre;
}
