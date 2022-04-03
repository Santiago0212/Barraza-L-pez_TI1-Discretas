package model;

import java.util.Stack;

public class Elevator {
	private Stack<Person> peopleInside;
	private int pos;
	private int status;
	
	public Elevator(int pos, int status) {
		this.pos = pos;
		this.status = status;
		this.peopleInside = new Stack<Person>();
	}
	
	public Stack<Person> getPeopleInside() {
		return this.peopleInside;
	}
	public void setPeopleInside(Stack<Person> peopleInside) {
		this.peopleInside = peopleInside;
	}
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public void enter(Person p) {
		this.peopleInside.push(p);
		System.out.println("adding... "+p.getName());
	}
	
	public void exit(Person p) {
		Stack<Person> auxInsidePeople = new Stack<Person>();
		
		while(!peopleInside.isEmpty()) {
			Person personToExit = peopleInside.pop();
			if(!personToExit.equals(p)) {
				auxInsidePeople.push(p);
			}
		}
		while(!auxInsidePeople.isEmpty()) {
			peopleInside.push(auxInsidePeople.pop());
		}
		
	}
	
	public void goUp() {
		this.pos++;
		
		Stack<Person> auxInsidePeople = new Stack<Person>();
		
		while(!peopleInside.isEmpty()) {
			auxInsidePeople.push(peopleInside.pop());
		}
		while(!auxInsidePeople.isEmpty()) {
			Person addingPerson = auxInsidePeople.pop();
			addingPerson.goUp();
			peopleInside.push(addingPerson);
		}
		
	}
	
	public void goDown() {
		this.pos--;
		
		Stack<Person> auxInsidePeople = new Stack<Person>();
		
		while(!peopleInside.isEmpty()) {
			auxInsidePeople.push(peopleInside.pop());
		}
		while(!auxInsidePeople.isEmpty()) {
			Person addingPerson = auxInsidePeople.pop();
			addingPerson.goDown();
			peopleInside.push(addingPerson);
		}
		
	}
	
	public void switchStatus() {
		if(this.status==0) {
			this.status = 1;
		} else if(this.status==1){
			this.status = 0;
		}
	}
	
}
