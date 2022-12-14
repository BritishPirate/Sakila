package com.Sakila.api.SakilaApp;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;


@Entity
@Table(name = "category")
public class Category {

    @ManyToMany(mappedBy = "filmCategory")
    Set<Film> categoryFilm;

    //region Attributes
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int category_id;
    String name;
    Date last_update;
    //endregion

    //region Constructors
    public Category(){

    }

    public Category(int category_id, String name, Date last_update){
        this.category_id = category_id;
        this.name = name;
        this.last_update = last_update;
    }
    //endregion

    //region getters and setters

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }



    //endregion


}
