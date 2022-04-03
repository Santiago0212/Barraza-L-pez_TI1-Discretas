package model;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Stack;

public class Building {
	private String name;
	private int floorsNumber;
	private int officesPerFloor;
	
	LinkedList<Person> waitingPeople = new LinkedList<Person>();
	Hashtable<Integer,Person> offices = new Hashtable<Integer,Person>();
	
	Elevator elevator;
	
	public Building(String name, int floorsNumber, int officesPerFloor) {
		this.name = name;
		this.floorsNumber = floorsNumber;
		this.officesPerFloor = officesPerFloor;
		
		int totalOffices = this.floorsNumber*this.officesPerFloor;
		
		for(int i = 0; i<totalOffices; i++) {
			offices.put(i, new Person("",0,0,this.officesPerFloor));
		}
		
		this.elevator = new Elevator(0, 1);
	}
	
	public void addPerson(String name, int initialFloor, int officeWantToGo) {
		waitingPeople.add(new Person(name, initialFloor-1, officeWantToGo-1, this.officesPerFloor));
	}
	
	public void enterElevator() {
		LinkedList<Person> peopleEntered = new LinkedList<Person>();
		for(Person p : waitingPeople) {
			if(offices.get(p.getOfficeWantToGo()).getName().equalsIgnoreCase("")) {
				if(p.getCurrentFloor()==elevator.getPos()) {
					elevator.enter(p);
					peopleEntered.add(p);
				}
			}
		}
		
		for(Person p : peopleEntered) {
			waitingPeople.remove(p);
		}
		peopleEntered.clear();	
	}
	
	public void moveElevator() {
 
		int floorToGo;
		if(elevator.getStatus()==0) {
			floorToGo = getFloorToGoDown();
			
			if(floorToGo==-1) {
				elevator.switchStatus();
			} else {
				while(elevator.getPos()>floorToGo) {
					elevator.goDown();
				}
			}
		}
		if(elevator.getStatus()==1) {
			floorToGo = getFloorToGoUp();
			
			if(floorToGo==-1) {
				elevator.switchStatus();
				floorToGo = getFloorToGoDown();
				
				while(elevator.getPos()>floorToGo) {
					elevator.goDown();
				}
				
			} else {
				while(elevator.getPos()<floorToGo) {
					elevator.goUp();
				}
			}
		}
	}
	
	public void exitElevator() {
		Stack<Person> auxPeopleInsideElevator = (Stack<Person>) elevator.getPeopleInside().clone();
		
		while(!auxPeopleInsideElevator.isEmpty()) {
			Person p = auxPeopleInsideElevator.pop();
			if(p.getFinalFloor()==elevator.getPos()) {
				offices.put(p.getOfficeWantToGo(), p);
				elevator.exit(p);
			}
		}
	}
	
	public int getFloorToGoUp() {
		int menor = 1000000;
		int floorToGo = -1;
		Stack<Person> auxPeopleInsideElevator = (Stack<Person>) elevator.getPeopleInside().clone();	
		
		while (!auxPeopleInsideElevator.isEmpty()) {
			Person p = auxPeopleInsideElevator.pop();
			if(p.getFinalFloor()>elevator.getPos()) {
				int difference = p.getFinalFloor() - elevator.getPos();
				if(difference<menor) {
					menor = difference;
					floorToGo = p.getFinalFloor();
				}
			}	
		}
		
		LinkedList<Person> auxWaitingPeople = new LinkedList<Person>();
		auxWaitingPeople = waitingPeople;
		
		for(Person p : auxWaitingPeople) {
			if(p.getFinalFloor()>elevator.getPos()) {
				int difference = p.getFinalFloor() - elevator.getPos();
				if(difference<menor) {
					menor = difference;
					floorToGo = p.getFinalFloor();
				}
			}	
		}
		
		return floorToGo;
	}
	
	public int getFloorToGoDown() {
		int menor = 1000000;
		int floorToGo = -1;
		
		Stack<Person> auxPeopleInsideElevator = (Stack<Person>) elevator.getPeopleInside().clone();	
		
		while (!auxPeopleInsideElevator.isEmpty()) {
			Person p = auxPeopleInsideElevator.pop();
			if(p.getFinalFloor()<elevator.getPos()) {
				int difference = elevator.getPos() - p.getFinalFloor();
				if(difference<menor) {
					menor = difference;
					floorToGo = p.getFinalFloor();
				}
			}	
		}
		
		LinkedList<Person> auxWaitingPeople = new LinkedList<Person>();
		auxWaitingPeople = waitingPeople;
		
		for(Person p : auxWaitingPeople) {
			if(p.getFinalFloor()<elevator.getPos()) {
				int difference = elevator.getPos() - p.getFinalFloor();
				if(difference<menor) {
					menor = difference;
					floorToGo = p.getFinalFloor();
				}
			}	
		}
		
		return floorToGo;
	}
	
	public String getData() {
		String data = "";
		
		
		data += "\n\nOffices:\n\n";
		
		for(Integer i : offices.keySet()) {
			data += offices.get(i).getName()+" va a la oficina "+((i-6)*-1)+"\n";
		}
		
		return data;
	}
	
}
