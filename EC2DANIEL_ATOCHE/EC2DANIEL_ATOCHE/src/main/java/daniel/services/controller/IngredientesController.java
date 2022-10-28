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

import danie.services.service.IngredientesService;
import daniel.services.model.Ingredientes;

@RestController
@RequestMapping("/ingrediente/sw")
public class IngredientesController {
	
	@Autowired
	private IngredientesService service;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Ingredientes>> listar(){
		return new ResponseEntity<List<Ingredientes>>(service.listar(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar" , method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Ingredientes ingredientes){
		service.guardar(ingredientes);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}", method =  RequestMethod.GET)
	public ResponseEntity<Ingredientes> obtenerPorId(@PathVariable Integer id){
		Ingredientes ingredientes = service.obtener(id);
		if (ingredientes !=null) {
			return new ResponseEntity<Ingredientes>(ingredientes, HttpStatus.OK);
		}else {
			return new ResponseEntity<Ingredientes>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Ingredientes ingredientes){
		Ingredientes p =service.obtener(ingredientes.getIdIngrediente());
		if(p !=null) {
			service.actualizar(ingredientes);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path = "/eliminar/{id}" , method = RequestMethod.DELETE)
	public ResponseEntity<Void>eliminar(@PathVariable Integer id){
		Ingredientes ingredientes = service.obtener(id);
		if(ingredientes !=null) {
			service.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}
