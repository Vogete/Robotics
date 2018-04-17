import lejos.hardware.lcd.LCD;

public class CommandHandler {	
	
	
	public CommandHandler() {		
 
	}
	
	public void commandDetermination(String command) {
		MovementHandler movementHandler = new MovementHandler();		
		
		switch (command) {
		case "forward":			
			
			movementHandler.forward();
			break;
			
		case "stop":			
			movementHandler.stopMovement();		
			break;
			
		case "backward":
			movementHandler.backward();
			break;
			
		case "slower":
			movementHandler.reduceMotorSpeed();
			break;			
		default:
			break;
		}
	}
	

	
}
