package danie.services.service;

import java.util.List;

import daniel.services.model.Pizza;

public interface PizzaService {
	
	void guardar(Pizza pizza);
	void actualizar(Pizza pizza);
	void eliminar(Integer id);
	List<Pizza> listar();
	Pizza obtener(Integer id);
}
