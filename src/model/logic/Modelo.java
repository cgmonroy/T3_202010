package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

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

	public void primerosYUltimos()
	{
		Comparable<Comparendos>[] arreglos = copiarComparendos();

		shellsort(arreglos);
		Comparendos comparendo = null;
		int contador = 0;

		for (int i = 0; i < 10 || i + arreglos.length - 10 < arreglos.length; i++) {

			comparendo = (Comparendos) arreglos[i];
			contador ++;
			System.out.println("# de comparendo "+contador+ " " + comparendo.getOBJECTID() + " " + comparendo.getFECHA_HORA()+" " + comparendo.getINFRACCION() +" " + comparendo.getCLASE_VEHI() +" " + comparendo.getTIPO_SERVI() + " " + comparendo.getLOCALIDAD());
		}
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