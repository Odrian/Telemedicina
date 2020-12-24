package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registr extends AppCompatActivity {

    private Button RegButton;

    private EditText RegNumber;
    private EditText RegPassword;
    private EditText RegPassword2;
    private Button RegBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registr);

        RegNumber = findViewById(R.id.RegNumber);
        RegPassword = findViewById(R.id.RegPassword);
        RegPassword2 = findViewById(R.id.RegPassword2);
        RegButton = findViewById(R.id.RegButton);

        RegBack = findViewById(R.id.RegBack);

        RegButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), profile.class);
                String l = RegNumber.getText().toString();
                String p = RegPassword.getText().toString();
                String p2 = RegPassword2.getText().toString();
                startActivity(intent);
            }
        });

        RegBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}