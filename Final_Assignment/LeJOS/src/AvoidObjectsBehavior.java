import lejos.hardware.motor.Motor;
import lejos.robotics.subsumption.Behavior;

public class AvoidObjectsBehavior implements Behavior {
	
	private boolean suppressed = false;
	private MovementHandler mh;
	
	@Override
	public boolean takeControl() {
		if(checkIfIsObjectAhead()) {
			// System.out.println("is object ahead");
			return true;
		} else if (checkIfIsObjectBehind()) {
			//System.out.println("is object behind");
			return true;
		}
		return false;
	}

	@Override
	public void action() {
		mh = new MovementHandler();
		
		suppressed = false;
		while(!suppressed) {
			mh.resetMotorSpeeds();
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
	
	private boolean checkIfLeftUltrasonicClose() {
		return Main.leftUltrasonicDistance <= 0.15;
	}

	private boolean checkIfRIghtUltrasonicClose() {
		return Main.rightUltrasonicDistance <= 0.15;
	}
	
	private boolean checkIfIRSensorClose() {
		return Main.irDistance < 25 ;
	}

	private boolean checkIfIsObjectAhead() {		
		boolean goingForward = Main.movementDirection.equals("F") || Main.movementDirection.equals("FL") || Main.movementDirection.equals("FR");
		if (goingForward) {
			return (checkIfLeftUltrasonicClose() || checkIfRIghtUltrasonicClose());			
		}
		return false;
	}
	
	private boolean checkIfIsObjectBehind() {		
		boolean goingBack = Main.movementDirection.equals("B") || Main.movementDirection.equals("BL") || Main.movementDirection.equals("BR"); 
		if ( goingBack ) {
			return checkIfIRSensorClose();	
		}
		return false;
	}
	
	private void AvoidObjectAhead(){
		mh.stopMovement();		
		
		if (checkIfLeftUltrasonicClose() && !checkIfRIghtUltrasonicClose()) {
//			mh.turnRight();
			mh.rotateRight();
		} else if (!checkIfLeftUltrasonicClose() && checkIfRIghtUltrasonicClose()) {
//			mh.turnLeft();
			mh.rotateLeft();
		} else {
			if (!checkIfIsObjectBehind()) {
				mh.backward();
			} else {
				mh.rotateLeft();
				while ( (checkIfLeftUltrasonicClose() || checkIfRIghtUltrasonicClose()) && checkIfIsObjectBehind() ) {
					Thread.yield();
				}
			}

		}
		
		while (checkIfLeftUltrasonicClose() || checkIfRIghtUltrasonicClose()) {
			Thread.yield();
		}
		
	}
	
	private void AvoidObjectBehind(){
		mh.stopMovement();		
		
		if (!checkIfIsObjectAhead()) {
			mh.forward();
		} else {
			mh.rotateLeft();
			while (checkIfIsObjectAhead() && checkIfIsObjectBehind()) {
				Thread.yield();
			}
		}
		
		while (checkIfIsObjectBehind()) {
			if (!checkIfIsObjectAhead()) {
				Thread.yield();
			}
		}
		
	}

}
