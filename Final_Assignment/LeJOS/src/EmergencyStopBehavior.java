import lejos.robotics.subsumption.Behavior;

public class EmergencyStopBehavior implements Behavior {
	
	private boolean suppressed = false;
	
	@Override
	public boolean takeControl() {
		if (Main.clientCommand.equals("emgstop")) {
			return true;
		}
		return false;
	}

	@Override
	public void action() {
		suppressed = true;
		// TODO Auto-generated method stub
		MovementHandler mh = new MovementHandler();
		mh.stopMovement();
		Main.searchForLine = false;
		
		// System.out.println("emergency stop");
		while (!suppressed) {
			if (Main.leftMotorCurrentSpeed == 0 && Main.rightMotorCurrentSpeed == 0) {
				suppressed = true;
			}
			else {
				mh.stopMovement();
				Thread.yield();
			}
		}
		
		Main.clientCommand = "";
		mh.resetMotorSpeeds();
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
