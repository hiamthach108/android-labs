package com.example.labs;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivityLab6q2 extends AppCompatActivity {

    Button btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab6_2);

        btnMenu = findViewById(R.id.btnMenu);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMenu();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void showMenu() {
        PopupMenu popupMenu = new PopupMenu(MainActivityLab6q2.this, btnMenu);

        popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
//                switch (menuItem.getItemId()) {
//                    case R.id.menuThem:
//                        btnMenu.setText("Menu Them");
//                        return true;
//                    case R.id.menuSua:
//                        btnMenu.setText("Menu Sua");
//                        return true;
//                    case R.id.menuXoa:
//                        btnMenu.setText("Menu Xoa");
//                        return true;
//                    default:
//                        return false;
//                }
                if (menuItem.getItemId() == R.id.menuThem) {
                    btnMenu.setText("Menu Them");
                    return true;
                } else if (menuItem.getItemId() == R.id.menuSua) {
                    btnMenu.setText("Menu Sua");
                    return true;
                } else if (menuItem.getItemId() == R.id.menuXoa) {
                    btnMenu.setText("Menu Xoa");
                    return true;
                } else {
                    return false;
                }
            }
        });

        popupMenu.show();
    }
}