package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import demo.domain.Team;
import demo.repository.TeamRepository;

@RestController
// marks this service as REST
// another option would be to leave this class as regular Controller, but to use @ResponseBody for each method
// in both cases methods should return
public class TeamController {

	// autowire some DAO
	@Autowired
	TeamRepository teamRepository;

	// notice that there is no view implementation -> rest returns structured data (JSON, XML, ...)
	//	-> returns domain objects (to be exact, iterable of domain objects)
	@GetMapping("/teams")
	public Iterable<Team> getTeams() {
		return teamRepository.findAll();
	}

	//	-> returns domain object
	@GetMapping("/teams/{id}")
	public Team getTeam(@PathVariable Long id){
		return teamRepository.findById(id).get();
	}
	
}
