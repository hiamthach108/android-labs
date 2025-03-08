package com.example.labs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class Lab9JobAdapter extends RecyclerView.Adapter<Lab9JobAdapter.JobViewHolder> {
    private List<Lab9Job> jobs;

    public Lab9JobAdapter(List<Lab9Job> jobs) {
        this.jobs = jobs;
    }

    public static class JobViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;

        public JobViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
        }
    }

    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_job, parent, false);
        return new JobViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JobViewHolder holder, int position) {
        Lab9Job job = jobs.get(position);
        holder.tvName.setText(job.getName());
    }

    @Override
    public int getItemCount() {
        return jobs.size();
    }
}
