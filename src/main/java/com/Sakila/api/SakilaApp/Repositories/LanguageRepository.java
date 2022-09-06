package com.Sakila.api.SakilaApp.Repositories;

import com.Sakila.api.SakilaApp.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
}