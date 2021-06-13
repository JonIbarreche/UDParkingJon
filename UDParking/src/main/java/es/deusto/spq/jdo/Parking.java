package es.deusto.spq.jdo;


import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Parking {
	@PrimaryKey
	protected String name = null;
	protected Set<Vehiculo> vehiculos = new HashSet<>();
	
	public Parking(String name) {
		
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(Set<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	@Override
	public String toString() {
		return "Parking [name=" + name + ", vehiculos=" + vehiculos + "]";
	}
	
	
	
}
