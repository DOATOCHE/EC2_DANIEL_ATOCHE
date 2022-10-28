package daniel.services.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name = "pizas")
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPizza;
	private String pizza;
	private String descripcion;
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(
			name="pizza_vendedor",
			joinColumns = @JoinColumn(
					name="id_pizza",
					nullable = false,
					unique = true,
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_pizza) references pizas(id_pizza)")
			),
			inverseJoinColumns = @JoinColumn(
					name="id_vendedor",
					nullable = false,
					unique = true,
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_vendedor) references vendedores(id_vendedor)")
			)
	)
	private List<Vendedor> vendedores = new ArrayList<>();
	
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(
			name="pizza_ingredientes",
			joinColumns = @JoinColumn(
					name="id_pizza",
					nullable = false,
					unique = true,
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_pizza) references pizas(id_pizza)")
			),
			inverseJoinColumns = @JoinColumn(
					name="id_ingrediente",
					nullable = false,
					unique = true,
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_ingrediente) references ingredientes(id_ingrediente)")
			)
	)
	private List<Ingredientes> ingredientes = new ArrayList<>();
	
	public Integer getIdPizza() {
		return idPizza;
	}
	public void setIdPizza(Integer idPizza) {
		this.idPizza = idPizza;
	}
	public String getPizza() {
		return pizza;
	}
	public void setPizza(String pizza) {
		this.pizza = pizza;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

	
	
}
