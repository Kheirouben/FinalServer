/**package com.example.kheireddineben.finalserver;

import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;


import java.io.IOException;
import java.net.Socket;



public class ChatWindow extends MainActivity {

    private TextView chatView;
    private Button sendButton;
    private EditText chatBox;
    private ScrollView scrollView;

    public void open(final Socket clientSocket) {
        initComponents();
        initSenderAndReceiver(clientSocket);

    }

    private void initComponents() {
        chatView = (TextView) findViewById(R.id.msg);
        chatBox = (EditText) findViewById(R.id.editText);
        sendButton = (Button) findViewById(R.id.button) ;
    }

    private void initSenderAndReceiver(final Socket clientSocket) {

        Receiver receiver = new Receiver(clientSocket, chatView);
        final Sender sender = new Sender(clientSocket, chatView);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sender.sendMessage(chatBox.getText().toString());
                chatBox.setText(""); //Clear the chat box
            }

        });

        Thread receiverThread = new Thread(receiver);
        receiverThread.run();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            clientSocket.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}

**/