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
		boolean fin = false;
		Integer dato = null;
		Object datoS = null;
		String respuesta = "";


		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 1:
				modelo = new Modelo(); 
				modelo.loadComparendos(ruta);
				System.out.println(modelo);
				System.out.println("Arreglo Dinamico creado");
				System.out.println("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
				break;

			case 2:
				System.out.println("--------- \nDar OBJECTID a buscar: ");
				dato = lector.nextInt();
				respuesta =  modelo.buscarPorId(dato) + "";
				if ( respuesta != null)
				{
					System.out.println("Dato encontrado: "+ respuesta);
				}
				else
				{
					System.out.println("Dato NO encontrado");
				}
				System.out.println("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
				break;


			default: 
				System.out.println("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}
	}
}	