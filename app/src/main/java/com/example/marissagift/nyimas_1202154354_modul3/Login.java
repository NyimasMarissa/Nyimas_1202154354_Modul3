package com.example.marissagift.nyimas_1202154354_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText username;
    private EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view) {
        username = (EditText) findViewById(R.id.editText_usr);
        password = (EditText) findViewById(R.id.editText_pass);


        if(username.getText().toString().equals("EAD") && password.getText().toString().equals("MOBILE")) {
            Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, Home.class);
            startActivity(i);
        } else {
            Toast.makeText(this, "Username atau Password salah, silahkan coba lagi!", Toast.LENGTH_SHORT).show();
        }

    }
}
