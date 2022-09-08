package com.Sakila.api.SakilaApp;

import java.util.ArrayList;

public class CategorySkim {
    public String categoryName;

    public CategorySkim(Category category){
        this.categoryName = category.name;
    }

    public CategorySkim(){
        this.categoryName = "Test";
    }


    public static CategorySkim[] categoriesToSkim(){
        CategorySkim[] temp = {new CategorySkim()};
        return temp;
    }

    public static CategorySkim[] categoriesToSkim(Iterable<Category> categories){
        ArrayList<CategorySkim> categorySkims = new ArrayList<>();
        for(Category category : categories){
            categorySkims.add(new CategorySkim(category));
            System.out.println(category);
        }
        CategorySkim[] ret = new CategorySkim[categorySkims.size()];
        categorySkims.toArray(ret);
        return ret;
    }
}
