package com.example.labs;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityLab2q2 extends AppCompatActivity {
    private EditText editTextNumber1;
    private EditText editTextNumber2;
    private TextView textViewResult;
    private Button buttonAdd, buttonSubtract, buttonMultiply, buttonDivide;

    private enum Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2_2);

        // Initialize views
        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        textViewResult = findViewById(R.id.textViewResult);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);

        // Set click listeners
        buttonAdd.setOnClickListener(v -> calculate(Operation.ADD));
        buttonSubtract.setOnClickListener(v -> calculate(Operation.SUBTRACT));
        buttonMultiply.setOnClickListener(v -> calculate(Operation.MULTIPLY));
        buttonDivide.setOnClickListener(v -> calculate(Operation.DIVIDE));
    }

    private void calculate(Operation operation) {
        // Get input values
        String num1Str = editTextNumber1.getText().toString();
        String num2Str = editTextNumber2.getText().toString();

        // Validate input
        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đủ hai số", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);
            double result = 0;
            String operationSymbol = "";

            switch (operation) {
                case ADD:
                    result = num1 + num2;
                    operationSymbol = "+";
                    break;
                case SUBTRACT:
                    result = num1 - num2;
                    operationSymbol = "-";
                    break;
                case MULTIPLY:
                    result = num1 * num2;
                    operationSymbol = "×";
                    break;
                case DIVIDE:
                    if (num2 == 0) {
                        Toast.makeText(this, "Không thể chia cho 0", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result = num1 / num2;
                    operationSymbol = "÷";
                    break;
            }

            // Format result to remove unnecessary decimal places
            String formattedResult;
            if (result == (long) result) {
                formattedResult = String.format("%d", (long) result);
            } else {
                formattedResult = String.format("%.2f", result);
            }

            // Display result
            String displayText = String.format("%s %s %s = %s",
                    num1Str, operationSymbol, num2Str, formattedResult);
            textViewResult.setText(displayText);

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
        }
    }
}