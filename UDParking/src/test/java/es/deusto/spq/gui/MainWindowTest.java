/** \file 
 * Breve descripción de es.deusto.spq.gui MainWindowTest.java. Jun 14, 2021
 */
package es.deusto.spq.gui;

import static org.junit.Assert.*;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import es.deusto.spq.jdo.Parking;
import es.deusto.spq.jdo.Vehiculo;
import es.deusto.spq.jdo.Main;
import es.deusto.spq.types.GuiTest;
import es.deusto.spq.util.PreparedData;
import es.deusto.spq.gui.MainWindow;


import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

/**
 * Clase test Ventana Principal
 *
 */
@Category(GuiTest.class)
public class MainWindowTest {
	private JTextField txtName;
	private JTextField txtPrecio;
	private JTextArea txtDescription;
	private Vehiculo v;
	private int precio;
	private HttpServer server;
	private WebTarget appTarget;
	private WebTarget VehiculosTarget;
	private Vehiculo vehiculoA;
	private String selectedVehiculo;
	private DefaultListModel<Vehiculo> vList;
	private MainWindow afw;

	/**
	 * Metodo para construir objeto con sus atributos correspondientes.
	 *
	 */
	@Before
	public void setUp() throws Exception {
		v = new Vehiculo("", "", 0);
		txtName = new JTextField("Nombre 1");
		txtPrecio = new JTextField("Precio 1");
		txtDescription = new JTextArea("Descripcion 1");

		server = Main.startServer();
		Client client = ClientBuilder.newClient();
		appTarget = client.target("http://localhost:8080/myapp");
		VehiculosTarget = appTarget.path("vehiculos");

		GenericType<List<Vehiculo>> genericType = new GenericType<List<Vehiculo>>() {
		};
		VehiculosTarget.request(MediaType.APPLICATION_JSON).get(genericType);

		vList = new DefaultListModel<Vehiculo>();
		new PreparedData();
		afw = new MainWindow();

		vehiculoA = new Vehiculo("Opel Corsa", "Potencia de 100 caballos", 5);
		precio = Integer.parseInt(txtPrecio.toString());
		txtName.setText(vehiculoA.getName());
		txtPrecio.setText(vehiculoA.toString());
		txtDescription.setText(vehiculoA.getDescription());
	}
	/**
	 * TearDown Test
	 *
	 */
	@After
	public void tearDown() throws Exception {
		server.stop();
	}

	/**
	 * Test para añadir una pelicula a la BD
	 *
	 */
	// @Ignore
	@Test
	public void añadirPeliculaBD() {

		precio = Integer.parseInt(txtPrecio.toString());
		v.setName(txtName.getText());
		v.setPrice(5);
		v.setDescription(txtDescription.getText());

		afw.anadirVehiculoBd(txtName, txtPrecio, txtDescription);
		vList.addElement(v);
		selectedVehiculo = v.getName();
		afw.eliminarVehiculoBd(vList, selectedVehiculo);
	}

}
