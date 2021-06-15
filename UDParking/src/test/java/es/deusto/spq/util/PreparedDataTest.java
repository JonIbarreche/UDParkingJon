/** \file 
 * Breve descripción de es.deusto.spq.util PreparedDataTest.java. Jun 13, 2021
 */
package es.deusto.spq.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import es.deusto.spq.types.GuiTest;

/**
 * Clase Test PreparedData
 *
 */
@Category(GuiTest.class)
public class PreparedDataTest {

	private static PreparedData pd;

	/**
	 * Metodo para iniciar PreparedData
	 *
	 */
	@Before
	public void setUp() throws Exception {

		pd = new PreparedData();

	}

	/**
	 * Test para crear Vehiculos
	 *
	 */
	@SuppressWarnings("static-access")
	@Test
	public void crearVehiculoTest() {

		pd.crearVehiculo();
		pd.pm.deletePersistent(pd.vehiculoA);
		pd.pm.deletePersistent(pd.vehiculoB);
		pd.pm.deletePersistent(pd.vehiculoC);
		pd.pm.deletePersistent(pd.vehiculoD);
		pd.pm.deletePersistent(pd.vehiculoE);
		pd.pm.deletePersistent(pd.vehiculoF);
		pd.pm.deletePersistent(pd.vehiculoG);
	}
	
	/**
	 * Test para crear Parking
	 *
	 */
	@Ignore
	@SuppressWarnings("static-access")
	@Test
	public void crearParkingTest() {

		pd.crearParking();
		pd.pm.deletePersistent(pd.p1);
		pd.pm.deletePersistent(pd.p2);
		pd.pm.deletePersistent(pd.p3);
		pd.pm.deletePersistent(pd.p4);
		
	}
	
}
