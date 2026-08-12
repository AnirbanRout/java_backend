package com.example.springboot.mapper;

import com.example.springboot.Dto.AnimeDTO;
import com.example.springboot.entity.Anime;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AnimeMapper {
  @Mapping(target = "id", ignore = true)
  Anime toEntity(AnimeDTO dto);

  AnimeDTO toDTO(Anime anime);

  List<AnimeDTO> toDTO(List<Anime> animeList);
}
