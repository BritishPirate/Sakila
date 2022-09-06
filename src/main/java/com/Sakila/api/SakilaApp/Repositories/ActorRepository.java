package com.Sakila.api.SakilaApp.Repositories;

import com.Sakila.api.SakilaApp.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

}
