package demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import demo.domain.Player;

//HATEOAS - enables linking of depandent Resources based on underlying data relationships (JPA annotations)
// - if this REST provider is marked as such, Spring will automatically link it
//      - subordinate entity is the one that forces to be linked
@RestResource(path="players", rel="player")
public interface PlayerRepository extends CrudRepository<Player,Long>{

}
