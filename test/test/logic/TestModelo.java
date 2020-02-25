package test.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.logic.Modelo;

public class TestModelo {
	
	private Modelo modelo;
	private static int CAPACIDAD=100;
	
	@Before
	public void setUp1() {
		for(int i =0; i< CAPACIDAD;i++){
			modelo.loadComparendosQueue(""+i);
		}
	}

	public void setUp2() {
		for(int i =0; i< CAPACIDAD;i++){
			modelo.loadComparendosStack(""+i);
		}
	}
	
	@Test
	public void testModelo() {
		assertTrue(modelo!=null);
		assertEquals(0, modelo.darTamanoQueue());  // Modelo con 0 elementos presentes.
	}

	@Test
	public void testDarTamano() {
		// TODO
	}

	@Test
	public void testAgregar() {
		// TODO Completar la prueba
	}

	@Test
	public void testBuscar() {
		setUp2();
		// TODO Completar la prueba
	}

	@Test
	public void testEliminar() {
		setUp2();
		// TODO Completar la prueba
		
	}
}
