package states;

import HW5.Elevator.Elevator;

public class SecondFloor implements State {
	Elevator elevator;
	
	public SecondFloor(Elevator elevator) {
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
		
		System.out.println("Nothing happens");
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
