package estructuras;

public interface Lista<T> {
	public void add(T dato);
	public int size();
	public T remove(int pos);
	public boolean remove(T dato);
	public int indexOf(T dato);

}
