package PCEchoServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class SocketMessageThread extends Thread {
    protected Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    
    public SocketMessageThread(Socket clientSocket) {
    	this.socket = clientSocket;
        this.setDaemon(true);
    }

    public void run() {
    	
        try {
        	out = new PrintWriter(socket.getOutputStream(), true);
        	in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            return;
        }
        
        System.out.println("successful connect");
        
        String message;        
        
        while (true) {
            try {
                message = in.readLine();                
                if (message == null) {
                    in.close();
                    out.close();
                	socket.close();
                    return;
                } else {
                	System.out.println("Client's message: " + message);
                	out.println(message);  
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        
               
    }
    
}
