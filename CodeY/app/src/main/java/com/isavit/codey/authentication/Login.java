package com.isavit.codey.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.isavit.codey.R;
import com.isavit.codey.home.Home;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 *
 * This is the login activity
 * The username, password are verified comparing the the locally stored credentials
 *
 */

public class Login extends AppCompatActivity {
    EditText username, password;
    Button btnLogin, gotoSignUp;
    DBHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=(EditText)findViewById(R.id.usernameLogin);
        password=(EditText)findViewById(R.id.passwordLogin);
        btnLogin=(Button)findViewById(R.id.btnLogin);
        gotoSignUp=(Button)findViewById(R.id.gotoSignUp);

        myDB = new DBHelper(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals("")){
                    Toast.makeText(Login.this,"Please fill both Username and Password!",Toast.LENGTH_SHORT).show();
                }else{
                    boolean result = myDB.checkusernamePassword(user, pass);
                    if(result==true){
                        Intent intent = new Intent(getApplicationContext(), Home.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(Login.this,"Invalid Username or Password", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        gotoSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Signup.class);
                startActivity(intent);
            }
        });
    }
}