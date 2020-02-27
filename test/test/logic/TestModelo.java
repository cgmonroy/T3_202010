package test.logic;

import static org.junit.Assert.*;

import model.logic.Comparendos;
import model.logic.Modelo;

import org.junit.Before;
import org.junit.Test;

public class TestModelo {

	public static final String ruta="./data/comparendos.geojson";
	int Capacidad = -1;
	int Contador = -1;

	private Modelo modelo;

	Comparable<Comparendos>[] arregloN = new Comparendos[20];
	Comparable<Comparendos>[] arregloOrdenado = arregloN;
	Comparendos comparador;

	//Setup datos orden ascendente
	public void setUp1() 
	{
		modelo = new Modelo();
		modelo.loadComparendos(ruta);

		arregloN = modelo.copiarComparendos();
		arregloOrdenado = arregloN;
		for(int i =0; i< arregloN.length;i++)
		{  
			comparador  = (Comparendos) arregloN[i];	
			comparador.setFECHA_HORA(Integer.toString(i));
			arregloN[i] = comparador;	
		}
	}

	//Setup orden datos aleatorios
	public void setUp2()
	{
		modelo = new Modelo();
		modelo.loadComparendos(ruta);
		arregloN = modelo.copiarComparendos();
		arregloOrdenado = arregloN;

		Capacidad = arregloN.length-1;
		while(Capacidad>=0)
		{
			Comparendos comparador  = (Comparendos) arregloN[Capacidad];	
			comparador.setFECHA_HORA(Double.toString(Math.random()*10));
			arregloN[Capacidad] = comparador;
			Capacidad --;
		}
	}
	// Setup datos descendente
	public void setUp3()
	{
		modelo = new Modelo();
		modelo.loadComparendos(ruta);
		arregloN = modelo.copiarComparendos();
		arregloOrdenado = arregloN;

		Contador = arregloN.length-1;

		for(int i =0; i< arregloN.length;i++)
		{

			Comparendos comparador  = (Comparendos) arregloN[Contador];	
			comparador.setFECHA_HORA(Integer.toString(i));
			arregloN[Contador] = comparador;
			Contador--;
		}
	}


	/////SHELSORT
	@Test
	public void arregloOrdenadoShellsort()
	{
		try
		{
			setUp1();
			modelo.shellsort(arregloOrdenado);	
			assertArrayEquals(arregloOrdenado, arregloN);

		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test
	public void arregloDescendenteShellsort()
	{
		try
		{
			setUp3();
			modelo.shellsort(arregloOrdenado);
			assertArrayEquals(arregloOrdenado, arregloN);
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test
	public void arregloDesordenadoShellsort()
	{
		try
		{
			setUp2();
			modelo.shellsort(arregloOrdenado);
			assertArrayEquals(arregloOrdenado, arregloN);

		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	////// mergesort
	@Test
	public void arregloOrdenadoMergesort()
	{
		try
		{
			setUp1();
			modelo.mergesort(arregloN);
			assertArrayEquals(arregloOrdenado, arregloN);
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test
	public void arregloDescendenteMergesort()
	{
		try
		{
			setUp3();

			modelo.mergesort(arregloN);
			assertArrayEquals(arregloOrdenado, arregloN);
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test
	public void arregloDesordenadoMergesort()
	{
		try
		{
			setUp2();

			modelo.mergesort(arregloN);
			assertArrayEquals(arregloOrdenado, arregloN);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/////// QUICKSORT
	@Test
	public void arregloOrdenadoQuicksort()
	{
		try
		{
			setUp1();
			modelo.quickSort(arregloN);
			assertArrayEquals(arregloOrdenado, arregloN);
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test
	public void arregloDescendenteQuicksort()
	{
		try
		{
			setUp3();

			modelo.quickSort(arregloN);
			assertArrayEquals(arregloOrdenado, arregloN);
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test
	public void arregloDesordenadoQuicksort()
	{
		try
		{
			setUp2();
			modelo.quickSort(arregloN);
			assertArrayEquals(arregloOrdenado, arregloN);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
