package estructuras;

public class ListaCSE<T> implements Lista<T>{
	private NodoSE<T> ini;
	private int size;
	
	public ListaCSE() {
		ini=new NodoSE<T>();
		ini.setSig(ini);
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
	
	public void add(T valor) {
		if(size==0) {
			ini.setDato(valor);
		}
		NodoSE<T> aux=ini;
		while(aux.getSig() != ini) {
			aux=aux.getSig();
		}
		NodoSE<T> nuevo= new NodoSE<T>(valor);
		aux.setSig(nuevo);
		nuevo.setSig(ini);
		size++;
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
				NodoSE<T> aux=ini;
				while(aux.getSig() != ini) {
					aux=aux.getSig();
				}
				ini =ini.getSig();
				aux.setSig(ini);
			}else {
				ant.setSig(act.getSig());
			}
			size--;
		}
		return res;
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
}
