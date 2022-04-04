package estructuras;

public class ListaSE<T> implements Lista<T>{
	private NodoSE<T> ini;
	private int size;
	
	public ListaSE() {
		ini=new NodoSE<T>();
		size=0;
	}
	
	
	
	public NodoSE<T> getIni() {
		return ini;
	}



	public void setIni(NodoSE<T> ini) {
		this.ini = ini;
	}



	public int getSize() {
		return size;
	}



	public void setSize(int size) {
		this.size = size;
	}



	public T get(int pos) {
		T res=get(pos,ini);
		return res;
	}
	public T get(int pos,NodoSE<T> ac) {
		if(pos<size && pos>=0) {
			if(pos==0) {
				return ac.getDato();
			}else {
				return get(pos-1,ac.getSig());
			}
		}else{
			return null;
		}	
	}
	
	public T remove(int pos) {
		T res=null;
		if(pos>=0 && pos<size) {
			NodoSE<T> ant=null;
			NodoSE<T> act = ini;
			while(pos>0) {
				ant = act;
				act=act.getSig();
				pos--;
			}
			res=act.getDato();
			if(ant==null) {
				ini =ini.getSig();
			}else {
				ant.setSig(act.getSig());
			}
			size--;
		}
		return res;
	}
	
	public void add(T valor) {
		add(valor,ini);
	}
	
	public void add(T valor, NodoSE<T> ac) {
		if(ac.isEmpty()) {
			ac.setDato(valor);
			ac.setSig(new NodoSE<T>());
			size++;
		}else {
			add(valor,ac.getSig());
		}
	}
	
	public boolean remove(T dato) {
		boolean res=false;
		int index=indexOf(dato);
		if(index>=0) {
			remove(index);
			res=true;
		}
		return res;
	}
	
	public int indexOf(T dato) {
		int pos=-1;
		if (ini.isEmpty()) {
			NodoSE<T> act=ini;
			pos=0;
			while(pos<size && !act.getDato().equals(dato)) {
				act=act.getSig();
				pos++;
			}
			if(pos==size) {
				pos=-1;
			}
		}
		return pos;
	}
	
	public int size() {
		return size;
	}
	
	 public void add(int posicion, T valor){
	        if(posicion>=0 && posicion<=size){
	            NodoSE<T> nuevo = new NodoSE<T>();
	            nuevo.setDato(null);
	            if(posicion == 0){
	                nuevo.setSig(ini);
	                ini = nuevo;
	            }
	            else{
	                if(posicion == size){
	                	NodoSE<T> aux = ini;
	                    while(aux.getSig() != null){
	                        aux = aux.getSig();
	                    }
	                    aux.setSig(nuevo);              
	                }
	                else{
	                	NodoSE<T> aux = ini;
	                    for (int i = 0; i < (posicion-1); i++) {
	                        aux = aux.getSig();
	                    }
	                    NodoSE<T> siguiente = aux.getSig();
	                    aux.setSig(nuevo);
	                    nuevo.setSig(siguiente);
	                }
	            }
	            size++;
	        }
	    }
}
