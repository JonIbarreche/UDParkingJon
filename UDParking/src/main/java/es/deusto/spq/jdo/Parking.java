/** \file 
 * Breve descripción de es.deusto.spq.jdo Parking.java. Jun 14, 2021
 */
package es.deusto.spq.jdo;


import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
/**
 * Clase Parking
 *
 */
@PersistenceCapable
public class Parking {
	@PrimaryKey
	protected String name = null;
	protected Set<Vehiculo> vehiculos = new HashSet<>();
	
	public Parking(String name) {
		
		this.name = name;
	}
	/**
	 * Obtener el nombre del parking
	 *
	 */
	public String getName() {
		return name;
	}
	/**
	 * Asignar el nombre del parking
	 *
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(Set<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	/**
	 * Obtener el toString del parking
	 *
	 */
	@Override
	public String toString() {
		return "Parking [name=" + name + ", vehiculos=" + vehiculos + "]";
	}
	
	
	
}
