package danie.services.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daniel.services.model.Pizza;
import daniel.services.repository.PizzaRepository;

@Service
public class PizzaServiceImpl implements PizzaService {
	
	@Autowired
	private PizzaRepository repositorio;
	
	@Override
	public void guardar(Pizza pizza) {
		// TODO Auto-generated method stub
		repositorio.save(pizza);

	}

	@Override
	public void actualizar(Pizza pizza) {
		// TODO Auto-generated method stub
		repositorio.saveAndFlush(pizza);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
	}

	@Override
	public List<Pizza> listar() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Pizza obtener(Integer id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).orElse(null);
	}

}
