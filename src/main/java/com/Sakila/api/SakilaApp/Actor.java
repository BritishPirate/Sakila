package com.Sakila.api.SakilaApp;

import javax.persistence.*;

@Entity
@Table(name = "actor")
public class Actor {
    //region Attributes
    @Id
    @Column(name = "actor_id") //This can be used to refer to specific column without adhering to the same name
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int actor_id;
    String first_name;
    String last_name;
    //endregion

    //region Constructor
    public Actor(int actor_id, String first_name, String last_name){
        this.actor_id = actor_id;
        this.first_name = first_name;
        this.last_name = last_name;
    }
    public Actor(){

    }
    //endregion

    //region Methods
    //region getters and setters
    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    //endregion
    //endregion
}
