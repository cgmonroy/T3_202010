package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.data_structures.DobleListaEncadenada;

import model.data_structures.InterfazLista;
import model.data_structures.Node;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {

	private DobleListaEncadenada<Comparendos> listComparendos= new DobleListaEncadenada<>();


	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return listComparendos.getSize();
	}

	public void loadComparendos (String comparendosFile)
	{
		JSONParser parser = new JSONParser();

		try {     
			Object obj = parser.parse(new FileReader(comparendosFile));

			JSONObject jsonObject =  (JSONObject) obj;
			JSONArray jsArray = (JSONArray) jsonObject.get("features");

			for(Object o: jsArray) {


				JSONObject comp = (JSONObject) o;	
				JSONObject properties =  (JSONObject) comp.get("properties");
				JSONObject geometry =  (JSONObject) comp.get("geometry");
				JSONArray coordinates = (JSONArray) geometry.get("coordinates");
				Comparendos comparendo = new Comparendos(String.valueOf(comp.get("type")), Integer.parseInt(String.valueOf(properties.get("OBJECTID"))), String.valueOf(properties.get("FECHA_HORA")), String.valueOf(properties.get("CLASE_VEHI")), String.valueOf(properties.get("TIPO_SERVI")), String.valueOf(properties.get("INFRACCION")), String.valueOf(properties.get("DES_INFRAC")), String.valueOf(properties.get("LOCALIDAD")), String.valueOf(geometry.get("type")), String.valueOf(coordinates));

				listComparendos.agregarAlFinal(comparendo);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e){
			e.printStackTrace();
		}
	}

	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public String buscarPorId(int OBJECTID)
	{	
		Iterator <Comparendos> iter = listComparendos.iterator();
		Comparendos comp = iter.next();
		Comparendos comparendo = null;

		while(iter.hasNext()) {

			if(comp.getOBJECTID()==OBJECTID)
			{
				comparendo=comp;
			}

			comp = iter.next();	

		}	
		return comparendo.getOBJECTID() + " " + comparendo.getFECHA_HORA()+" " + comparendo.getINFRACCION() +" " + comparendo.getCLASE_VEHI() +" " + comparendo.getTIPO_SERVI() + " " + comparendo.getLOCALIDAD();	
	}

	public Comparable[] copiarComparendos() 
	{		
		Comparable<Comparendos>[] arreglos = new Comparendos[listComparendos.getSize()];

		for (int i = 0; i < listComparendos.getSize(); i++) 
		{
			arreglos[i] = listComparendos.darElemento(i);

		}
		return arreglos;
	}

	public int tamanioCopia()
	{
		Comparable<Comparendos>[] arreglos = copiarComparendos();

		return arreglos.length;
	}

	public String retornoPrimero() {
		Comparendos comparendo =  listComparendos.darElemento(0);
		return comparendo.getOBJECTID() + " " + comparendo.getFECHA_HORA()+" " + comparendo.getINFRACCION() +" " + comparendo.getCLASE_VEHI() +" " + comparendo.getTIPO_SERVI() + " " + comparendo.getLOCALIDAD();	
	}

	public String retornoUltimo() {
		Comparendos comparendo =  listComparendos.darElemento(listComparendos.getSize()-1);
		return comparendo.getOBJECTID() + " " + comparendo.getFECHA_HORA()+" " + comparendo.getINFRACCION() +" " + comparendo.getCLASE_VEHI() +" " + comparendo.getTIPO_SERVI() + " " + comparendo.getLOCALIDAD();	
	}

	public void shellsort(Comparable<Comparendos> a[])
	{
		int j;
		for( int gap = a.length / 2; gap > 0; gap /= 2 )
		{
			for( int i = gap; i < a.length; i++ )
			{
				Comparable<Comparendos> tmp = a[ i ];
				for( j = i; j >= gap && tmp.compareTo( (Comparendos) a[ j - gap ] ) < 0; j -= gap )
				{
					a[ j ] = a[ j - gap ];
				}
				a[ j ] = tmp;
			}
		}
	}


	/** <Merge Sort 2>
	 * Merges two sorted portion of items array
	 * pre: items[start..mid] is sorted. items[mid + 1..end] sorted.
	 * start <= mid <= end                                  >
	 * post: items[start..end] is sorted.
	 */
	private void merge(Comparable<Comparendos> items[], int start, int mid, int end) {
		Comparable[] temp = new Comparable[items.length];
		int pos1 = start;
		int pos2 = mid + 1;
		int spot = start;

		while (!(pos1 > mid && pos2 > end)) {
			if ((pos1 > mid) || (pos2 <= end) && (items[pos2].compareTo((Comparendos) items[pos1]) > 0)) {
				temp[spot] = items[pos2];
				pos2 += 1;
			} else {
				temp[spot] = items[pos1];
				pos1 += 1;
			}
			spot += 1;
		}
		/* copy values from temp back to items */
		for (int i = start; i <= end; i++) {
			items[i] = temp[i];
		}
	}

	public void mergesort(Comparable<Comparendos> items[]) 
	{
		quickSort (items, 0, items.length-1);
	}
	/**
	 * Sorts items [start..end]
	 * pre: start > 0, end > 0
	 * post: items[start..end] is sorted low to high
	 */


	private void mergesort(Comparable<Comparendos> items[], int start, int end) 
	{
		if (start < end) {
			int mid = (start + end) / 2;
			mergesort(items, start, mid);
			mergesort(items, mid + 1, end);
			merge(items, start, mid, end);
		}
	}


	public void primerosYUltimos()
	{
		Comparable<Comparendos>[] arreglos = copiarComparendos();

		shellsort(arreglos);
		Comparendos comparendo = null;
		int contador = 0;

		for (int i = 0; i < arreglos.length; i++) {

			if(i<=10 || i >=arreglos.length - 9) {
				comparendo = (Comparendos) arreglos[i];
				contador ++;
				System.out.println("# de comparendo "+contador+ " " + comparendo.getOBJECTID() + " " + comparendo.getFECHA_HORA()+" " + comparendo.getINFRACCION() +" " + comparendo.getCLASE_VEHI() +" " + comparendo.getTIPO_SERVI() + " " + comparendo.getLOCALIDAD());
			}
		}
	}

	public void quickSort (Comparable<Comparendos> A[])

	{	
		quickSort (A, 0, A.length-1);

	}

	private void quickSort (Comparable<Comparendos> A[], int low, int high)

	{
		if(low < high)
		{
			int p = partition(A, low, high);
			quickSort(A, low, p-1);
			quickSort(A, p+1, high);
		}
	}

	private void swap (Comparable<Comparendos> A[], int index1, int index2)

	{
		Comparable<Comparendos> temp = A[index1];
		A[index1] = A[index2];
		A[index2] = temp;
	}

	private int getPivot (int low, int high)
	{
		Random rand = new Random();
		return rand.nextInt((high - low)+1)+low;
	}

	private int partition (Comparable<Comparendos> A[], int low, int high)

	{
		swap(A, low, getPivot(low, high));
		int border = low + 1;
		for(int i = border; i <= high; i++)
		{
			if (A[i].compareTo((Comparendos) A[low]) < 0)
			{
				swap (A, i, border++);
			}
		}
		swap (A, low, border-1);
		return border-1;
	}

	public String Lista()
	{
		Iterator <Comparendos> iter = listComparendos.iterator();
		Comparendos comp = iter.next();
		Comparendos comparendo = null;

		while(iter.hasNext()) {

			comparendo=comp;
			comp = iter.next();	
		}	
		return comparendo.getOBJECTID() + " " + comparendo.getFECHA_HORA()+" " + comparendo.getINFRACCION() +" " + comparendo.getCLASE_VEHI() +" " + comparendo.getTIPO_SERVI() + " " + comparendo.getLOCALIDAD();	

	}
}