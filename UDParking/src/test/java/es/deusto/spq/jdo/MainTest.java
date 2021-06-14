/** \file 
 * Breve descripción de es.deusto.spq.jdo MainTest.java. Jun 13, 2021
 */
package es.deusto.spq.jdo;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;


public class MainTest {
	public final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	@Before
	public void setUp() throws Exception {
		new Main();
	}

	@After
	public void After() {

	}
	@Ignore
	@Test
	public void testMain() {
		try {
			Main.main(new String[0]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.log(Level.WARNING, "IOException", e);
		}
	}

}
