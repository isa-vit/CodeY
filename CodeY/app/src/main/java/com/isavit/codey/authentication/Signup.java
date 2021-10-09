package com.isavit.codey.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;

import com.isavit.codey.R;

/**
 *
 * This is the signup activity
 * The username, password are locally stored
 * @SharedPreferences in PRIVATE mode can be used for the same
 *
 */

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }
    public void taketoLogin(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}