package com.example.labs;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivityLab3q2 extends AppCompatActivity {

    ListView listView;
    EditText editTitle, editDescription, editImageUrl;
    Button btnAdd, btnUpdate;
    List<Item> itemList;
    CustomAdapter adapter;
    int selectedIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3_2);

        listView = findViewById(R.id.listView);
        editTitle = findViewById(R.id.editTitle);
        editDescription = findViewById(R.id.editDescription);
        editImageUrl = findViewById(R.id.editImageUrl);
        btnAdd = findViewById(R.id.btnAdd);
        btnUpdate = findViewById(R.id.btnUpdate);

        itemList = new ArrayList<>();
        itemList.add(new Item("Chuối tiêu", "Chuối tiêu Long An", "https://toplist.vn/images/800px/chuoi-29988.jpg"));
        itemList.add(new Item("Thanh long", "Thanh long ruột đỏ", "https://www.locthanhan.vn/upload/sanpham/thanh-long-ruot-do-613.jpg"));
        itemList.add(new Item("Dâu tây", "Dâu tây Đà Lạt", "https://binhdienonline.com/thumbs_size/product/2021_03/dau-tay/[1200x630-fmi]dau-tay--23.jpg"));
        itemList.add(new Item("Dưa hấu", "Dưa hấu Tiền Giang", "https://suckhoedoisong.qltns.mediacdn.vn/324455921873985536/2021/9/11/dua-hau1-16312946583971594822110.jpg"));
        itemList.add(new Item("Cam vàng", "Cam vàng nhập khẩu", "https://www.godelivery.mu/wp-content/uploads/2020/06/1_0010_Orange-Valencia.jpg"));

        adapter = new CustomAdapter(this, itemList);
        listView.setAdapter(adapter);

        // Thêm item
        btnAdd.setOnClickListener(v -> {
            String title = editTitle.getText().toString().trim();
            String description = editDescription.getText().toString().trim();
            String imageUrl = editImageUrl.getText().toString().trim();

            if (!title.isEmpty() && !description.isEmpty() && !imageUrl.isEmpty()) {
                itemList.add(new Item(title, description, imageUrl));
                adapter.notifyDataSetChanged();
                clearInputs();
            }
        });

        // Chọn item để chỉnh sửa
        listView.setOnItemClickListener((parent, view, position, id) -> {
            selectedIndex = position;
            Item selectedItem = itemList.get(position);
            editTitle.setText(selectedItem.getTitle());
            editDescription.setText(selectedItem.getDescription());
            editImageUrl.setText(selectedItem.getImageUrl());
        });

        // Cập nhật item
        btnUpdate.setOnClickListener(v -> {
            if (selectedIndex != -1) {
                itemList.get(selectedIndex).setTitle(editTitle.getText().toString().trim());
                itemList.get(selectedIndex).setDescription(editDescription.getText().toString().trim());
                itemList.get(selectedIndex).setImageUrl(editImageUrl.getText().toString().trim());
                adapter.notifyDataSetChanged();
                clearInputs();
                selectedIndex = -1;
            }
        });

        // Xóa item khi nhấn giữ
        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            new AlertDialog.Builder(MainActivityLab3q2.this)
                    .setTitle("Xóa?")
                    .setMessage("Bạn có chắc muốn xóa không?")
                    .setPositiveButton("Có", (dialog, which) -> {
                        itemList.remove(position);
                        adapter.notifyDataSetChanged();
                    })
                    .setNegativeButton("Không", null)
                    .show();
            return true;
        });
    }

    private void clearInputs() {
        editTitle.setText("");
        editDescription.setText("");
        editImageUrl.setText("");
    }
}

