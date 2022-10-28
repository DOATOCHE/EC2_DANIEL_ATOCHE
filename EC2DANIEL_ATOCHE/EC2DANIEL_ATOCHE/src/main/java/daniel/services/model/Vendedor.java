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
@Table(name = "vendedores")
public class Vendedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVendedor;
	private String nombre;
	private String celular;
	
	@ManyToMany(mappedBy = "vendedores", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Pizza> pizas = new ArrayList<>();
	
	public Integer getIdVendedor() {
		return idVendedor;
	}
	public void setIdVendedor(Integer idVendedor) {
		this.idVendedor = idVendedor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	

	
	
}
