package com.example.labs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Lab11TraineeAdapter extends RecyclerView.Adapter<Lab11TraineeAdapter.TraineeViewHolder> {
    private final List<Lab11Trainee> traineeList;
    private final OnTraineeClickListener listener;

    public Lab11TraineeAdapter(List<Lab11Trainee> traineeList, OnTraineeClickListener listener) {
        this.traineeList = traineeList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public TraineeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trainee, parent, false);
        return new TraineeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TraineeViewHolder holder, int position) {
        Lab11Trainee trainee = traineeList.get(position);
        holder.bind(trainee, listener);
    }

    @Override
    public int getItemCount() {
        return traineeList.size();
    }

    public void updateData(List<Lab11Trainee> newList) {
        this.traineeList.clear();
        this.traineeList.addAll(newList);
        notifyDataSetChanged();
    }

    public interface OnTraineeClickListener {
        void onEditClick(Lab11Trainee trainee);
        void onDeleteClick(Lab11Trainee trainee);
    }

    static class TraineeViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvName, tvEmail, tvPhone, tvGender;
        private final Button btnEdit, btnDelete;

        public TraineeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            tvGender = itemView.findViewById(R.id.tvGender);
            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }

        public void bind(final Lab11Trainee trainee, final OnTraineeClickListener listener) {
            tvName.setText(trainee.getName());
            tvEmail.setText(trainee.getEmail());
            tvPhone.setText(trainee.getPhone());
            tvGender.setText(trainee.getGender());

            btnEdit.setOnClickListener(v -> listener.onEditClick(trainee));
            btnDelete.setOnClickListener(v -> listener.onDeleteClick(trainee));
        }
    }
}