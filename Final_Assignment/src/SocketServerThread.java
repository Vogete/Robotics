import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
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

    	while (true) {
        	        	
            try {
            	clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.out.println("I/O error: " + e);
            }
            
            new SocketMessageThread(clientSocket).start();
            
//        	out = new PrintWriter(clientSocket.getOutputStream(), true);
//        	in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//        	
//        	while (true) {
//        		String message = readMessage();
//        		out.println(message);
//        		LCD.clear();
//        		LCD.drawString(message, 0, 0);
//        	}
            
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

