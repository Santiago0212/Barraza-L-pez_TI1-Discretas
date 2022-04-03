package main;

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
			System.out.println("(2).Si deseas consultar datos");
			System.out.println("(0).Salir.");
			
			int respuesta=sc.nextInt();
			
			if(respuesta==1) {
				ingresar();
			}else if(respuesta==2) {
				consultar();
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
			
			infoEdi=sc.nextLine();
			String[] infoEdificio = infoEdi.split(" ");
			
	        String nomEdi = infoEdificio[0];
	        int numPersonas = Integer.parseInt(infoEdificio[1]);
	        int numPisos = Integer.parseInt(infoEdificio[2]);
	        int numOficinasPorPiso =Integer.parseInt(infoEdificio[3]);
	        
	        Building edificio=new Building(nomEdi,numPisos,numOficinasPorPiso);
	        buildings[i]=edificio;
	        
	        for(int j=0;j<numPersonas;j++) {
				infoPer=sc.nextLine();
				String[] infoPersonas = infoPer.split(" ");
				
		        String nomPerso = infoPersonas[0];
		        int iniPerso = Integer.parseInt(infoPersonas[1]);
		        int finPerso = Integer.parseInt(infoPersonas[2]);
		        
		        buildings[i].addPerson(nomPerso,iniPerso,finPerso);
		        
	        }
	       
	       for(int j=0; j<10; j++) {
	    	   buildings[i].enterElevator();
	    	   buildings[i].exitElevator();
	    	   buildings[i].moveElevator();
	       }
	       System.out.println(buildings[i].getData());
	        
	         
		}
		
	}
	public void consultar() {
		
	}
}