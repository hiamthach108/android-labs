// MainActivity.java
package com.example.labs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityLab4 extends AppCompatActivity {
    private static final int FOOD_REQUEST_CODE = 1;
    private static final int DRINK_REQUEST_CODE = 2;

    private Button btnChooseFood;
    private Button btnChooseDrink;
    private TextView tvFoodChoice;
    private TextView tvDrinkChoice;
    private TextView tvTotalPrice;
    private double foodPrice = 0;
    private double drinkPrice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab4);

        btnChooseFood = findViewById(R.id.btnChooseFood);
        btnChooseDrink = findViewById(R.id.btnChooseDrink);
        tvFoodChoice = findViewById(R.id.tvFoodChoice);
        tvDrinkChoice = findViewById(R.id.tvDrinkChoice);
        tvTotalPrice = findViewById(R.id.tvTotalPrice);

        btnChooseFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityLab4.this, FoodActivity.class);
                startActivityForResult(intent, FOOD_REQUEST_CODE);
            }
        });

        btnChooseDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityLab4.this, DrinkActivity.class);
                startActivityForResult(intent, DRINK_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == FOOD_REQUEST_CODE) {
                String foodName = data.getStringExtra("name");
                foodPrice = data.getDoubleExtra("price", 0);
                tvFoodChoice.setText("Món ăn: " + foodName);
            } else if (requestCode == DRINK_REQUEST_CODE) {
                String drinkName = data.getStringExtra("name");
                drinkPrice = data.getDoubleExtra("price", 0);
                tvDrinkChoice.setText("Đồ uống: " + drinkName);
            }
            updateTotalPrice();
        }
    }

    private void updateTotalPrice() {
        double total = foodPrice + drinkPrice;
        tvTotalPrice.setText(String.format("Tổng tiền: %.0f VNĐ", total));
    }
}
