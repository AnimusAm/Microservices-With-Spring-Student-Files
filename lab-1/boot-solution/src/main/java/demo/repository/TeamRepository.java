package demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import demo.domain.Team;

import java.util.List;

//  Spring Data JPA (sub)project -> provides RESTfull interfaces on Service tier - SPRING DATA REST level
@RestResource(path="teams", rel="team")
// Spring Data JPA (sub)project (doesn't add DB driver - has to be added as dependency) - SPRING DATA REPOSITORY level
//  -> provides dynamic implementation of DAO CRUD repositories (you only provide interface like this that extends some other CrudRepository)
public interface TeamRepository extends CrudRepository<Team,Long>{

    List<Team> findAll();

    Team findByName(String name);
}
