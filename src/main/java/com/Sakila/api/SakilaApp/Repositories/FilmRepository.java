package com.Sakila.api.SakilaApp.Repositories;

import com.Sakila.api.SakilaApp.Category;
import com.Sakila.api.SakilaApp.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Integer> {

    @Query(value =  "SELECT * FROM sakila.film\n" +
                    "WHERE title LIKE CONCAT('%',:id ,'%');",
                     nativeQuery = true)
    Iterable<Film> findFilmByTitle(String id);

}