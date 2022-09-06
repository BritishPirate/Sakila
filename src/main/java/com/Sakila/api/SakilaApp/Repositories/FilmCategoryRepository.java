package com.Sakila.api.SakilaApp.Repositories;

import com.Sakila.api.SakilaApp.FilmCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface FilmCategoryRepository extends JpaRepository<FilmCategory, Integer> {
    @Query(value = "SELECT * FROM film_category \n" +
            "WHERE film_id = :id ;", nativeQuery = true)
    Optional<Object> getCategoryByFilmId(@Param("id") Integer id);
}