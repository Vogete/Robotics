import lejos.hardware.lcd.LCD;

public class CommandHandler {

	public static void commandDetermination(String command) {
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

		case "left":
			movementHandler.turnLeft();
			break;
			
		case "right":
			movementHandler.turnRight();
			break;
			
		case "endturn":
			movementHandler.endTurn();
			break;
			
		case "linefollow":
			Main.searchForLine = true;
			break;

		default:
			break;
		}
	}

}
