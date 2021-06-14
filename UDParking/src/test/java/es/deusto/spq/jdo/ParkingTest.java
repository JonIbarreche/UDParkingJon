/** \file 
 * Breve descripción de es.deusto.spq.jdo ParkingTest.java. Jun 14, 2021
 */
package es.deusto.spq.jdo;

import static org.junit.Assert.*;
import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
/**
 * Clase test Parking
 *
 */
public class ParkingTest {
	private Parking p;
	private Set<Vehiculo> vehiculos;
	private Vehiculo v;
	/**
	 * Metodo para construir objeto Parking con sus atributos correspondientes. Y
	 * construir objeto Vehiculo con sus atributos correspondientes.
	 */
	@Before
	public void setUp() throws Exception {
		p = new Parking("Parking Bilbao");
		vehiculos = new HashSet<Vehiculo>();
		v = new Vehiculo("NombreTest", "DescripcionTest", 1);
		vehiculos.add(v);
	}

	/**
	 * Test para establecer el nombre de un Parking
	 *
	 */
	@Test
	public void testSetGetName() {
		p.setName("NombreTest");
		assertEquals("NombreTest", p.getName());
	}

	/**
	 * Test para obtener el tamaño de los vehiculos
	 *
	 */
	@Test
	public void testGetProducts() {
		assertEquals(vehiculos.size(), 1);
	}
	/**
	 * Test para obtener el ToString del Parking, saca un string con la
	 * estructura definida en el propio método.
	 *
	 */
	@Ignore
	@Test
	public void testToString() {
		assertEquals("Parking [name=\" + name + \", vehiculos=\" + vehiculos + \"]", p.toString());
	}

}
