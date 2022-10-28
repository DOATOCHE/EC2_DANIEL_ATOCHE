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

import danie.services.service.PizzaService;
import daniel.services.model.Pizza;



@RestController
@RequestMapping("/pizza/sw")
public class PizzaController {
	
	@Autowired
	private PizzaService service;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Pizza>> listar(){
		return new ResponseEntity<List<Pizza>>(service.listar(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar" , method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Pizza pizza){
		service.guardar(pizza);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}", method =  RequestMethod.GET)
	public ResponseEntity<Pizza> obtenerPorId(@PathVariable Integer id){
		Pizza pizza = service.obtener(id);
		if (pizza !=null) {
			return new ResponseEntity<Pizza>(pizza, HttpStatus.OK);
		}else {
			return new ResponseEntity<Pizza>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Pizza pizza){
		Pizza p =service.obtener(pizza.getIdPizza());
		if(p !=null) {
			service.actualizar(pizza);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path = "/eliminar/{id}" , method = RequestMethod.DELETE)
	public ResponseEntity<Void>eliminar(@PathVariable Integer id){
		Pizza pizza = service.obtener(id);
		if(pizza !=null) {
			service.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}
