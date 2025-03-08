package com.example.labs;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityLab11 extends AppCompatActivity implements Lab11TraineeAdapter.OnTraineeClickListener {
    private RecyclerView recyclerView;
    private Lab11TraineeAdapter adapter;
    private final List<Lab11Trainee> traineeList = new ArrayList<>();
    private TraineeApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab11);

        // Khởi tạo Retrofit
        apiService = RetrofitClient.getInstance().getApiService();

        // Setup RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new Lab11TraineeAdapter(traineeList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Setup FAB để thêm Trainee mới
        findViewById(R.id.btnAddTrainee).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityLab11.this, AddEditTraineeActivity.class);
            startActivity(intent);
        });

        // Load danh sách Trainee
        loadTrainees();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadTrainees(); // Refresh danh sách khi quay lại màn hình
    }

    private void loadTrainees() {
        apiService.getAllTrainees().enqueue(new Callback<List<Lab11Trainee>>() {
            @Override
            public void onResponse(Call<List<Lab11Trainee>> call, Response<List<Lab11Trainee>> response) {
                // log response to console
                System.out.println(response);
                if (response.isSuccessful() && response.body() != null) {
                    traineeList.clear();
                    traineeList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(MainActivityLab11.this, "Failed to load trainees", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Lab11Trainee>> call, Throwable t) {
                Toast.makeText(MainActivityLab11.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onEditClick(Lab11Trainee trainee) {
        Intent intent = new Intent(MainActivityLab11.this, AddEditTraineeActivity.class);
        intent.putExtra("TRAINEE_ID", trainee.getId());
        startActivity(intent);
    }

    @Override
    public void onDeleteClick(Lab11Trainee trainee) {
        new AlertDialog.Builder(this)
                .setTitle("Delete Trainee")
                .setMessage("Are you sure you want to delete this trainee?")
                .setPositiveButton("Yes", (dialog, which) -> deleteTrainee(trainee.getId()))
                .setNegativeButton("No", null)
                .show();
    }

    private void deleteTrainee(String id) {
        apiService.deleteTrainee(id).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivityLab11.this, "Trainee deleted successfully", Toast.LENGTH_SHORT).show();
                    loadTrainees();
                } else {
                    Toast.makeText(MainActivityLab11.this, "Failed to delete trainee", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(MainActivityLab11.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
