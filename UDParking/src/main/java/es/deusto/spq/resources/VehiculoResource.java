package es.deusto.spq.resources;


import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import es.deusto.spq.jdo.Vehiculo;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * Clase para obtener datos de los vehiculos de la base de datos
 */
@Path("vehiculos")
public class VehiculoResource {
	/**
	 * Metodo para obtener toda la lista de los vehiculos de la base de datos
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vehiculo> getProducts() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();

		Query<Vehiculo> q = pm.newQuery(Vehiculo.class);
		q.setOrdering("name desc");

		List<Vehiculo> vehiculos = q.executeList();

		pm.close();

		return vehiculos;
	}
	
}
