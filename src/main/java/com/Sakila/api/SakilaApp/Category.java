package com.Sakila.api.SakilaApp;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    //region Attributes
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int category_id;
    String name;
    //endregion

    //region Constructors
    public Category(){

    }

    public Category(int category_id, String name){
        this.category_id = category_id;
        this.name = name;
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

    //endregion


}
