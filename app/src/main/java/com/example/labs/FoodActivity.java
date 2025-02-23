// FoodActivity.java
package com.example.labs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity {
    private ListView listView;
    private Button btnOrder;
    private ArrayList<MenuItem> foodItems;
    private MenuItem selectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        listView = findViewById(R.id.foodListView);
        btnOrder = findViewById(R.id.btnOrderFood);

        // Initialize food items
        foodItems = new ArrayList<>();
        foodItems.add(new MenuItem("Phở Hà Nội", "Phở bò truyền thống", 50000, 1));
        foodItems.add(new MenuItem("Bún Bò Huế", "Bún bò cay cay", 55000, 2));
        foodItems.add(new MenuItem("Mì Quảng", "Mì Quảng đặc biệt", 45000, 3));
        foodItems.add(new MenuItem("Hủ Tiếu Sài Gòn", "Hủ tiếu nam vang", 40000, 4));

        MenuAdapter adapter = new MenuAdapter(this, foodItems);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedItem = foodItems.get(position);
                view.setSelected(true);
            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedItem != null) {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("name", selectedItem.getName());
                    resultIntent.putExtra("price", selectedItem.getPrice());
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
            }
        });
    }
}