package estructuras;

public class NodoDE<T>{
	 private T dato;
	 private NodoDE<T> sig;
	 private NodoDE<T> ant;
	 
	 
	 public NodoDE() {
		dato =null;
		sig=null;
		ant=null;
	 }
	 public NodoDE(T valor) {
		 dato=valor;
		 sig=new NodoDE<T>();
		 ant=null;
	 }
	public T getDato() {
		return dato;
	}
	public void setDato(T dato) {
		this.dato = dato;
	}
	public NodoDE<T> getSig() {
		return sig;
	}
	public NodoDE<T> getAnt() {
		return ant;
	}
	public void setAnt(NodoDE<T> ant) {
		this.ant = ant;
	}
	public void setSig(NodoDE<T> sig) {
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