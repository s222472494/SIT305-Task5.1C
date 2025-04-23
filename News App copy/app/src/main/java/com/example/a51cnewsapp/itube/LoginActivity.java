package com.example.a51cnewsapp.itube;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.a51cnewsapp.R;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin, btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        btnSignUp = findViewById(R.id.btn_sign_up);

        // Set up login button click listener
        btnLogin.setOnClickListener(v -> {
            // Simple login logic (in a real app, you should validate against a server)
            String username = etUsername.getText().toString();
            String password = etPassword.getText().toString();

            if (username.equals("user") && password.equals("password")) { // Simulate successful login
                // Save login status in SharedPreferences
                SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("isLoggedIn", true);
                editor.apply();

                // Navigate to PlaylistActivity after successful login
                Intent intent = new Intent(LoginActivity.this, PlaylistActivity.class);
                startActivity(intent);
                finish(); // Finish LoginActivity
            } else {
                // Show error message if login fails
                Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
            }
        });

        // Set up Sign Up button click listener
        btnSignUp.setOnClickListener(v -> {
            // Navigate to SignUpActivity
            Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(intent);
        });
    }
}
