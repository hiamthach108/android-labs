package com.example.labs;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivityLab2q1 extends AppCompatActivity {
    private EditText editTextMin;
    private EditText editTextMax;
    private Button buttonGenerate;
    private TextView textViewResult;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2_1);

        // Initialize views
        editTextMin = findViewById(R.id.editTextMin);
        editTextMax = findViewById(R.id.editTextMax);
        buttonGenerate = findViewById(R.id.buttonGenerate);
        textViewResult = findViewById(R.id.textViewResult);

        random = new Random();

        buttonGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateRandomNumber();
            }
        });
    }

    private void generateRandomNumber() {
        // Get input values
        String minStr = editTextMin.getText().toString();
        String maxStr = editTextMax.getText().toString();

        // Validate input
        if (minStr.isEmpty() || maxStr.isEmpty()) {
            Toast.makeText(this, "Please enter both minimum and maximum values", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            int min = Integer.parseInt(minStr);
            int max = Integer.parseInt(maxStr);

            // Validate range
            if (min >= max) {
                Toast.makeText(this, "Maximum value must be greater than minimum value", Toast.LENGTH_SHORT).show();
                return;
            }

            // Generate random number
            int randomNumber = random.nextInt((max - min) + 1) + min;

            // Display result
            textViewResult.setText(String.valueOf(randomNumber));

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
        }
    }
}