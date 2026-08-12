package com.example.springboot.services;

import com.example.springboot.Dto.AnimeDTO;
import com.example.springboot.entity.Anime;
import com.example.springboot.exceptions.AnimeNotFoundException;
import com.example.springboot.mapper.AnimeMapper;
import com.example.springboot.repository.AnimeRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * AnimeService
 */
@Service
public class AnimeService {

  private final AnimeRepository animeRepository;
  private final AnimeMapper animeMapper;

  public AnimeService(
    AnimeRepository animeRepository,
    AnimeMapper animeMapper
  ) {
    this.animeRepository = animeRepository;
    this.animeMapper = animeMapper;
  }

  public AnimeDTO addAnime(AnimeDTO animeDTO) {
    Anime anime = animeMapper.toEntity(animeDTO);
    Anime savedAnime = animeRepository.save(anime);
    return animeMapper.toDTO(savedAnime);
  }

  public List<AnimeDTO> getAllAnimes() {
    List<Anime> animeList = animeRepository.findAll();
    return animeMapper.toDTO(animeList);
  }

  public AnimeDTO updateAnime(Integer id, AnimeDTO animeDTO) {
    Anime existingAnime = animeRepository
      .findById(id)
      .orElseThrow(() -> {
        return new AnimeNotFoundException("no anime found with the id:" + id);
      });

    Anime anime = animeMapper.toEntity(animeDTO);

    existingAnime.setName(anime.getName());
    existingAnime.setGenre(anime.getGenre());

    Anime updatedAnime = animeRepository.save(existingAnime);
    return animeMapper.toDTO(updatedAnime);
  }

  public void deleteAnime(Integer id) {
    Anime existingAnime = animeRepository
      .findById(id)
      .orElseThrow(() -> {
        return new AnimeNotFoundException("no anime found with the id:" + id);
      });
    animeRepository.delete(existingAnime);
  }

  public AnimeDTO findAnimeById(Integer id) {
    Anime anime = animeRepository
      .findById(id)
      .orElseThrow(() -> {
        return new AnimeNotFoundException("no anime found with this id:" + id);
      });

    return animeMapper.toDTO(anime);
  }
}
