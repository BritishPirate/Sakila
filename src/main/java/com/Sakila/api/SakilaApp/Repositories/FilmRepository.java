package com.Sakila.api.SakilaApp.Repositories;

import com.Sakila.api.SakilaApp.Film;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<Film, Integer> {
}