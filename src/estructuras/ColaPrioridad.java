package estructuras;

public class ColaPrioridad<T extends Comparable> extends Cola{
	
	public void offer(T dato) {
		if(cola.size()==0) {
			cola.add(dato);
		}else {
			boolean salir=false;
			for(int i=0;i<cola.size() && !salir;i++) {
				T actual=(T) cola.get(i);
				if(dato.compareTo(actual)==1) {
					cola.add(i,dato);
					salir=true;
				}
			}
			if(!salir) {
				cola.add(dato);
			}
		}
	}

}
