import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import lejos.hardware.lcd.LCD;

public class SocketMessageThread extends Thread {
    protected Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private CommandHandler commandHandler;
    
    public SocketMessageThread(Socket clientSocket) {
    	this.socket = clientSocket;
    	commandHandler = new CommandHandler();
        this.setDaemon(true);
    }

    public void run() {
    	
        try {
        	out = new PrintWriter(socket.getOutputStream(), true);
        	in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            return;
        }

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
                	out.println(message);                	
                	commandHandler.commandDetermination(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        
               
    }
    
}
