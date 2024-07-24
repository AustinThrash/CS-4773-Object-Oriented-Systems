package HW5.Elevator;

import states.FirstFloor;
import states.SecondFloor;
import states.State;
import states.ThirdFloor;

public class Elevator {
	
	Boolean isOpen;
	State firstFloor;
	State secondFloor;
	State thirdFloor;
	
	State state;
	
	String currFloor;
	
	private String welcomeMSG = "*ding* The elevator arrives at ";
	
	public Elevator() {
		firstFloor = new FirstFloor(this);
		secondFloor = new SecondFloor(this);
		thirdFloor = new ThirdFloor(this);
		isOpen = true;
		state = firstFloor;
		
	}
	
	public Boolean areDoorsOpen() {
		return isOpen;
	}
	public void setDoorState(Boolean doorState) {
		isOpen = doorState;
		if(isOpen) {
			System.out.println("Doors are open");
		} else {
			System.out.println("Doors are closed");
		}
	}
	
	
	public void setState(State currentState, String floorName) {
		String message = welcomeMSG + floorName;
		this.state = currentState;
		System.out.println(message);
	}
	
	public State getFirstFloor() {
		return firstFloor;
	}
	public State getSecondFloor() {
		return secondFloor;
	}
	public State getThirdFloor() {
		return thirdFloor;
	}
	
	public void pressButtonOne() {
		System.out.println("1 pressed");
		state.pressButtonOne();
	}
	public void pressButtonTwo() {
		System.out.println("2 pressed");
		state.pressButtonTwo();
	}
	public void pressButtonThree() {
		System.out.println("3 pressed");
		state.pressButtonThree();
	}
	
}
