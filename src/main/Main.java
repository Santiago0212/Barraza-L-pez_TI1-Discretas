package main;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Scanner;
import model.Building;
import model.Person;

public class Main {
	Scanner sc=new Scanner(System.in);
	Building[] buildings;
	
	public static void main(String[] args) {
		Main inicio = new Main();
		inicio.inicio();
	}
	public void inicio() {
		
		boolean salir = true;
		do{
			System.out.println("Seleccione:");
			System.out.println("(1).Si deseas  ingresar datos");
			System.out.println("(0).Salir.");
			
			int respuesta=sc.nextInt();
			
			if(respuesta==1) {
				ingresar();
			}else if(respuesta==0) {
				System.out.println("Saliendo de la aplicacion...");
				salir=false;
			}else {
				System.out.println("Ingresa un numero valido...");
			}
		} while(salir);
		
	}
	public void ingresar() {
		int numEdi=sc.nextInt();
		
		String infoEdi="";
		String infoPer="";
		buildings=new Building[numEdi];
		sc.nextLine();
		for(int i=0;i<numEdi;i++) {
			Hashtable<Integer,Integer> offices = new Hashtable<Integer,Integer>();
			LinkedList<String>noIngresados=new LinkedList<String>();
			
			infoEdi=sc.nextLine();
			String[] infoEdificio = infoEdi.split(" ");
			
	        String nomEdi = infoEdificio[0];
	        int numPersonas = Integer.parseInt(infoEdificio[1]);
	        int numPisos = Integer.parseInt(infoEdificio[2]);
	        int numOficinasPorPiso =Integer.parseInt(infoEdificio[3]);
	        
	        Building edificio=new Building(nomEdi,numPisos,numOficinasPorPiso);
	        buildings[i]=edificio;
	        
	        int contador=0;
	        int contador2=numPisos-1;
	        
	        for(int p=0;p<numPisos;p++) {
	        	for(int o=numOficinasPorPiso-1;o>=0;o--) {
	        		offices.put(contador,contador2);
	        		contador++;
	        	}
	        	contador2--;
	        }
	       // System.out.println(offices);
	        for(int j=0;j<numPersonas;j++) {
				infoPer=sc.nextLine();
				String[] infoPersonas = infoPer.split(" ");
				
		        String nomPerso = infoPersonas[0];
		        int iniPerso = Integer.parseInt(infoPersonas[1]);
		        int finPerso = Integer.parseInt(infoPersonas[2]);
		        
		        String personaNoIngresada="";
		        
		        if(offices.containsKey(finPerso-1)) {
		        	int finalFloor=offices.get(finPerso-1);
			        buildings[i].addPerson(nomPerso,iniPerso,finPerso,finalFloor);
		        }else {
		        	personaNoIngresada=nomPerso+"  no puede ser incluido en las oficinas del edificio";
		        	noIngresados.add(personaNoIngresada);
		        	
		        }
	        }
	       
	       for(int j=0; j<10; j++) {
	    	   buildings[i].enterElevator();
	    	   buildings[i].moveElevator();
	    	   buildings[i].exitElevator();
	    	   
	       }
	       System.out.println("Movimientos edificio "+nomEdi);
	       System.out.println(buildings[i].getData());
	       for(int n=0;n<noIngresados.size();n++) {
	    	   System.out.println(noIngresados.get(n));
	    	   
	       }
	       
	       System.out.println("\n"+"Estado final de las oficinas en el edificio "+nomEdi+" :"+"\n");
	       String aux="[";
	       for(int o : buildings[i].getOffices().keySet()) {
	    	   if(!buildings[i].getOffices().get(o).getName().equalsIgnoreCase("")) {
	    		   aux+=buildings[i].getOffices().get(o).getName()+", ";   
	    	   }
	       }
	       aux=aux+"]";
	       System.out.println(aux);
		}
		
	}
}