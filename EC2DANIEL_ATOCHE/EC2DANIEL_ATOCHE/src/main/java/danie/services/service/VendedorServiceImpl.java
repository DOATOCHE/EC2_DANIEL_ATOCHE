package danie.services.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daniel.services.model.Vendedor;
import daniel.services.repository.VendedorRepository;

@Service
public class VendedorServiceImpl implements VendedorService {
	
	@Autowired
	private VendedorRepository repositorio;
	
	@Override
	public void guardar(Vendedor vendedor) {
		// TODO Auto-generated method stub
		repositorio.save(vendedor);
	}

	@Override
	public void actualizar(Vendedor vendedor) {
		// TODO Auto-generated method stub
		repositorio.saveAndFlush(vendedor);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
	}

	@Override
	public List<Vendedor> listar() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Vendedor obtener(Integer id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).orElse(null);
	}

}
