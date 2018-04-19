package com.zoltanfraknoi.roboticsfinalexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class ActionsActivity extends AppCompatActivity {
    SocketClientThread socketClientThread;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actions);

        socketClientThread = new SocketClientThread();

    }

    public void btnManualControl(View v) {
        Intent intent = new Intent(this, ManualControlActivity.class);
        startActivity(intent);
    }



}