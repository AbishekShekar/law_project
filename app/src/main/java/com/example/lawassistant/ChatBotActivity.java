package com.example.lawassistant;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChatBotActivity extends AppCompatActivity {

    private LinearLayout chatContainer;
    private EditText inputMessage;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_bot);

        // Initialize views
        chatContainer = findViewById(R.id.chat_container);
        inputMessage = findViewById(R.id.input_message);
        btnSend = findViewById(R.id.btn_send);

        // Set onClickListener for the send button
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        String message = inputMessage.getText().toString().trim();
        if (!message.isEmpty()) {
            // Add user message to the chat container
            addMessageToChatContainer(message);

            // Clear the input field
            inputMessage.setText("");

            // Simulate bot response (replace this with actual bot logic)
            String botResponse = "Bot: Welcome to AI LAW ASSISTANT,Thank you for your message!";
            addMessageToChatContainer(botResponse);
        }
    }

    private void addMessageToChatContainer(String message) {
        TextView textView = new TextView(this);
        textView.setText(message);
        chatContainer.addView(textView);
    }
}
