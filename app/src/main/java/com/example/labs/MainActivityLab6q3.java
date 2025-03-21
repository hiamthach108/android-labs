package com.example.labs;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.ContextMenu;
import androidx.appcompat.widget.Toolbar;

public class MainActivityLab6q3 extends AppCompatActivity {

    Button btnChonMau;
    ConstraintLayout manHinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab6_3);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btnChonMau = findViewById(R.id.button_Chonmau);
        manHinh = findViewById(R.id.manHinh);

        registerForContextMenu(btnChonMau);

        btnChonMau.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                openContextMenu(v);
                return true;
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.manHinh), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuDo) {
            manHinh.setBackgroundColor(Color.RED);
        } else if (item.getItemId() == R.id.menuVang) {
            manHinh.setBackgroundColor(Color.YELLOW);
        } else if (item.getItemId() == R.id.menuXanh) {
            manHinh.setBackgroundColor(Color.BLUE);
        }
        return super.onContextItemSelected(item);
    }
}