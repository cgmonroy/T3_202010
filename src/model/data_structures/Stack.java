package model.data_structures;

import java.util.EmptyStackException;
import java.util.Iterator;

public class Stack <T extends Comparable <T>> implements IStack <T>{
	//ATRIBUTOS
	private Nodo<T> topeStack;
	private int tamano = 0;

	//CONSTRUCTORES
	public Stack()
	{
		topeStack = null;
		tamano = 0;
	}

	public Stack(T objeto)
	{
		topeStack = new Nodo<T> (objeto);
		tamano = 1;
	}

	//METODOS
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			Nodo<T> actual = null;
			@Override
			public boolean hasNext() 
			{
				if (tamano == 0) 
					return false;
				if (actual == null) 
					return true;
				return actual.darSiguiente() != null; 
			}
			@Override
			public T next() {
				if (actual == null) 
					actual = topeStack;
				else 
					actual = actual.darSiguiente();
				return actual.darItem();
			}
		};
	}

	@Override
	public boolean isEmpty() {
		boolean respuesta;
		if(topeStack == null)
			respuesta = true;
		else
			respuesta = false;
		return respuesta;
	}

	@Override
	public int tamano() {
		return tamano;
	}

	@Override
	public void push(T t) {
		Nodo<T> nuevo = new Nodo<T>(t);
		if(topeStack == null)
			topeStack = nuevo;
		else
		{
			nuevo.cambiarSiguiente(topeStack);
			topeStack = nuevo;
		}
		tamano ++;
	}

	@Override
	public T pop() {
		if(topeStack == null)
		{
			throw new EmptyStackException();
		}
		T elemento = topeStack.darItem();
		Nodo<T> nuevoTopStack = topeStack.darSiguiente();
		topeStack.cambiarSiguiente(null);
		topeStack = nuevoTopStack;
		tamano--;
		return elemento;

	}
}