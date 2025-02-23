// DrinkActivity.java
package com.example.labs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.labs.MenuAdapter;
import com.example.labs.MenuItem;
import com.example.labs.R;

import java.util.ArrayList;

public class DrinkActivity extends AppCompatActivity {
    private ListView listView;
    private Button btnOrder;
    private ArrayList<MenuItem> drinkItems;
    private MenuItem selectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        listView = findViewById(R.id.drinkListView);
        btnOrder = findViewById(R.id.btnOrderDrink);

        // Initialize drink items
        drinkItems = new ArrayList<>();
        drinkItems.add(new MenuItem("Pepsi", "Pepsi lon 330ml", 15000, 1));
        drinkItems.add(new MenuItem("Heineken", "Heineken lon 330ml", 25000, 2));
        drinkItems.add(new MenuItem("Tiger", "Tiger lon 330ml", 20000, 3));
        drinkItems.add(new MenuItem("Sài Gòn Đỏ", "Bia Sài Gòn lon 330ml", 18000, 4));

        MenuAdapter adapter = new MenuAdapter(this, drinkItems);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedItem = drinkItems.get(position);
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
