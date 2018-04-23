import lejos.hardware.motor.Motor;
import lejos.robotics.subsumption.Behavior;

public class LineFollowBehavior implements Behavior {
	
	private boolean suppressed = false;
	private boolean foundLine = false;
	
	@Override
	public boolean takeControl() {
		if (Main.searchForLine) {
			return true;
		}
		return false;
	}

	@Override
	public void action() {
		suppressed = false;
		foundLine = false;
		
		MovementHandler mh = new MovementHandler();		
		mh.endTurn();			
		
		while (!suppressed) {
		
			if (Main.lightSensorValue < 0.09) {
				if (!foundLine) {					
					mh.endTurn();
					Motor.A.setSpeed((mh.speed/2));
					Motor.B.setSpeed((mh.speed/2)/2);
					mh.forward();
										
					foundLine = true;
				}
			} else {
				if (foundLine) {
					mh.endTurn();
					Motor.A.setSpeed((mh.speed/2)/2);
					Motor.B.setSpeed(mh.speed/2);
					mh.forward();
					foundLine = false;					
				}
			}
			
			if (!Main.searchForLine) {
				suppressed = true;
			}
			
		}
		
	}

	@Override
	public void suppress() { 
		suppressed = true;
	}

}
