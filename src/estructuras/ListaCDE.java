package estructuras;

public class ListaCDE<T> implements Lista<T>{
	private NodoDE<T> ini;
	private int size;
	
	public ListaCDE() {
		ini=new NodoDE<T>();
		ini.setSig(ini);
		ini.setAnt(ini);
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

	public void add(T valor) {
		if(size==0) {
			ini.setDato(valor);
		}
		NodoDE<T> aux=ini;
		while(aux.getSig() != ini) {
			aux=aux.getSig();
		}
		NodoDE<T> nuevo= new NodoDE<T>(valor);
		aux.setSig(nuevo);
		nuevo.setAnt(aux);
		nuevo.setSig(ini);
		ini.setAnt(nuevo);
		size++;
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
	
	public T remove(int pos) {
		T res=null;
		if(pos>=0 && pos<size) {
			NodoDE<T> act = ini;
			boolean salir=false;
			while(pos>0) {
				act=act.getSig();
				pos--;
				salir=true;
			}
			res=act.getDato();
			
			NodoDE<T> ant=act.getAnt();
			NodoDE<T> sig=act.getSig();
			ant.setSig(sig);
			sig.setAnt(ant);
			if(!salir) {
				ini=sig;
				
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
