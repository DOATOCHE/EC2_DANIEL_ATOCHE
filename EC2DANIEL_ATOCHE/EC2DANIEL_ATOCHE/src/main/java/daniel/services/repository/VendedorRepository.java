package daniel.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import daniel.services.model.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer>{

}
