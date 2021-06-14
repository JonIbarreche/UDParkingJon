package es.deusto.spq.util;

import java.util.Calendar;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import es.deusto.spq.jdo.Parking;
import es.deusto.spq.jdo.Vehiculo;

public class PreparedData {
	public static PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

	public static PersistenceManager pm = pmf.getPersistenceManager();
	public static Transaction tx = pm.currentTransaction();
	
	public static Vehiculo vehiculoA = new Vehiculo("Opel Corsa", "1000 caballos de potencia", 5);
	public static Vehiculo vehiculoB = new Vehiculo("Volkswagen Passat", "2000 caballos de potencia", 6);
	public static Vehiculo vehiculoC = new Vehiculo("Aston Martin", "500 caballos de potencia", 9);
	public static Vehiculo vehiculoD = new Vehiculo("Hyundai", "800 caballos de potencia", 11);
	public static Vehiculo vehiculoE = new Vehiculo("Jaguar A2", "3000 caballos de potencia", 4);
	public static Vehiculo vehiculoF = new Vehiculo("Lamborguini Huracan", "5000 caballos de potencia", 6);
	public static Vehiculo vehiculoG = new Vehiculo("Opel Astra", "799 caballos de potencia", 3);
	
	
	public static Parking p1 = new Parking("Las Rozas");
	public static Parking p2 = new Parking("Majadahonda");
	public static Parking p3 = new Parking("Lezama");
	public static Parking p4 = new Parking("Deusto");

	/**
	 * Metodo para crear Vehiculos en la BD
	 *
	 */
	public static void crearVehiculo() {
	
		pm.makePersistent(vehiculoA);
		pm.makePersistent(vehiculoB);
		pm.makePersistent(vehiculoC);
		pm.makePersistent(vehiculoD);
		pm.makePersistent(vehiculoE);
		pm.makePersistent(vehiculoF);
		pm.makePersistent(vehiculoG);
		
	}
	/**
	 * Metodo para crear Parkings en la BD
	 *
	 */
	public static void crearParking() {
		pm.makePersistent(p1);
		pm.makePersistent(p2);
		pm.makePersistent(p3);
		pm.makePersistent(p4);
	}
	/**
	 * Metodo para iniciar PreparedData
	 *
	 */
	public static void main(String[] args) {

		try {
			tx.begin();

			crearVehiculo();
			crearParking();

			tx.commit();

		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	
}
