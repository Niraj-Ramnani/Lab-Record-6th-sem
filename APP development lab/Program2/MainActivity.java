package com.example.program2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // References to the views
        EditText etUsername = findViewById(R.id.etUsername);
        EditText etPassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);
        TextView tvMessage = findViewById(R.id.tvMessage);

        // Set OnClickListener for the login button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get text from EditText fields
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                // Predefined username and password for login
                String correctUsername = "Niraj";
                String correctPassword = "2004";

                // Check if the entered username and password match the predefined values
                if (username.equals(correctUsername) && password.equals(correctPassword)) {
                    // Successful login, display success message and go to HomeActivity
                    tvMessage.setText("Login Successful!");
                    tvMessage.setTextColor(getResources().getColor(android.R.color.holo_green_dark));

                    // Create an Intent to move to the HomeActivity
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();  // Close the LoginActivity
                } else {
                    // Invalid login, display error message
                    tvMessage.setText("Invalid Username or Password!");
                    tvMessage.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                }
            }
        });
    }
}