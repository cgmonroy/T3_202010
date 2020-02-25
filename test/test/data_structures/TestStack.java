package test.data_structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.Queue;

public class TestStack <T extends Comparable<T>>{

	private Stack<T> pila;
	
	public static final String obj1 = "obj1";
	
	public static final String obj2 = "obj2";
	
	public static final String obj3 = "obj3";
	
	public static final String obj4 = "obj4";
	
	public static final String obj5 = "obj5";
	
	public void setUp() throws Exception 
 	{
        pila = new Stack<T>();
    }
 
    @SuppressWarnings("unchecked")
	private void pushObjectsInOrder(String... objects) 
    {
        for (String str : objects) 
        {
            pila.push((T) str);
        }
    }
	
    @SuppressWarnings("unchecked")
	@Test
	public void testPush()
	{
		try
		{
			setUp();
			pushObjectsInOrder(obj1, obj2, obj3, obj4);
			pila.push((T)obj5);
	        assertEquals(5, pila.size());
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testPop()
	{
		try
		{
			setUp();
			pushObjectsInOrder(obj1, obj2, obj3, obj4, obj5);
			pila.pop();
	        assertEquals(4, pila.size());
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
    
	@Test
	public void testTamanoCero()
	{
		try
		{
			setUp();
			assertEquals(0, pila.size());
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTamano()
	{
		try 
		{
			setUp();
			pushObjectsInOrder(obj1, obj2);
			assertEquals(2,pila.size());
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void testIsEmpty()
	{
		try
		{
			setUp();
			pila.isEmpty();
			assertTrue("Deberia estar vacio", true);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}