package com.Sakila.api.SakilaApp;

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

	public SakilaAppApplication(ActorRepository actorRepository){
		this.actorRepository = actorRepository;
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
	public String addActor(@PathVariable Integer id){
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

	@PutMapping("/UpdateActors/{id}")
	@ResponseBody
	public String updateActor(@PathVariable Integer id){
		return "";
	}
}
