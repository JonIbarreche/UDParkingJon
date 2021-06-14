/** \file 
 * Breve descripción de es.deusto.spq.jdo Vehiculo.java. Jun 13, 2021
 */
package es.deusto.spq.jdo;


import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
/**
 * Clase Vehiculo
 *
 */
@PersistenceCapable
public class Vehiculo {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.NATIVE)
	protected long id;

	protected String name = null;

	protected String description = null;

	protected long price = 0;
	/**
	 * Metodo para construir objeto Vehiculo con sus atributos correspondientes
	 *
	 */
	public Vehiculo(String name, String description, long price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}
	/**
	 * Metodo para construir objeto Vehiculo (con int) con sus atributos correspondientes
	 *
	 */
	public Vehiculo(String name2, String description2, int price2) {
		this.name = name2;
		this.description = description2;
		this.price = price2;
	}
	/**
	 * Test para obtener el id del vehiculo
	 *
	 */
	public long getId() {
		return id;
	}
	/**
	 * Test para asignar el id del vehiculo
	 *
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * Test para obtener el nombre del vehiculo
	 *
	 */
	public String getName() {
		return name;
	}
	/**
	 * Test para asignar el nombre del vehiculo
	 *
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Test para obtener la descripcion del vehiculo
	 *
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Test para asignar la descripcion del vehiculo
	 *
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Test para obtener el precio del vehiculo
	 *
	 */
	public long getPrice() {
		return price;
	}
	/**
	 * Test para asignar el precio del vehiculo
	 *
	 */
	public void setPrice(long price) {
		this.price = price;
	}
	/**
	 * Test para obtener el ToString del vehiculo
	 *
	 */
	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + "]";
	}
	
	
	
}
