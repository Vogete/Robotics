package com.zoltanfraknoi.roboticsfinalexam;

import android.app.Activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Zoli on 2018-04-16.
 */

public class SocketClientThread {
    private static Socket clientSocket;
    private static PrintWriter out;
    private static BufferedReader in;

    public static String response;

    public SocketClientThread() {

    }

    public static void startConnection(final String ip, final int port) throws UnknownHostException, IOException {

        Thread connectionThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    clientSocket = new Socket(ip, port);
                    out = new PrintWriter(clientSocket.getOutputStream(), true);
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        connectionThread.start();
    }

    public static String sendMessage(final String msg) throws IOException {
        Thread sendThread = new Thread(new Runnable() {
            @Override
            public void run() {
                if (clientSocket != null) {
                    try {
                        out.println(msg);
                        out.flush();
                        response = in.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        sendThread.start();

        return response;
    }

    public static void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }



}
