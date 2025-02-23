// MenuAdapter.java
package com.example.labs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuAdapter extends ArrayAdapter<MenuItem> {
    private Context context;
    private ArrayList<MenuItem> items;

    public MenuAdapter(Context context, ArrayList<MenuItem> items) {
        super(context, 0, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.menu_item_layout, parent, false);
        }

        MenuItem currentItem = items.get(position);

        ImageView imageView = convertView.findViewById(R.id.itemImage);
        TextView nameText = convertView.findViewById(R.id.itemName);
        TextView descriptionText = convertView.findViewById(R.id.itemDescription);
        TextView priceText = convertView.findViewById(R.id.itemPrice);
        nameText.setText(currentItem.getName());
        descriptionText.setText(currentItem.getDescription());
        priceText.setText(String.format("%.0f VNĐ", currentItem.getPrice()));

        return convertView;
    }
}