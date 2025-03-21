package com.example.labs;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.widget.Toolbar;

public class MainActivityLab6q1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab6_1);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.shareTool:
//                showToast("Bạn đã chọn item Share");
//                return true;
//            case R.id.searchTool:
//                showToast("Bạn đã chọn item Search");
//                return true;
//            case R.id.emailTool:
//                showToast("Bạn đã chọn item Email");
//                return true;
//            case R.id.phoneTool:
//                showToast("Bạn đã chọn item Phone");
//                return true; // Đây là ID được xác định trong menu XML
//            default:
//                return super.onOptionsItemSelected(item);
//        }

        if (item.getItemId() == R.id.shareTool) {
            showToast("Bạn đã chọn item Share");
            return true;
        } else if (item.getItemId() == R.id.searchTool) {
            showToast("Bạn đã chọn item Search");
            return true;
        } else if (item.getItemId() == R.id.emailTool) {
            showToast("Bạn đã chọn item Email");
            return true;
        } else if (item.getItemId() == R.id.phoneTool) {
            showToast("Bạn đã chọn item Phone");
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }


    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
