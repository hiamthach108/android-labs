package com.example.labs;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddEditTraineeActivity extends AppCompatActivity {
    private EditText etName, etEmail, etPhone;
    private RadioGroup rgGender;
    private RadioButton rbMale, rbFemale;
    private String traineeId;
    private TraineeApiService apiService;
    private boolean isEditMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_trainee);

        // Khởi tạo các views
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        rgGender = findViewById(R.id.rgGender);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        Button btnSave = findViewById(R.id.btnSave);

        // Khởi tạo Retrofit
        apiService = RetrofitClient.getInstance().getApiService();

        // Kiểm tra xem đang trong chế độ Edit hay không
        traineeId = getIntent().getStringExtra("TRAINEE_ID");
        isEditMode = traineeId != null;

        if (isEditMode) {
            setTitle("Edit Trainee");
            loadTraineeData();
        } else {
            setTitle("Add New Trainee");
        }

        btnSave.setOnClickListener(v -> saveTrainee());
    }

    private void loadTraineeData() {
        apiService.getTrainee(traineeId).enqueue(new Callback<Lab11Trainee>() {
            @Override
            public void onResponse(Call<Lab11Trainee> call, Response<Lab11Trainee> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Lab11Trainee trainee = response.body();
                    etName.setText(trainee.getName());
                    etEmail.setText(trainee.getEmail());
                    etPhone.setText(trainee.getPhone());

                    if ("Male".equals(trainee.getGender())) {
                        rbMale.setChecked(true);
                    } else {
                        rbFemale.setChecked(true);
                    }
                } else {
                    Toast.makeText(AddEditTraineeActivity.this, "Failed to load trainee data", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }

            @Override
            public void onFailure(Call<Lab11Trainee> call, Throwable t) {
                Toast.makeText(AddEditTraineeActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private void saveTrainee() {
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String gender = rbMale.isChecked() ? "Male" : "Female";

        // Validate input
        if (name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        Lab11Trainee trainee = new Lab11Trainee(name, email, phone, gender);

        if (isEditMode) {
            // Update existing trainee
            apiService.updateTrainee(traineeId, trainee).enqueue(new Callback<Lab11Trainee>() {
                @Override
                public void onResponse(Call<Lab11Trainee> call, Response<Lab11Trainee> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(AddEditTraineeActivity.this, "Trainee updated successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(AddEditTraineeActivity.this, "Failed to update trainee", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Lab11Trainee> call, Throwable t) {
                    Toast.makeText(AddEditTraineeActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            // Create new trainee
            apiService.createTrainee(trainee).enqueue(new Callback<Lab11Trainee>() {
                @Override
                public void onResponse(Call<Lab11Trainee> call, Response<Lab11Trainee> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(AddEditTraineeActivity.this, "Trainee added successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(AddEditTraineeActivity.this, "Failed to add trainee", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Lab11Trainee> call, Throwable t) {
                    Toast.makeText(AddEditTraineeActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}