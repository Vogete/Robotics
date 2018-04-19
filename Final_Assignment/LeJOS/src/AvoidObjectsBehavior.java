import lejos.hardware.motor.Motor;
import lejos.robotics.subsumption.Behavior;

public class AvoidObjectsBehavior implements Behavior {
	
	private boolean suppressed = false;
	private int deltaSpeed;

	@Override
	public boolean takeControl() {
		deltaSpeed = getCurrentSpeed();
		System.out.println("Delta: " + deltaSpeed);
		
		if(checkIfIsObjectAhead()) {
			System.out.println("is object ahead");
			return true;
		} else if (checkIfIsObjectBehind()) {
			System.out.println("is object behind");
			return true;
		}
		return false;
	}

	@Override
	public void action() {
		suppressed = false;
		while(!suppressed) {
			if(checkIfIsObjectAhead()) {
				
				AvoidObjectAhead();
				
			} else if(checkIfIsObjectBehind()) {
				AvoidObjectBehind();
			}
			else {
				suppressed = true;
			}
		}
	}

	@Override
	public void suppress() {
		suppressed = true;
	}
	
	private int getCurrentSpeed() {
		return Motor.A.getRotationSpeed() + Motor.B.getRotationSpeed();
	}
	
	private boolean checkIfIsObjectAhead() {
		deltaSpeed = getCurrentSpeed();
		return deltaSpeed > 0 && (Main.leftUltrasonicDistance < 0.25 || Main.rightUltrasonicDistance < 0.25);
	}
	
	private boolean checkIfIsObjectBehind() {
		deltaSpeed = getCurrentSpeed();
		return deltaSpeed < 0 && Main.irDistance < 25;
	}
	
	private void AvoidObjectAhead(){
		
	}
	
	private void AvoidObjectBehind(){
		MovementHandler mh = new MovementHandler();
		mh.stopMovement();
		
		if (!checkIfIsObjectAhead()) {
			mh.forward();	
		} else {
			//rotate in place until there´s clearance ahead or behind
		}
		
		while (checkIfIsObjectBehind()) {
			if (!checkIfIsObjectAhead()) {
				Thread.yield();
			}
		}
		
	}

}
