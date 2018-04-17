package com.zoltanfraknoi.roboticsfinalexam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
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
    Button btnForward;
    Button btnBackward;
    Button btnLeft;
    Button btnRight;
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
        btnForward = (Button) findViewById(R.id.btnForward);
        btnBackward = (Button) findViewById(R.id.btnBackward);
        btnLeft = (Button) findViewById(R.id.btnLeft);
        btnRight = (Button) findViewById(R.id.btnRight);
        txtIP = (EditText) findViewById(R.id.txtIPAddress);
        txtPort = (EditText) findViewById(R.id.txtPort);
        txtMessage = (EditText) findViewById(R.id.txtMessage);

        socketClientThread = new SocketClientThread();

        String stopCommand = getString(R.string.lejos_stop);
        String endturn = getString(R.string.lejos_endturn);

        ev3ManualControl(btnForward, getString(R.string.lejos_forward), stopCommand);
        ev3ManualControl(btnBackward, getString(R.string.lejos_backward), stopCommand);
        ev3ManualControl(btnLeft, getString(R.string.lejos_left), endturn);
        ev3ManualControl(btnRight, getString(R.string.lejos_right), endturn);
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

        String response = socketClientThread.sendMessage(message);

//        System.out.println("Answer: " + response);
//        Toast.makeText(v.getContext(), response, Toast.LENGTH_LONG).show();
    }


    public void ev3ManualControl(Button btn, final String pressCommand, final String releaseCommand) {
        btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch ( event.getAction() ) {
                    case MotionEvent.ACTION_DOWN:

                        try {
                            socketClientThread.sendMessage(pressCommand);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        break;
                    case MotionEvent.ACTION_UP:

                        try {
                            socketClientThread.sendMessage(releaseCommand);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        break;
                }
                return false;
            }
        });



    }

}


