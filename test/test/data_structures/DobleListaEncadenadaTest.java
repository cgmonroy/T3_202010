package test.data_structures;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.data_structures.DobleListaEncadenada;

public class DobleListaEncadenadaTest 
{
	@Test
	public void test01() {
		DobleListaEncadenada list = new DobleListaEncadenada();
		
		list.agregarAlFinal(10); list.agregarAlFinal(5); list.agregarAlFinal(7);
		list.agregarAlFinal(1); list.agregarAlFinal(8);
		
		// expect [10 5 7 1 8]
        int m = list.getSize();
		assertEquals(5, m);
	}

	@Test
	public void test02() {
		DobleListaEncadenada list = new DobleListaEncadenada();
		
		list.agregarAlFinal(10); list.agregarAlFinal(5); list.agregarAlFinal(7);
		list.agregarAlFinal(1); list.agregarAlFinal(8);
		
		list.eliminar(0);

		 int m = list.getSize();
			assertEquals(4, m);
	}
}
