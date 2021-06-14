/** \file 
 * Breve descripción de es.deusto.spq.jdo VehiculoTest.java. Jun 13, 2021
 */
package es.deusto.spq.jdo;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
/**
 * Clase test Vehiculo
 *
 */
public class VehiculoTest {
	private Vehiculo v;
	/**
	 * Metodo para construir objeto Vehiculo con sus atributos correspondientes
	 *
	 */
	@Before
	public void setUp() throws Exception {
		v = new Vehiculo("Opel Astra", "500 caballos de potencia", 7);
	}
	/**
	 * Test para obtener el id del vehiculo
	 *
	 */
	@Test
	public void testSetGetId() {
		v.setId(3);
		assertEquals(3, v.getId());
	}
	/**
	 * Test para obtener la descripcion del vehiculo
	 *
	 */
	@Test
	public void testSetGetDescripcion() {
		v.setDescription("testDescription");
		assertEquals("testDescription", v.getDescription());
	}
	
	/**
	 * Test para obtener el nombre del vehiculo
	 *
	 */
	@Test
	public void testSetGetName() {
		v.setName("testName");
		assertEquals("testName", v.getName());
	}

}
