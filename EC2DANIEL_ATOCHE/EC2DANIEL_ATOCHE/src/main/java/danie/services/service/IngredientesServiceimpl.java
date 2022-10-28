package danie.services.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daniel.services.model.Ingredientes;
import daniel.services.repository.IngredienteRepository;

@Service
public class IngredientesServiceimpl implements IngredientesService{
	
	@Autowired
	private IngredienteRepository repositorio;
	
	@Override
	public void guardar(Ingredientes ingredientes) {
		// TODO Auto-generated method stub
		repositorio.save(ingredientes);
	}

	@Override
	public void actualizar(Ingredientes ingredientes) {
		// TODO Auto-generated method stub
		repositorio.saveAndFlush(ingredientes);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
	}

	@Override
	public List<Ingredientes> listar() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Ingredientes obtener(Integer id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).orElse(null);
	}
	
	
}
