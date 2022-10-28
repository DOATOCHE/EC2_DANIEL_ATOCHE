package daniel.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import daniel.services.model.Ingredientes;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingredientes, Integer>{

}
