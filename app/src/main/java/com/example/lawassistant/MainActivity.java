package com.example.lawassistant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private CardView imageCard, videoCard, audioCard, appCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageCard = findViewById(R.id.imageCard);
        videoCard = findViewById(R.id.videoCard);
        audioCard = findViewById(R.id.audioCard);
        appCard = findViewById(R.id.appCard);

        imageCard.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, ImageActivity.class)));

        videoCard.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, ChatBotActivity.class)));

        audioCard.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, AdvocateActivity.class)));

        appCard.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, SettingsActivity.class)));
    }
}