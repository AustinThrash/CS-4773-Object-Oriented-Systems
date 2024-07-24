package states;

import HW5.Elevator.Elevator;

public class ThirdFloor implements State {
	Elevator elevator;
	
	public ThirdFloor(Elevator elevator) {
		this.elevator = elevator;
	}


	@Override
	public void pressButtonOne() {
		
		if(elevator.areDoorsOpen()) {
			elevator.setDoorState(false);
		}
		
		System.out.println("Going down...");
		elevator.setState(elevator.getFirstFloor(), "Floor 1");
		elevator.setDoorState(true);
	}

	@Override
	public void pressButtonTwo() {
		
		if(elevator.areDoorsOpen()) {
			elevator.setDoorState(false);
		}
		
		System.out.println("Going down...");
		elevator.setState(elevator.getSecondFloor(), "Floor 2");
		elevator.setDoorState(true);
	}

	@Override
	public void pressButtonThree() {
		
		if(elevator.areDoorsOpen()) {
			elevator.setDoorState(false);
		}
		
		System.out.println("Nothing happens");
		
	}
	
	

}
