package PCEchoServer;

import java.io.IOException;

public class Main {	
	static final int PORT = 6666;
	
	static SocketServerThread socketServerThread;
	
	public static void main(String[] args) throws IOException {
		socketServerThread = new SocketServerThread();		
		socketServerThread.start();
		

	}

}
