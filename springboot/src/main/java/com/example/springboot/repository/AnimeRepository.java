package com.example.springboot.repository;

import com.example.springboot.entity.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, Integer> {}
