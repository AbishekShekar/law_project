package com.example.lawassistant;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lawassistant.databinding.ActivitySignupBinding;

public class SignupActivity extends AppCompatActivity {

    private ActivitySignupBinding binding;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySignupBinding.inflate(
                getLayoutInflater()
        );

        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        Spinner userTypeSpinner =
                findViewById(R.id.userTypeSpinner);

        binding.signupButton.setOnClickListener(v -> {
            String fullName =
                    binding.signupName.getText()
                            .toString()
                            .trim();
            if(fullName.isEmpty()){
                binding.signupName.setError("Required");
                return;
            }
            String email =
                    binding.signupEmail
                            .getText()
                            .toString()
                            .trim();

            String password =
                    binding.signupPassword
                            .getText()
                            .toString()
                            .trim();

            String confirmPassword =
                    binding.signupConfirm
                            .getText()
                            .toString()
                            .trim();

            String userType =
                    userTypeSpinner
                            .getSelectedItem()
                            .toString();

            if (email.isEmpty()
                    || password.isEmpty()
                    || confirmPassword.isEmpty()) {

                Toast.makeText(
                        this,
                        "Please fill all fields",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            if (!Patterns.EMAIL_ADDRESS
                    .matcher(email)
                    .matches()) {

                binding.signupEmail
                        .setError(
                                "Invalid Email"
                        );

                return;
            }

            if (password.length() < 8) {

                binding.signupPassword
                        .setError(
                                "Minimum 8 characters"
                        );

                return;
            }

            if (!password.equals(confirmPassword)) {

                Toast.makeText(
                        this,
                        "Passwords do not match",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }
            if(!binding.termsCheckBox.isChecked()){
                Toast.makeText(
                        this,
                        "Accept Terms & Conditions",
                        Toast.LENGTH_SHORT
                ).show();
                return;
            }

            boolean userExists =
                    databaseHelper.checkEmail(email);

            if (userExists) {

                Toast.makeText(
                        this,
                        "User already exists. Please login.",
                        Toast.LENGTH_LONG
                ).show();

                return;
            }

            boolean inserted =
                    databaseHelper.insertData(
                            email,
                            password,
                            userType
                    );

            if (inserted) {

                Toast.makeText(
                        this,
                        "Account Created Successfully",
                        Toast.LENGTH_SHORT
                ).show();

                startActivity(
                        new Intent(
                                SignupActivity.this,
                                LoginActivity.class
                        )
                );

                finish();

            } else {

                Toast.makeText(
                        this,
                        "Registration Failed",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        binding.loginRedirectText.setOnClickListener(v -> {

            startActivity(
                    new Intent(
                            SignupActivity.this,
                            LoginActivity.class
                    )
            );

            finish();
        });
    }
}