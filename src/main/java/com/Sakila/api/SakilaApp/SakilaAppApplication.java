package com.Sakila.api.SakilaApp;

import com.Sakila.api.SakilaApp.Repositories.ActorRepository;
import com.Sakila.api.SakilaApp.Repositories.CategoryRepository;
import com.Sakila.api.SakilaApp.Repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.json.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@SpringBootApplication
@RestController
@RequestMapping("/Home")
@CrossOrigin()
public class SakilaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SakilaAppApplication.class, args);
	}

	@Autowired
	private ActorRepository actorRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private FilmRepository filmRepository;

	public SakilaAppApplication(ActorRepository actorRepository, CategoryRepository categoryRepository){
		this.actorRepository = actorRepository;
		this.categoryRepository = categoryRepository;
	}

	@GetMapping("/AllActors")
	@ResponseBody
	public Iterable<Actor> getAllActors(){
		return actorRepository.findAll();
	}

	@GetMapping("/Actor/{id}")
	@ResponseBody
	public Optional<Actor> getActor(@PathVariable Integer id){
		return actorRepository.findById(id);
	}

	@PutMapping("/AddActor/{id}")
	@ResponseBody
	public String addActor(@PathVariable Integer id, @RequestParam String first_name, @RequestParam String last_name){
		Actor actor = new Actor(id, "", "");
		actorRepository.save(actor);
		return ("This is " + actor.actor_id);
	}

	@DeleteMapping("/DelActor/{id}")
	@ResponseBody
	public String deleteActor(@PathVariable Integer id){
		try {
			actorRepository.deleteById(id);
			return ("Bye bye " + id);
		}
		catch (Error e){
			return e.getMessage();
		}
	}

	@PutMapping("/UpdateActor/{id}")
	@ResponseBody
	public String updateActor(@PathVariable Integer id, @RequestParam String first_name, @RequestParam String last_name){
		Actor actor = actorRepository.findById(id).get();
		actor.first_name = (first_name.equals("") ? actor.first_name : first_name);
		actor.last_name = (last_name.equals("") ? actor.last_name : last_name);
		actorRepository.save(actor);
		return actorRepository.findById(id).get().toString();
	}


	@GetMapping("/GetAllCategories")
	@ResponseBody
	public Iterable<Category> getAllCategories(){
		return categoryRepository.findAll();
	}

	@GetMapping("/GetFilmCategories/{id}")
	@ResponseBody
	public Iterable<Category> getFilmCategories(@PathVariable Integer id){
		return categoryRepository.getFilmCategories(id);
	}

	@GetMapping("/GetFilmByTitle/{id}")
	@ResponseBody
	public String findFilmByTitle(@PathVariable String id){
		Iterable<Film> filmList = filmRepository.findFilmByTitle(id);
		ArrayList<JSONObject>  searchResults = new ArrayList<JSONObject>();
		for(Film film : filmList){
			searchResults.add(new FilmSearchResult(film, getFilmCategories(film.film_id)).toJson());
		}
		JSONArray ret = new JSONArray(searchResults);
		return ret.toString();
	}


	@GetMapping("/GetFilmCategoryJson/{id}")
	@ResponseBody
	public JSONObject getFilmCategoryJson(@PathVariable Integer id){
		FilmSearchResult filmSearchResult = new FilmSearchResult(filmRepository.findById(id).get(), categoryRepository.getFilmCategories(id));
		return filmSearchResult.toJson();
	}

	@GetMapping("/GetFilmSearchResult/{id}")
	@ResponseBody
	public FilmSearchResult getFilmSearchResult(@PathVariable Integer id){
		return new FilmSearchResult(filmRepository.findById(id).get(), categoryRepository.getFilmCategories(id));
	}

	@GetMapping("/GetCategorySlim/{id}")
	@ResponseBody
	public CategorySkim getCategorySkim(@PathVariable Integer id){
		return new CategorySkim(categoryRepository.findById(id).get());
	}

	@GetMapping("/GetFilmCategoriesSlim/{id}")
	@ResponseBody
	public CategorySkim[] getCategoriesSkim(@PathVariable Integer id){
		CategorySkim[] ret = CategorySkim.categoriesToSkim(categoryRepository.getFilmCategories(id));
		return ret;
	}

	@GetMapping("/GetJson")
	@ResponseBody
	public String getJson(){
		JSONObject json = new JSONObject("Apple", "Banana");
		json.put("Apple", "Banana");
		return json.toString();
	}
}