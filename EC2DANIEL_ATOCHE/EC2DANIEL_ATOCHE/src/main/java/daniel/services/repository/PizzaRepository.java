package daniel.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import daniel.services.model.Pizza;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer>{
	
}
