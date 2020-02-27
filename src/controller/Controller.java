package controller;

import java.io.FileReader;

import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import model.data_structures.DobleListaEncadenada;
import model.logic.Comparendos;
import model.logic.Modelo;
import view.View;

public class Controller {

	/*
	 * 
	 */
	private DobleListaEncadenada<Comparendos> listaComparendos;

	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;

	private Comparendos comparendo;

	public static final String ruta="./data/comparendos.geojson";
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller()
	{
		listaComparendos= new DobleListaEncadenada<Comparendos>();
		view = new View();
		modelo = new Modelo();
	}

	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		Comparable<Comparendos>[] arreglos = new Comparendos[listaComparendos.getSize()];
		boolean fin = false;
		Integer dato = null;
		Object datoS = null;
		String respuesta = "";


		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 0:
				modelo = new Modelo(); 
				modelo.loadComparendos(ruta);
				System.out.println(modelo);
				System.out.println("Se han cargado los datos");
				System.out.println("Numero actual de elementos " + modelo.darTamano() + "\n---------");	
				System.out.println("Primer Elemento: " + modelo.retornoPrimero() + "\n---------");		
				System.out.println("Ultimo Elemento: " + modelo.retornoUltimo() + "\n---------");
				
				break;

			case 1:
				modelo.copiarComparendos();
				arreglos = modelo.copiarComparendos();
				System.out.println("Se creo el arreglo copia");
				System.out.println("Numero de comparendos copia: " + modelo.tamanioCopia());
				break;
				
			case 2:
				long tiempoI = System.nanoTime();
				modelo.shellsort(arreglos);
				long tiempoF = System.nanoTime();
				double demora = (tiempoF - tiempoI)/ 1e6;
				modelo.primerosYUltimos();
				System.out.println("TIEMPO DEMORA SHELLSORT: "+demora+" Micro Segundos");
				
				break;
			case 3:
				long tiempoIN = System.nanoTime();
				modelo.mergesort(arreglos);
				long tiempoFIN = System.nanoTime();
				double demoraM = (tiempoFIN - tiempoIN)/ 1e6;
				modelo.primerosYUltimos();
				System.out.println("TIEMPO DEMORA MERGESORT: "+demoraM+" Micro Segundos");
				
				break;
				
			case 4:
				long tiempoINI = System.nanoTime();
				modelo.quickSort(arreglos);
				long tiempoFINAL = System.nanoTime();
				double demoraMI = (tiempoFINAL - tiempoINI)/ 1e6;
				modelo.primerosYUltimos();
				System.out.println("TIEMPO DEMORA QUICKSORT: "+demoraMI+" Micro Segundos");
				
				break;
			default: 
				System.out.println("--------- \n Opcion Invalida !! \n---------");
				break;
			
			}
		}
	}
}	