package estructuras;

public class Stack<T> {
	private NodoSE<T> tope;
	
	public Stack() {
		tope=null;
	}
	
	public boolean isEmpty() {
		return tope==null;
	}
	
	public void push(T dato) {
		if(tope==null) {
			tope=new NodoSE<T>(dato);
		}else {
			NodoSE<T> nuevo=new NodoSE<T>(dato);
			nuevo.setSig(tope);
			tope=nuevo;
		}
	}
	
	public T pop() {
		T res=null;
		if(tope != null) {
			res=tope.getDato();
			tope=tope.getSig();
		}
		return res;
	}
	
	public T peek() {
		T res=null;
		if(tope!=null) {
			res=tope.getDato();
		}
		return res;
	}

}
