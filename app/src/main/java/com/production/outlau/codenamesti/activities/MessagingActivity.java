package com.production.outlau.codenamesti.activities;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.eyalbira.loadingdots.LoadingDots;
import com.production.outlau.codenamesti.R;
import com.production.outlau.codenamesti.controllers.MessageAdapter;
import com.production.outlau.codenamesti.models.MemberData;
import com.production.outlau.codenamesti.models.Message;

import java.util.Random;

public class MessagingActivity extends Fragment {
    LoadingDots loadingDots;
    private EditText editText;
    private MessageAdapter messageAdapter;
    private ListView messagesView;
    private ImageButton sendButton;

    private int lastMsgId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.activity_messaging, parent, false);

        loadingDots = v.findViewById(R.id.load_dots);

        editText = v.findViewById(R.id.message_edit_text);
        sendButton = v.findViewById(R.id.send_message);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });

        messageAdapter = new MessageAdapter(getContext());
        messagesView = v.findViewById(R.id.messages_view);
        messagesView.setAdapter(messageAdapter);

        return v;
    }

    public void sendMessage() {
        String message = editText.getText().toString();
        if (message.length() > 0) {
            editText.getText().clear();
            messageAdapter.add(new Message(message, new MemberData("Name", getRandomColor()), true));
            messagesView.setSelection(messagesView.getCount() - 1);
            getMessage();
        }
    }

    public void getMessage() {
        loadingDots.setAlpha(1);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                messageAdapter.add(new Message(getRandomMsg(), new MemberData("Boyfriend",getResources().getString(0+R.color.theirMessageColor)), false));
                messagesView.setSelection(messagesView.getCount() - 1);
                loadingDots.setAlpha(0);
            }
        }, 1000);
    }

    private String getRandomMsg() {
        String[] phrases = {
                "You are Sti",
                "I love you",
                "You are the prettiest girl in the world",
                "Your eyes sparkle like diamonds",
                "You are my favorite girl in the world",
                "You are my Sti",
                "HI",
                "I love you my princess",
                "My sti",
                "STIDI BLITZI",
                "STIIII",
                "I miss you",
                "You are amazing",
                "You are the best girlfriend in the world",
                "I miss you so much my angel",
                "Your booty is the best booty",
                "You are STIDI BLITZI",
                "I love your smile",
                "You have such an amazing smile",
                "I AM IN LOVE WITH THOSE BROWS",
                "You look pretty",
                "My stidi blitzi",
                "My princess",
                "Have I told you how pretty you look?",
        };

        int id = (int) Math.floor(Math.random() * phrases.length);
        if(id == lastMsgId){
            return getRandomMsg();
        } else {
            return phrases[id];
        }
    }

    private String getRandomColor() {
        Random r = new Random();
        StringBuffer sb = new StringBuffer("#");
        while(sb.length() < 7){
            sb.append(Integer.toHexString(r.nextInt()));
        }
        return sb.toString().substring(0, 7);
    }
}

