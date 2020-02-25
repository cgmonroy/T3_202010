package controller;

import java.util.Scanner;
import java.util.Stack;

import model.data_structures.Queue;
import model.logic.Comparendos;
import model.logic.Modelo;
import view.View;

public class Controller {

	/*
	 * 
	 */
	private Queue<Comparendos> listaComparendosQueue;
	private Stack<Comparendos> listaComparendosStack;

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
		listaComparendosQueue= new Queue<Comparendos>();
		listaComparendosStack= new Stack<Comparendos>();
		
		view = new View();
		modelo = new Modelo();
	}
	@SuppressWarnings("unused")
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
				modelo.loadComparendosQueue(ruta);
				System.out.println(modelo);
				System.out.println("Arreglo Dinamico creado");
				System.out.println("Numero actual de elementos " + modelo.darTamanoQueue() + "\n---------");						
				break;

			case 2:
				modelo = new Modelo(); 
				modelo.loadComparendosStack(ruta);
				System.out.println(modelo);
				System.out.println("Arreglo Dinamico creado");
				System.out.println("Numero actual de elementos " + modelo.darTamanoStack() + "\n---------");						
				break;

			case 3:
				System.out.println("--------- \nDar OBJECTID a buscar: ");
				dato = lector.nextInt();
				respuesta =  modelo.buscarPorIdQueue(dato) + "";
				if ( respuesta != null)
				{
					System.out.println("Dato encontrado: "+ respuesta);
				}
				else
				{
					System.out.println("Dato NO encontrado");
				}
				System.out.println("Numero actual de elementos " + modelo.darTamanoQueue() + "\n---------");						
				break;

			case 4:
				System.out.println("--------- \nDar OBJECTID a buscar: ");
				dato = lector.nextInt();
				respuesta =  modelo.buscarPorIdStack(dato) + "";
				if ( respuesta != null)
				{
					System.out.println("Dato encontrado: "+ respuesta);
				}
				else
				{
					System.out.println("Dato NO encontrado");
				}
				System.out.println("Numero actual de elementos " + modelo.darTamanoStack() + "\n---------");						
				break;

			case 5: 
				view.printMessage("--------- \nContenido del Arreglo: ");
				view.printModelo(modelo);
				view.printMessage("Numero actual de elementos " + modelo.darTamanoQueue() + "\n---------");						
				break;

			case 6: 
				view.printMessage("--------- \nContenido del Arreglo: ");
				view.printModelo(modelo);
				view.printMessage("Numero actual de elementos " + modelo.darTamanoStack() + "\n---------");						
				break;	

			case 7: 
				view.printMessage("--------- \n Hasta pronto !! \n---------"); 
				lector.close();
				fin = true;
				break;	

			default: 
				view.printMessage("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}

	}	
}
