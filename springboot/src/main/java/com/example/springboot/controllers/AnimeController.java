package com.example.springboot.controllers;

import com.example.springboot.Dto.AnimeDTO;
import com.example.springboot.services.AnimeService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AnimeController
 */
@RestController
@RequestMapping("/anime")
public class AnimeController {

  private final AnimeService animeService;

  public AnimeController(AnimeService animeService) {
    this.animeService = animeService;
  }

  @GetMapping("/all")
  public ResponseEntity<List<AnimeDTO>> getAllAnime() {
    List<AnimeDTO> animeList = animeService.getAllAnimes();
    return ResponseEntity.ok(animeList);
  }

  @GetMapping("/{id}")
  public ResponseEntity<AnimeDTO> findAnimeById(@PathVariable Integer id) {
    AnimeDTO animeDTO = animeService.findAnimeById(id);
    return ResponseEntity.ok(animeDTO);
  }

  @PostMapping("/addAnime")
  public ResponseEntity<AnimeDTO> addAnime(
    @Valid @RequestBody AnimeDTO animeDTO
  ) {
    AnimeDTO responseAnime = animeService.addAnime(animeDTO);
    return ResponseEntity.status(201).body(responseAnime);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<AnimeDTO> updateAnime(
    @PathVariable int id,
    @Valid @RequestBody AnimeDTO animeDTO
  ) {
    AnimeDTO updatedAnime = animeService.updateAnime(id, animeDTO);
    return ResponseEntity.ok(updatedAnime);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> deleteAnime(@PathVariable Integer id) {
    animeService.deleteAnime(id);
    return ResponseEntity.ok("anime deleted successfully...");
  }
}
