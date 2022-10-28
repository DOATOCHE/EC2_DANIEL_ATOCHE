package daniel.services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import danie.services.service.VendedorService;
import daniel.services.model.Vendedor;


@RestController
@RequestMapping("/vendedor/s1")
public class VendedorController {
	
	
	@Autowired
	private VendedorService service;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Vendedor>> listar(){
		return new ResponseEntity<List<Vendedor>>(service.listar(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar" , method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Vendedor vendedor){
		service.guardar(vendedor);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}", method =  RequestMethod.GET)
	public ResponseEntity<Vendedor> obtenerPorId(@PathVariable Integer id){
		Vendedor vendedor = service.obtener(id);
		if (vendedor !=null) {
			return new ResponseEntity<Vendedor>(vendedor, HttpStatus.OK);
		}else {
			return new ResponseEntity<Vendedor>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Vendedor vendedor){
		Vendedor p =service.obtener(vendedor.getIdVendedor());
		if(p !=null) {
			service.actualizar(vendedor);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path = "/eliminar/{id}" , method = RequestMethod.DELETE)
	public ResponseEntity<Void>eliminar(@PathVariable Integer id){
		Vendedor vendedor = service.obtener(id);
		if(vendedor !=null) {
			service.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}
