package states;

import HW5.Elevator.Elevator;

public class FirstFloor implements State {
	Elevator elevator;
	
	public FirstFloor(Elevator elevator) {
		this.elevator = elevator;
	}
	
	@Override
	public void pressButtonOne() {
		
		if(elevator.areDoorsOpen()) {
			elevator.setDoorState(false);
		}
		
		System.out.println("Nothing Happens");
	}

	@Override
	public void pressButtonTwo() {
		
		if(elevator.areDoorsOpen()) {
			elevator.setDoorState(false);
		}
		
		System.out.println("Going up...");
		elevator.setState(elevator.getSecondFloor(), "Floor 2");
		elevator.setDoorState(true);
	}

	@Override
	public void pressButtonThree() {
		
		if(elevator.areDoorsOpen()) {
			elevator.setDoorState(false);
		}
		
		System.out.println("Going up...");
		elevator.setState(elevator.getThirdFloor(), "Floor 3");
		elevator.setDoorState(true);
		
	}
	
	
}
