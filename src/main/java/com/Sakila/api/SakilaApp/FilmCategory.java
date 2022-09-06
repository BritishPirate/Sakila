package com.Sakila.api.SakilaApp;

import javax.persistence.*;

@Entity
@Table(name = "film_category")
public class FilmCategory {
    //region Attributes
    @Id
    @Column(name = "film_id") //This can be used to refer to specific column without adhering to the same name
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer film_id;
    @Column(name = "category_id")
    int category_id;

    @Column(name = "percentage")
    int percentage;

    public FilmCategory(int film_id, int category_id, int percentage){
        this.film_id = film_id;
        this.category_id = category_id;
        this.percentage = percentage;
    }

    public FilmCategory(){

    }
}
