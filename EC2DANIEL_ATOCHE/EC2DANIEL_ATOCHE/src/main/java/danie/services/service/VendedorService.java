package danie.services.service;

import java.util.List;

import daniel.services.model.Vendedor;

public interface VendedorService {
	
	void guardar(Vendedor vendedor);
	void actualizar(Vendedor vendedor);
	void eliminar(Integer id);
	List<Vendedor> listar();
	Vendedor obtener(Integer id);
}
