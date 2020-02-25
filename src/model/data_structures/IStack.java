package model.data_structures;

public interface IStack<T> extends Iterable <T> {
	public boolean isEmpty();
	
	public int tamano();
	
	public void push (T t);
	
	public T pop();
}
