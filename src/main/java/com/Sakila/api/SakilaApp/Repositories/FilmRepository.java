package com.Sakila.api.SakilaApp.Repositories;

import com.Sakila.api.SakilaApp.Category;
import com.Sakila.api.SakilaApp.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Integer> {
    /*
    @Query(value =  "SELECT category.category_id, category.name, category.last_update FROM sakila.category\n" +
                    "INNER JOIN film_category on film_category.category_id = category.category_id\n" +
                    "INNER JOIN film ON film.film_id = film_category.film_id\n" +
                    "WHERE film.film_id = :id ;",
                     nativeQuery = true)
    Iterable<Category> getFilmCategories(@Param("id") Integer id); */

}