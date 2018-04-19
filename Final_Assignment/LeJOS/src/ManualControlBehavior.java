import lejos.hardware.lcd.LCD;
import lejos.robotics.subsumption.Behavior;

public class ManualControlBehavior implements Behavior {

	private boolean suppressed = false;
	
	@Override
	public boolean takeControl() {
		LCD.drawString("Cmd:" + Main.clientCommand, 0, 0);
		if(Main.clientCommand != null) {
			return true;
		}
		return false;
	}

	@Override
	public void action() {
    	suppressed = false;
		String clientCommandCopy = Main.clientCommand;
    	while(!suppressed) {
    		if(!clientCommandCopy.equals(Main.clientCommand)) {
    			clientCommandCopy = Main.clientCommand;
    			CommandHandler.commandDetermination(Main.clientCommand);
    		} else {
    			Thread.yield();
    		}
    	}
    	// ????
		CommandHandler.commandDetermination("stop");
		
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
