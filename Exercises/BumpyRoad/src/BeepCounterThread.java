
public class BeepCounterThread extends Thread{
	public BeepCounterThread() {
		this.setDaemon(true);
	}
	
	public void run() {
		while(true) {
			//Wait 5 seconds before setting the counter to 0
			try { Thread.sleep(5000); } 
			catch (InterruptedException e) { e.printStackTrace();}
			
			synchronized(Main.countLockObject) {
				Main.beepCounter = 0;
			}
		}
	}
}
