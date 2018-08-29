package demo.controller;

import demo.domain.Team;
import demo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
// Regular controller -> demands 'ResponseBody'
public class TeamAlterController {

	// autowire some DAO
	@Autowired
	TeamRepository teamRepository;

	//	-> returns domain objects (to be exact, iterable of domain objects), as response body
	@GetMapping("/teams_alt")
	public @ResponseBody Iterable<Team> getTeams() {
		return teamRepository.findAll();
	}

	//	-> returns domain object
	@GetMapping("/teams_alt/{id}")
	public @ResponseBody Team getTeam(@PathVariable Long id){
		return teamRepository.findById(id).get();
	}
	
}
