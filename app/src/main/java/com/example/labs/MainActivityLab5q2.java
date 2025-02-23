package com.example.labs;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivityLab5q2 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Lab5ItemAdapter adapter;
    private List<Lab5Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab5_2);

        items = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Lab5ItemAdapter(this, items);
        recyclerView.setAdapter(adapter);

        loadSampleData();

        FloatingActionButton fabAdd = findViewById(R.id.fabAdd);
        fabAdd.setOnClickListener(v -> showItemDialog(null, -1));

        // Xử lý click để edit
        adapter.setOnItemClickListener((item, position) -> {
            showItemDialog(item, position);
        });

        adapter.setOnItemLongClickListener((item, position) -> {
            showDeleteDialog(position);
        });
    }

    private void showItemDialog(Lab5Item item, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_item, null);

        EditText editName = view.findViewById(R.id.editName);
        EditText editDescription = view.findViewById(R.id.editDescription);
        EditText editType = view.findViewById(R.id.editType);
        EditText editImageUrl = view.findViewById(R.id.editImageUrl);

        if (item != null) {
            editName.setText(item.getName());
            editDescription.setText(item.getDescription());
            editType.setText(item.getType());
            editImageUrl.setText(item.getImageUrl());
        }

        builder.setView(view)
                .setTitle(item == null ? "Add Item" : "Edit Item")
                .setPositiveButton("Save", (dialog, which) -> {
                    String name = editName.getText().toString();
                    String description = editDescription.getText().toString();
                    String type = editType.getText().toString();
                    String imageUrl = editImageUrl.getText().toString();

                    Lab5Item newItem = new Lab5Item(name, description, type, imageUrl);

                    if (position == -1) {
                        adapter.addItem(newItem);
                    } else {
                        adapter.updateItem(position, newItem);
                    }
                })
                .setNegativeButton("Cancel", null)
                .show();
    }

    private void showDeleteDialog(int position) {
        new AlertDialog.Builder(this)
                .setTitle("Delete Item")
                .setMessage("Are you sure you want to delete this item?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    adapter.removeItem(position);
                })
                .setNegativeButton("No", null)
                .show();
    }

    private void loadSampleData() {
        // Smartphones
        items.add(new Lab5Item(
                "iPhone 14 Pro",
                "Apple's flagship smartphone with dynamic island",
                "iOS",
                "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/iphone-14-pro-finish-select-202209-6-7inch-deeppurple?wid=500&hei=500&fmt=jpeg&qlt=95"
        ));

        items.add(new Lab5Item(
                "Samsung Galaxy S23",
                "Latest Android flagship with 200MP camera",
                "Android",
                "https://images.samsung.com/is/image/samsung/p6pim/vn/2302/gallery/vn-galaxy-s23-s911-sm-s911bzgcxxv-thumb-534863401"
        ));

        // Laptops
        items.add(new Lab5Item(
                "MacBook Pro M2",
                "Powerful laptop for professionals",
                "MacOS",
                "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/mbp14-spacegray-select-202301?wid=500&hei=500&fmt=jpeg&qlt=95"
        ));

        items.add(new Lab5Item(
                "Dell XPS 13",
                "Premium Windows ultrabook",
                "Window",
                "https://i.dell.com/is/image/DellContent/content/dam/ss2/product-images/dell-client-products/notebooks/xps-notebooks/xps-13-9315/media-gallery/notebook-xps-9315-nt-blue-gallery-3.psd?fmt=png-alpha&pscan=auto&scl=1&wid=500&hei=500&qlt=100,0&resMode=sharp2&size=500,500"
        ));

        // Tablets
        items.add(new Lab5Item(
                "iPad Air",
                "Versatile tablet for work and play",
                "iOS",
                "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/ipad-air-select-wifi-blue-202203?wid=500&hei=500&fmt=jpeg&qlt=95"
        ));

        items.add(new Lab5Item(
                "Samsung Galaxy Tab S8",
                "Premium Android tablet with S Pen",
                "Android",
                "https://images.samsung.com/is/image/samsung/p6pim/vn/sm-x700nzabxxv/gallery/vn-galaxy-tab-s8-x700-sm-x700nzabxxv-thumb-531435644"
        ));

        adapter.notifyDataSetChanged();
    }
}