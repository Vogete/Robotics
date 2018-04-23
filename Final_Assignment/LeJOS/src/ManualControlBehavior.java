import lejos.hardware.lcd.LCD;
import lejos.robotics.subsumption.Behavior;

public class ManualControlBehavior implements Behavior {

	private boolean suppressed = false;
	
	@Override
	public boolean takeControl() {
		return true;
	}

	@Override
	public void action() {
    	suppressed = false;
		String clientCommandCopy = Main.clientCommand;		
		CommandHandler.commandDetermination(clientCommandCopy);
		
    	while(!suppressed) {
    		// System.out.println("manual cmd received");
    		if(!clientCommandCopy.equals(Main.clientCommand)) {
    			clientCommandCopy = Main.clientCommand;
//    			System.out.println(clientCommandCopy);
//    			System.out.println(Main.clientCommand);
    			CommandHandler.commandDetermination(clientCommandCopy);
    		} else {
    			Thread.yield();
    		}
    	}
    			
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
