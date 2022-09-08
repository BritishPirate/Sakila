package com.Sakila.api.SakilaApp;

import org.json.JSONObject;

class FilmSearchResult{
    public String title;
    public String description;
    public CategorySkim[] categories;

    public FilmSearchResult(String title, String description, Iterable<Category> categories){
        this.title = title;
        this.description = description;
        this.categories = CategorySkim.categoriesToSkim();
    }

    public FilmSearchResult(Film film, Iterable<Category> categories){
        this.title = film.title;
        this.description = film.description;
        this.categories = CategorySkim.categoriesToSkim();
    }

    //Helper Methods
    public String[] toJsonString(){
        String[] ret = {
            "Title", this.title,
            "Description", this.description,
            "Categories", this.categories.toString()
        };
        return ret;
    }

    public JSONObject toJson(){ //In reverse order!!
        JSONObject ret = new JSONObject();
        ret.put("Categories", this.categories);
        ret.put("Description", this.description);
        ret.put("Title", this.title);
        return ret;
    }
}