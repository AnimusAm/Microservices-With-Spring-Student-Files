package demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import demo.domain.Player;
import demo.domain.Team;
import demo.repository.TeamRepository;

@SpringBootApplication
// Notice, main class does not extend SpringBootServletInitalizer
//	This means it will be run:
//		- as standard application
// 		- with internal tomcat server that Spring Boot opinionatedly chose
// Meaning - it doesn't request to be explicitly run on server (or external server run configuration to be defined)
// SpringBootServletInitalizer has some useful features (methods that can be implemented customary, like - 'configure')
public class Application {

	@Autowired TeamRepository teamRepository;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @PostConstruct
	public void init() {
		List<Team> list = new ArrayList<>();

		Set<Player> set = new HashSet<>();
		set.add(new Player("Big Easy", "Showman"));
		set.add(new Player("Buckets", "Guard"));
		set.add(new Player("Dizzy", "Guard"));
		
		list.add(new Team("Harlem", "Globetrotters", set));
		list.add(new Team("Washington","Generals",null));

		teamRepository.saveAll(list);
	}    
    
}
