package estructuras;

public class ListaDE<T> implements Lista<T>{
	private NodoDE<T> ini;
	private int size;
	
	public ListaDE() {
		ini=new NodoDE<T>();
		size=0;
	}
	public NodoDE<T> getIni() {
		return ini;
	}

	public void setIni(NodoDE<T> ini) {
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
	public T get(int pos,NodoDE<T> ac) {
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
		NodoDE<T> aux=ini;
		while(!aux.isEmpty()) {
			aux=aux.getSig();
		}
		aux.setDato(valor);
		aux.setSig(new NodoDE<T>());
		NodoDE<T> sig=aux.getSig();
		sig.setAnt(aux);
		size++;
	}
	public T remove(int pos) {
		T res=null;
		if(pos>=0 && pos<size) {
			NodoDE<T> act = ini;
			while(pos>0) {
				act=act.getSig();
				pos--;
			}
			res=act.getDato();
			if(act.getAnt()==null) {
				ini =ini.getSig();
			}else {
				NodoDE<T> ant=act.getAnt();
				NodoDE<T> sig=act.getSig();
				ant.setSig(sig);
				sig.setAnt(ant);
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
			NodoDE<T> act=ini;
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
