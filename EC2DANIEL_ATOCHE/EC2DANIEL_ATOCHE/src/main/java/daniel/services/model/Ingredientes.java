package daniel.services.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ingredientes")
public class Ingredientes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idIngrediente;
	private String nombre;
	private String descripcion;
	
	@ManyToMany(mappedBy = "ingredientes", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Pizza> pizas = new ArrayList<>();
	
	public Integer getIdIngrediente() {
		return idIngrediente;
	}
	public void setIdIngrediente(Integer idIngrediente) {
		this.idIngrediente = idIngrediente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
}
