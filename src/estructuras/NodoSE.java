package estructuras;

public class NodoSE<T>{
	 private T dato;
	 private NodoSE<T> sig;
	 
	 public NodoSE() {
		dato =null;
		sig=null;
	 }
	 public NodoSE(T valor) {
		 dato=valor;
		 sig=new NodoSE<T>();
	 }
	public T getDato() {
		return dato;
	}
	public void setDato(T dato) {
		this.dato = dato;
	}
	public NodoSE<T> getSig() {
		return sig;
	}
	public void setSig(NodoSE<T> sig) {
		this.sig = sig;
	}
	public boolean isEmpty() {
		boolean res=false;
		if(dato==null) {
			res=true;
		}
		return res;
		
	}
	 
 
}
