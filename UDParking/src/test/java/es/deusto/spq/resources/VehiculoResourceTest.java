/** \file 
 * Breve descripción de es.deusto.spq.resources VehiculoResourceTest.java. Jun 13, 2021
 */
package es.deusto.spq.resources;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import es.deusto.spq.jdo.Vehiculo;
import es.deusto.spq.jdo.Main;
import es.deusto.spq.jdo.Parking;
import es.deusto.spq.types.IntegrationTest;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
/**
 * Clase test Vehiculo
 *
 */
@Category(IntegrationTest.class)
public class VehiculoResourceTest {

	/**
	 * Rule test
	 *
	 */
	@Rule
	public ContiPerfRule rule = new ContiPerfRule();
	private HttpServer server;
	private WebTarget appTarget;
	private Client c;
	
	/**
	 * Metodo para: iniciar el servidor Grizzly, crear un nuevo cliente
	 *
	 */
	@Before
	public void setUp() throws Exception {
		server = Main.startServer();
		c = ClientBuilder.newClient();
		appTarget = c.target(Main.BASE_URI);
	}
	
	/**
	 * TearDown Test
	 *
	 */
	@SuppressWarnings("deprecation")
	@After
	public void tearDown() throws Exception {
		server.stop();
	}
	
	/**
	 * Test para obtener Vehiculos
	 *
	 */
	@Ignore
	@Test
	@PerfTest(invocations = 100, threads = 40)
	public void testgetVehiculos() {
		WebTarget vehiculosTarget = appTarget.path("vehiculos");

		List<Vehiculo> listaVehiculos = Arrays.asList(new Vehiculo("Volkswagen Passat", "Descripcion 1", 8), new Vehiculo("Volkswagen Passat", "Descripcion 1", 8), 
				new Vehiculo("Volkswagen Passat", "Descripcion 1", 8));

		GenericType<List<Vehiculo>> genericType = new GenericType<List<Vehiculo>>() {
		};
		List<Vehiculo> vehiculo1 = vehiculosTarget.request(MediaType.APPLICATION_JSON).get(genericType);
		List<Vehiculo> vehiculo2 = new ArrayList<Vehiculo>();
		for (int i = 0; i < vehiculo1.size(); i++) {

			if (vehiculo1.get(i).getName().equals(listaVehiculos.get(0).getName())) {

				vehiculo2.add(vehiculo1.get(i));
				assertEquals(listaVehiculos.get(0).getName(), vehiculo2.get(0).getName());
			}

		}
		assertEquals(listaVehiculos.get(0).getName(), vehiculo1.get(0).getName());
		assertEquals(listaVehiculos.get(1).getName(), vehiculo1.get(1).getName());
		assertEquals(listaVehiculos.get(2).getName(), vehiculo1.get(2).getName());

	}
	
}
