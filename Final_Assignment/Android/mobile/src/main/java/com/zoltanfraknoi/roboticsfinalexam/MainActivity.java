package com.zoltanfraknoi.roboticsfinalexam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    SocketClientThread socketClientThread;

    static String IP = "10.0.1.1";
    static int PORT = 6666;

    Button btnConnect;
    Button btnSend;
    EditText txtIP;
    EditText txtPort;
    EditText txtMessage;
    Thread commThread;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConnect = (Button) findViewById(R.id.btnConnect);
        btnSend = (Button) findViewById(R.id.btnSend);
        txtIP = (EditText) findViewById(R.id.txtIPAddress);
        txtPort = (EditText) findViewById(R.id.txtPort);
        txtMessage = (EditText) findViewById(R.id.txtMessage);

        socketClientThread = new SocketClientThread();
    }

    public void btnConnect(View v) {
        IP = txtIP.getText().toString();
        PORT = Integer.parseInt(txtPort.getText().toString());

        try {
            socketClientThread.startConnection(IP, PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void btnSendMessage(View v) throws IOException {
        String message = txtMessage.getText().toString();

        String response;
        response = socketClientThread.sendMessage(message);

        System.out.println("Answer: " + response);
        Toast.makeText(v.getContext(), response, Toast.LENGTH_LONG);
    }
}
