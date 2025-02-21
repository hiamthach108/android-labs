package com.example.labs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button lab1q1a = findViewById(R.id.lab1q1a);
        Button lab1q1b = findViewById(R.id.lab1q1b);
        Button lab1q2 = findViewById(R.id.lab1q2);
        Button lab1q3 = findViewById(R.id.lab1q3);
        Button lab2q1 = findViewById(R.id.lab2q1);
        Button lab2q2 = findViewById(R.id.lab2q2);
        Button lab2q3 = findViewById(R.id.lab2q3);
        Button lab3q1 = findViewById(R.id.lab3q1);
        Button lab3q2 = findViewById(R.id.lab3q2);

        lab1q1a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivityLab1q1a.class));
            }
        });

        lab1q1b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivityLab1q1b.class));
            }
        });

        lab1q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivityLab1q2.class));
            }
        });

        lab1q3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivityLab1q3.class));
            }
        });

        lab2q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivityLab2q1.class));
            }
        });

        lab2q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivityLab2q2.class));
            }
        });

        lab2q3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivityLab2q3.class));
            }
        });

        lab3q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivityLab3q1.class));
            }
        });

        lab3q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivityLab3q2.class));
            }
        });
    }
}