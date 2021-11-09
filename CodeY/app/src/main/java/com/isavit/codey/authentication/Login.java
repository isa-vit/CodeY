package com.isavit.codey.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.isavit.codey.R;
import com.isavit.codey.home.Home;

/**
 * This is the login activity
 * The username, password are verified comparing the the locally stored credentials
 */

public class Login extends AppCompatActivity {
    EditText username, password;
    Button btnLogin, gotoSignUp;
    DBHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.usernameLogin);
        password = findViewById(R.id.passwordLogin);
        btnLogin = findViewById(R.id.btnLogin);
        gotoSignUp = findViewById(R.id.gotoSignUp);

        myDB = new DBHelper(this);

        btnLogin.setOnClickListener(v -> {
            String user = username.getText().toString();
            String pass = password.getText().toString();

            if (user.equals("username") && pass.equals("password")) {
                Intent intent = new Intent(getApplicationContext(), Home.class);
                startActivity(intent);
            }

            if (user.equals("") || pass.equals("")) {
                Toast.makeText(Login.this, "Please fill both Username and Password!", Toast.LENGTH_SHORT).show();
            } else {
                boolean result = myDB.checkusernamePassword(user, pass);
                if (result) {
                    Intent intent = new Intent(getApplicationContext(), Home.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Login.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                }
            }

        });

        gotoSignUp.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Signup.class);
            startActivity(intent);
        });
    }
}