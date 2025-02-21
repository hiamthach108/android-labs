package com.example.labs;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivityLab5q1 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Lab5UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab5_1);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create sample data
        List<Lab5User> users = new ArrayList<>();
        users.add(new Lab5User("Thach", "Le Ngoc Thach", "thachlnse173475@fpt.edu.vn"));
        users.add(new Lab5User("NguyenTT", "Tran Thanh Nguyen", "Nguyentt@fpt.edu.vn"));
        users.add(new Lab5User("Antv", "Tran Van AN", "antv@gmail.com"));
        users.add(new Lab5User("BangTT", "Tran Thanh Bang", "bangtt@gmail.com"));
        users.add(new Lab5User("KhangTT", "Tran Thanh Khang", "khangtt@gmail.com"));
        users.add(new Lab5User("BaoNT", "Nguyen Thanh Bao", "baott@gmail.com"));

        // Set up adapter
        userAdapter = new Lab5UserAdapter(users);
        recyclerView.setAdapter(userAdapter);
    }
}
