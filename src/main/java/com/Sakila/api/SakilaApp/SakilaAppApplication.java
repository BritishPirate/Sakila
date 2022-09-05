package com.Sakila.api.SakilaApp;

import com.Sakila.api.SakilaApp.Repositories.ActorRepository;
import com.Sakila.api.SakilaApp.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
}
