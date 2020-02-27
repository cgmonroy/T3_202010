package view;

import model.data_structures.DobleListaEncadenada;
import model.logic.Modelo;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("0. Carga de datos.");
			System.out.println("1. Crear arreglo de copia.");
			System.out.println("2. Ordenamiento ShellSort.");
			System.out.println("3. Ordenamiento MergeSort.");
			System.out.println("4. Ordenamiento QuickSort.");

		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printModelo(Modelo modelo)
		{
			// TODO implementar
			System.out.println(modelo.Lista());
			
		}
}
