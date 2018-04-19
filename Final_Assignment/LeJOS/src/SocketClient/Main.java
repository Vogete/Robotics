package SocketClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.UnknownHostException;

public class Main {
	static final int PORT = 6666;
	static final String IP = "10.0.1.1";
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		SocketClientThread socketClientThread = new SocketClientThread();
			
		socketClientThread.startConnection(IP, PORT);

	    while (true) {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        System.out.print("Enter command: ");
	        String s = br.readLine();

	        if (s.equals("exit")) {
	    	    socketClientThread.stopConnection();
	    	    return;
			}	        
	        
	        String response = socketClientThread.sendMessage(s);
	        System.out.println("Answer: " + response);
	        	    	
		} 
	    
	}

}
