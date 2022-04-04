package model;


public class Person {
	
	private String name;
	private int initialFloor;
	private int currentFloor;
	private int officeWantToGo;
	private int finalFloor;
	
	public Person(String name, int initialFloor, int officeWantToGo, int officesPerFloor) {
		this.name = name;
		this.initialFloor = initialFloor;
		this.currentFloor = initialFloor;
		this.officeWantToGo = officeWantToGo;
		this.finalFloor = officesPerFloor;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getInitialFloor() {
		return this.initialFloor;
	}

	public void setInitialFloor(int initialFloor) {
		this.initialFloor = initialFloor;
	}

	public int getOfficeWantToGo() {
		return this.officeWantToGo;
	}

	public void setOfficeWantToGo(int officeWantToGo) {
		this.officeWantToGo = officeWantToGo;
	}
	
	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}

	public int getFinalFloor() {
		return this.finalFloor;
	}

	public void setFinalFloor(int finalFloor) {
		this.finalFloor = finalFloor;
	}
	
	public void goUp() {
		this.currentFloor++;
	}
	
	public void goDown() {
		this.currentFloor--;
	}
	
	public String toString() {
		return this.name;
	}
	
}
