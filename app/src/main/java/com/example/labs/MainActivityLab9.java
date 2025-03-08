package com.example.labs;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivityLab9 extends AppCompatActivity {
    Database db;

    private RecyclerView recyclerView;
    private Lab9JobAdapter jobAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab9);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = new Database(this, "lab9q1.db", null, 1);

        db.QueryData("CREATE TABLE IF NOT EXISTS Jobs(Id INTEGER PRIMARY KEY AUTOINCREMENT, Name VARCHAR(200))");
//        db.QueryData("INSERT INTO Jobs VALUES(null, 'Developer')");
//        db.QueryData("INSERT INTO Jobs VALUES(null, 'Designer')");
        Cursor cursor = db.GetData("SELECT * FROM Jobs");
        List<Lab9Job> jobs = new ArrayList<Lab9Job>();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);

            Lab9Job job = new Lab9Job(id, name);

            jobs.add(job);
        }

        jobAdapter = new Lab9JobAdapter(jobs);

        recyclerView.setAdapter(jobAdapter);
    }
}
