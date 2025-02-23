package com.example.labs;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.google.android.material.chip.Chip;
import java.util.ArrayList;
import java.util.List;

public class Lab5ItemAdapter extends RecyclerView.Adapter<Lab5ItemAdapter.ViewHolder> {
    private List<Lab5Item> items;
    private Context context;
    private OnItemLongClickListener longClickListener;
    private OnItemClickListener clickListener;

    public interface OnItemLongClickListener {
        void onItemLongClick(Lab5Item item, int position);
    }

    public Lab5ItemAdapter(Context context, List<Lab5Item> items) {
        this.context = context;
        this.items = items;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        this.longClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lab5, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Lab5Item item = items.get(position);
        holder.textName.setText(item.getName());
        holder.textDescription.setText(item.getDescription());
        holder.textType.setText(item.getType());

        Glide.with(context)
                .load(item.getImageUrl())
                .into(holder.imageView);

        // Thêm click listener
        holder.itemView.setOnClickListener(v -> {
            if (clickListener != null) {
                clickListener.onItemClick(item, position);
            }
        });

        holder.itemView.setOnLongClickListener(v -> {
            if (longClickListener != null) {
                longClickListener.onItemLongClick(item, position);
            }
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void updateItem(int position, Lab5Item item) {
        items.set(position, item);
        notifyItemChanged(position);
    }

    public void removeItem(int position) {
        items.remove(position);
        notifyItemRemoved(position);
    }

    public void addItem(Lab5Item item) {
        items.add(item);
        notifyItemInserted(items.size() - 1);
    }

    // Interface cho click event
    public interface OnItemClickListener {
        void onItemClick(Lab5Item item, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.clickListener = listener;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textName, textDescription, textType;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textName = itemView.findViewById(R.id.textName);
            textDescription = itemView.findViewById(R.id.textDescription);
            textType = itemView.findViewById(R.id.textType);
        }
    }
}