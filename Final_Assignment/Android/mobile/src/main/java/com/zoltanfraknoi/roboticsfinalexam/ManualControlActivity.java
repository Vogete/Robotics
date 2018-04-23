package com.zoltanfraknoi.roboticsfinalexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class ManualControlActivity extends AppCompatActivity {
    SocketClientThread socketClientThread;

    Button btnForward;
    Button btnBackward;
    Button btnLeft;
    Button btnRight;
    Button btnEmgStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_control);

        btnForward = (Button) findViewById(R.id.btnForward);
        btnBackward = (Button) findViewById(R.id.btnBackward);
        btnLeft = (Button) findViewById(R.id.btnLeft);
        btnRight = (Button) findViewById(R.id.btnRight);
        btnEmgStop = (Button) findViewById(R.id.btnRight);
        socketClientThread = new SocketClientThread();


        String stopCommand = getString(R.string.lejos_stop);
        String endturn = getString(R.string.lejos_endturn);

        ev3ManualControl(btnForward, getString(R.string.lejos_forward), stopCommand);
        ev3ManualControl(btnBackward, getString(R.string.lejos_backward), stopCommand);
        ev3ManualControl(btnLeft, getString(R.string.lejos_left), endturn);
        ev3ManualControl(btnRight, getString(R.string.lejos_right), endturn);
    }

    public void ev3ManualControl(Button btn, final String pressCommand, final String releaseCommand) {
        btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
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

    public void emgStop(View v){
        try {
            socketClientThread.sendMessage(getString(R.string.lejos_emgstop));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnLine(View v){
        try {
            socketClientThread.sendMessage(getString(R.string.lejos_linefollow));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
