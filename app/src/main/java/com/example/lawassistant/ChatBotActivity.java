package com.example.lawassistant;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChatBotActivity extends AppCompatActivity {

    private LinearLayout chatContainer;
    private EditText inputMessage;
    private Button btnSend;
    private ScrollView chatScroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_bot);

        chatContainer = findViewById(R.id.chat_container);
        inputMessage = findViewById(R.id.input_message);
        btnSend = findViewById(R.id.btn_send);

        chatScroll = findViewById(R.id.chatScroll);

        addBotMessage(
                "Welcome to AI Law Assistant.\n\n" +
                        "You can ask me about:\n" +
                        "• FIR\n" +
                        "• Consumer Rights\n" +
                        "• Property Disputes\n" +
                        "• Divorce Laws\n" +
                        "• Cyber Crime\n" +
                        "• Legal Procedures"
        );

        btnSend.setOnClickListener(v -> sendMessage());
    }

    private void sendMessage() {

        String message =
                inputMessage.getText().toString().trim();

        if (message.isEmpty()) {
            return;
        }

        addUserMessage(message);

        inputMessage.setText("");

        String response = getLegalResponse(message);

        addBotMessage(response);
    }

    private void addUserMessage(String message) {

        TextView tv = new TextView(this);

        tv.setText(message);

        tv.setTextSize(16);

        tv.setPadding(25,20,25,20);

        tv.setBackgroundResource(android.R.drawable.dialog_holo_light_frame);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params.gravity = Gravity.END;

        params.setMargins(20,10,20,10);

        tv.setLayoutParams(params);

        chatContainer.addView(tv);

        scrollToBottom();
    }

    private void addBotMessage(String message) {

        TextView tv = new TextView(this);

        tv.setText(message);

        tv.setTextSize(16);

        tv.setPadding(25,20,25,20);

        tv.setBackgroundResource(android.R.drawable.dialog_holo_dark_frame);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params.gravity = Gravity.START;

        params.setMargins(20,10,20,10);

        tv.setLayoutParams(params);

        chatContainer.addView(tv);

        scrollToBottom();
    }

    private void scrollToBottom() {

        chatScroll.post(() ->
                chatScroll.fullScroll(ScrollView.FOCUS_DOWN)
        );
    }

    private String getLegalResponse(String query) {

        query = query.toLowerCase();

        if (query.contains("fir")) {
            return "An FIR (First Information Report) is recorded by the police when information about a cognizable offence is received.";
        }

        if (query.contains("consumer")) {
            return "Consumers can file complaints before the Consumer Disputes Redressal Commission regarding defective products or deficient services.";
        }

        if (query.contains("property")) {
            return "Property disputes may involve ownership, inheritance, possession, title or land boundaries.";
        }

        if (query.contains("divorce")) {
            return "Divorce procedures in India depend on the applicable personal law and the facts of the case.";
        }

        if (query.contains("cyber")) {
            return "Cyber crimes include hacking, identity theft, phishing, online fraud and unauthorized access to computer systems.";
        }

        if (query.contains("bail")) {
            return "Bail is the temporary release of an accused person pending trial, subject to conditions imposed by the court.";
        }

        if (query.contains("ipc")) {
            return "The Indian Penal Code (IPC) has been replaced by the Bharatiya Nyaya Sanhita (BNS), though many people still refer to IPC provisions.";
        }

        if (query.contains("constitution")) {
            return "The Constitution of India is the supreme law of the country and defines the structure, powers and duties of government institutions.";
        }

        return "I understand your legal query. For advanced legal assistance, this chatbot should be connected to an AI service such as OpenAI or another legal knowledge system.";
    }
}