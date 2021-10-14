package com.isavit.codey.authentication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.PreferenceManager;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.chip.ChipDrawable;
import com.isavit.codey.R;
import com.isavit.codey.home.Home;

/**
 *
 * This is the signup activity
 * The username, password are locally stored
 * @SharedPreferences in PRIVATE mode can be used for the same
 *
 */

public class Signup extends AppCompatActivity {
    EditText username, password, repassword;
    Button btnSignUp, gotoSignIn;
    DBHelper myDB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        repassword=(EditText)findViewById(R.id.repassword);

        btnSignUp=(Button)findViewById(R.id.btnSignUp);
        gotoSignIn=(Button)findViewById(R.id.gotoSignIn);
        myDB = new DBHelper(this);
        applyTheme();
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass= repassword.getText().toString();

                if(user.equals("")|| pass.equals("") || repass.equals("")){
                    Toast.makeText(Signup.this, "Fill all fields",Toast.LENGTH_SHORT).show();
                }else{
                    if(pass.equals(repass)){
                       boolean usercheckResult= myDB.checkusername(user);
                       if(usercheckResult==false){
                           boolean regResult= myDB.insertData(user, pass);
                           if(regResult==true){
                               Toast.makeText(Signup.this, "Registered Successfully.",Toast.LENGTH_SHORT).show();
                               Intent intent = new Intent (getApplicationContext(), Login.class) ;
                               startActivity(intent);
                           }else{
                               Toast.makeText(Signup.this, "Registration Failed!",Toast.LENGTH_SHORT).show();
                           }
                       }else{
                           Toast.makeText(Signup.this, "User already exists. \n Please Sign In.",Toast.LENGTH_SHORT).show();
                       }

                    }else{
                        Toast.makeText(Signup.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        gotoSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }

    private void applyTheme(){
        int theme = PreferenceManager.getDefaultSharedPreferences(this).getInt("com.isavit.codey.DARK_STATUS", AppCompatDelegate.MODE_NIGHT_NO);
        AppCompatDelegate.setDefaultNightMode(theme);
        getDelegate().applyDayNight();
    }
}