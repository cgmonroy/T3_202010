package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Stack;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.data_structures.Queue;



/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {

	private Stack<Comparendos> listaComparendosStack= new Stack<>();
	private Queue<Comparendos> listaComparendosQueue= new Queue<>();

	////////START STACK///////////////////
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamanoStack()
	{
		return listaComparendosStack.size();
	}

	public void loadComparendosStack (String comparendosFile)
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

				listaComparendosStack.add(comparendo);
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
	public String buscarPorIdStack(int OBJECTID)
	{	
		Iterator <Comparendos> iter = listaComparendosStack.iterator();
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

	public String ListaStack()
	{
		Iterator <Comparendos> iter = listaComparendosStack.iterator();
		Comparendos comp = iter.next();
		Comparendos comparendo = null;

		while(iter.hasNext()) {

			comparendo=comp;
			comp = iter.next();	
		}	
		return comparendo.getOBJECTID() + " " + comparendo.getFECHA_HORA()+" " + comparendo.getINFRACCION() +" " + comparendo.getCLASE_VEHI() +" " + comparendo.getTIPO_SERVI() + " " + comparendo.getLOCALIDAD();		
	}
	////////// END STACK ///////////////////
	
	

	////////// STAR QUEUE /////////////////////
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamanoQueue()
	{
		return listaComparendosQueue.tamano();
	}

	public void loadComparendosQueue (String comparendosFile)
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

				listaComparendosQueue.enqueue(comparendo);;
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
	public String buscarPorIdQueue(int OBJECTID)
	{	
		Iterator <Comparendos> iter = listaComparendosQueue.iterator();
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

	public String ListaQueue()
	{
		Iterator <Comparendos> iter = listaComparendosQueue.iterator();
		Comparendos comp = iter.next();
		Comparendos comparendo = null;

		while(iter.hasNext()) {

			comparendo=comp;
			comp = iter.next();	
		}	
		return comparendo.getOBJECTID() + " " + comparendo.getFECHA_HORA()+" " + comparendo.getINFRACCION() +" " + comparendo.getCLASE_VEHI() +" " + comparendo.getTIPO_SERVI() + " " + comparendo.getLOCALIDAD();		
	}
	//////////////// END QUEUE /////////////////////////
}
