package com.Sakila.api.SakilaApp;



import com.Sakila.api.SakilaApp.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "film")
public class Film {
    @ManyToMany
    @JoinTable(
            name = "film_category",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    Set<Category> filmCategory;
    //region Attributes
    @Id
    @Column(name = "film_id") //This can be used to refer to specific column without adhering to the same name
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int film_id;
    String title;
    String description;
    int release_year;
    Integer language_id;
    //Integer original_language_id;
    Integer rental_duration;
    float rental_rate;
    Integer length;
    float replacement_cost;
    //ENUM rating
    //SET special_features
    //endregion

    //region constructors
    public Film(String title, String description, Integer release_year, Integer language_id, Integer rental_duration, float rental_rate, Integer length, float replacement_cost){
        this.title = title;
        this.description = description;
        this.release_year = release_year;
        this.language_id = language_id;
        //this.original_language_id = original_language_id;
        this.rental_duration = rental_duration;
        this.rental_rate = rental_rate;
        this.length = length;
        this.replacement_cost = replacement_cost;
    }

    public Film(){

    }
    //endregion

    //region Methods
    //region Getters and Setters

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

/*
    public int getOriginal_language_id() {
        return original_language_id;
    }

    public void setOriginal_language_id(int original_language_id) {
        this.original_language_id = original_language_id;
    }
 */
    public int getRental_duration() {
        return rental_duration;
    }

    public void setRental_duration(int rental_duration) {
        this.rental_duration = rental_duration;
    }

    public float getRental_rate() {
        return rental_rate;
    }

    public void setRental_rate(float rental_rate) {
        this.rental_rate = rental_rate;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public float getReplacement_cost() {
        return replacement_cost;
    }

    public void setReplacement_cost(float replacement_cost) {
        this.replacement_cost = replacement_cost;
    }

    //endregion
    //endregion

}
