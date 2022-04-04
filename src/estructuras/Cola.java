package estructuras;

public class Cola<T> {
	public ListaSE<T> cola;
	public Cola() {
		cola= new ListaSE<T>();
	}
	public T peek() {//te da lo de en frente pero no borra nada
		return cola.getIni().getDato();
	}
	public T poll() {
		return cola.remove(0);
	}
	public boolean isEmpty() {
		return cola.size()==0;
	}
	public void offer(T dato) {
		cola.add(dato);
		
	}
}
