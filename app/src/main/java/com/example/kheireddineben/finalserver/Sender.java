package com.example.kheireddineben.finalserver;

import android.widget.TextView;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;


/**
 * This is the chat sender.
 * 
 * @author Lak J Comspace (http://lakjeewa.blogspot.com)
 * 
 */
public class Sender {

    private PrintWriter out;
    private TextView chatView;

    /**
     * Public constructor.
     * 
     * @param clientSocket
     *            Socket which has been opened for chat
     * @param chatViewParam
     *            Chat history text area of chat window
     */
    public Sender(Socket clientSocket, TextView chatViewParam) {
        chatView = chatViewParam;

        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        out.println(message); // Print the message on output stream.
        chatView.append("Server: " + message + "\n"); // Print the message on chat window.
    }

}
