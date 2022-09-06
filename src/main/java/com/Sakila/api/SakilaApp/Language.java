package com.Sakila.api.SakilaApp;

import javax.persistence.*;

@Entity
@Table(name = "language")
public class Language {
    //region Attributes
    @Id
    @Column(name = "language_id") //This can be used to refer to specific column without adhering to the same name
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int language_id;

    String name;
    //endregion

    //region Constructors
    public Language(String name){
        this.name = name;
    }
    public Language(){}
    //endregion

    //region Methods
    //region Getters and Setters

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //endregion
    //endregion
}
