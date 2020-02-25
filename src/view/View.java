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
			System.out.println("1. Cargar comparendos");
			System.out.println("2. Buscar comparendos por OBJECTID");
			
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
