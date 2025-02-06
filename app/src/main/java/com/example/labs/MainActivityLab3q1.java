package com.example.labs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivityLab3q1 extends AppCompatActivity {
    ListView listView;
    EditText editText;
    Button addBtn;
    Button updateBtn;
    ArrayList<String> items = new ArrayList<>();

    int selected = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3_1);

        listView = findViewById(R.id.listView);
        editText = findViewById(R.id.editText);
        addBtn = findViewById(R.id.btnAdd);
        updateBtn = findViewById(R.id.btnUpdate);

        // Khởi tạo dữ liệu mẫu
        items.add("Android");
        items.add("iOS");
        items.add("PHP");
        items.add("Unity");
        items.add("ASP.net");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivityLab3q1.this, "Bạn chọn: " + items.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = editText.getText().toString().trim();
                if (!newItem.isEmpty()) {
                    items.add(newItem);
                    adapter.notifyDataSetChanged();
                    editText.setText(""); // Xóa nội dung input sau khi thêm
                } else {
                    Toast.makeText(MainActivityLab3q1.this, "Vui lòng nhập sản phẩm", Toast.LENGTH_SHORT).show();
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selected = position;
                editText.setText(items.get(position));
            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selected != -1) {
                    String updatedItem = editText.getText().toString().trim();
                    if (!updatedItem.isEmpty()) {
                        items.set(selected, updatedItem);
                        adapter.notifyDataSetChanged();
                        editText.setText("");
                        selected = -1;
                    } else {
                        Toast.makeText(MainActivityLab3q1.this, "Vui lòng nhập sản phẩm mới", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivityLab3q1.this, "Chọn một sản phẩm để cập nhật", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Long Press to Delete Item
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                items.remove(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivityLab3q1.this, "Item deleted", Toast.LENGTH_SHORT).show();
                return true; // Return true to consume the long press event
            }
        });
    }
}

