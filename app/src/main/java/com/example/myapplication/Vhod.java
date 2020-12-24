package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileReader;
import java.io.IOException;

public class Vhod extends AppCompatActivity {

    private static final String LOGIN = "user";
    private static final String PASSWORD = "password";

    private EditText login;
    private EditText password;
    private Button signin;

    private Button back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vhod);

        login = findViewById(R.id.Login);
        password = findViewById(R.id.Password);
        signin = findViewById(R.id.Signin);

        back = findViewById(R.id.Back);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String l = login.getText().toString();
                String p = password.getText().toString();


                boolean flag = true;
                Intent intent_1 = new Intent(getApplicationContext(), profile.class);
                for (String[] lowData : FileScan.fileGet("UsersData.txt")) {
                    if (l.equals("user")) {
                        if (p.equals("password")) {
                            startActivity(intent_1);
                        } else {
                            // неверный пароль
                            Toast.makeText(getApplicationContext(), "Неверный пароль", Toast.LENGTH_LONG).show();
                        }
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    // неверный логин
                    Toast.makeText(getApplicationContext(), "Неверный логин", Toast.LENGTH_LONG).show();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}