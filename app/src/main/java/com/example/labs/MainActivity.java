package com.example.labs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static class ListLabItem {
        String id;
        Class<?> activityClass;

        ListLabItem(String id, Class<?> activityClass) {
            this.id = id;
            this.activityClass = activityClass;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layout = findViewById(R.id.buttonContainer);

        List<ListLabItem> labItems = new ArrayList<>();
        labItems.add(new ListLabItem("lab1q1a", MainActivityLab1q1a.class));
        labItems.add(new ListLabItem("lab1q1b", MainActivityLab1q1b.class));
        labItems.add(new ListLabItem("lab1q2", MainActivityLab1q2.class));
        labItems.add(new ListLabItem("lab1q3", MainActivityLab1q3.class));
        labItems.add(new ListLabItem("lab2q1", MainActivityLab2q1.class));
        labItems.add(new ListLabItem("lab2q2", MainActivityLab2q2.class));
        labItems.add(new ListLabItem("lab2q3", MainActivityLab2q3.class));
        labItems.add(new ListLabItem("lab3q1", MainActivityLab3q1.class));
        labItems.add(new ListLabItem("lab3q2", MainActivityLab3q2.class));
        labItems.add(new ListLabItem("lab4", MainActivityLab4.class));
        labItems.add(new ListLabItem("lab5q1", MainActivityLab5q1.class));
        labItems.add(new ListLabItem("lab5q2", MainActivityLab5q2.class));
        labItems.add(new ListLabItem("lab9q1", MainActivityLab9.class));
        labItems.add(new ListLabItem("lab11", MainActivityLab11.class));

        for (ListLabItem item : labItems) {
            Button button = new Button(this);
            button.setText(item.id);
            button.setId(View.generateViewId());
            button.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, item.activityClass)));
            layout.addView(button);
        }
    }
}
