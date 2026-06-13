package com.example.lawassistant;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lawassistant.databinding.ActivityDetailedBinding;

public class DetailedActivity extends AppCompatActivity {

    private ActivityDetailedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDetailedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();

        if (intent != null) {

            String name = intent.getStringExtra("name");

            String specialization =
                    intent.getStringExtra("specialization");

            String experience =
                    intent.getStringExtra("experience");

            String phone =
                    intent.getStringExtra("phone");

            String email =
                    intent.getStringExtra("email");

            String location =
                    intent.getStringExtra("location");

            float rating =
                    intent.getFloatExtra("rating", 0);

            int desc =
                    intent.getIntExtra(
                            "desc",
                            R.string.arunanDesc
                    );

            int image =
                    intent.getIntExtra(
                            "image",
                            R.drawable.la
                    );

            // Set Data

            binding.detailName.setText(name);

            binding.detailSpecialization.setText(
                    specialization
            );

            binding.detailExperience.setText(
                    "Experience: " + experience
            );

            binding.detailPhone.setText(
                    "Phone: " + phone
            );

            binding.detailEmail.setText(
                    "Email: " + email
            );

            binding.detailLocation.setText(
                    "Location: " + location
            );

            binding.detailRating.setRating(
                    rating
            );

            binding.detailDesc.setText(desc);

            binding.detailImage.setImageResource(
                    image
            );

            // Buttons

            Button btnCall = binding.btnCall;
            Button btnEmail = binding.btnEmail;
            Button btnWhatsApp = binding.btnWhatsApp;
            Button btnMap = binding.btnMap;

            // Call

            btnCall.setOnClickListener(v -> {

                Intent callIntent =
                        new Intent(
                                Intent.ACTION_DIAL,
                                Uri.parse("tel:" + phone)
                        );

                startActivity(callIntent);
            });

            // Email

            btnEmail.setOnClickListener(v -> {

                Intent emailIntent =
                        new Intent(
                                Intent.ACTION_SENDTO
                        );

                emailIntent.setData(
                        Uri.parse(
                                "mailto:" + email
                        )
                );

                emailIntent.putExtra(
                        Intent.EXTRA_SUBJECT,
                        "Legal Consultation Request"
                );

                startActivity(emailIntent);
            });

            // WhatsApp

            btnWhatsApp.setOnClickListener(v -> {

                String whatsappNumber =
                        phone.replace("+", "")
                                .replace(" ", "");

                String url =
                        "https://wa.me/"
                                + whatsappNumber;

                Intent whatsappIntent =
                        new Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse(url)
                        );

                startActivity(whatsappIntent);
            });

            // Open Location in Maps

            btnMap.setOnClickListener(v -> {

                Uri mapUri =
                        Uri.parse(
                                "geo:0,0?q="
                                        + Uri.encode(location)
                        );

                Intent mapIntent =
                        new Intent(
                                Intent.ACTION_VIEW,
                                mapUri
                        );

                startActivity(mapIntent);
            });
        }
    }
}