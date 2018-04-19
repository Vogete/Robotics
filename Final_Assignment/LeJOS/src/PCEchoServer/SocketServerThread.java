package PCEchoServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerThread extends Thread {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

	
	public SocketServerThread() throws IOException {
		this.startServer(Main.PORT);
		this.setDaemon(true);
	}
	
    public void startServer(int port) throws IOException {
    	serverSocket = new ServerSocket(port);
    	
    	String socketIpAddress = InetAddress.getLocalHost().getHostAddress();
    	String socketPort = String.valueOf(serverSocket.getLocalPort());
    	System.out.println("Server started at " + socketIpAddress + ":" + socketPort);
    	
    	while (true) {    		
            try {            	
            	clientSocket = serverSocket.accept();
            	
            } catch (IOException e) {
                System.out.println("I/O error: " + e);
            }            
            new SocketMessageThread(clientSocket).start();

		}

    }
	
    public String readMessage() throws IOException {
        
        String message = in.readLine();    	
    	return message;
    }
    
    public void stopServer() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
    
	
}


