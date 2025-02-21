
package com.example.labs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class Lab5UserAdapter extends RecyclerView.Adapter<Lab5UserAdapter.UserViewHolder> {
    private List<Lab5User> users;

    public Lab5UserAdapter(List<Lab5User> users) {
        this.users = users;
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView tvUsername;
        TextView tvFullname;
        TextView tvEmail;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            tvFullname = itemView.findViewById(R.id.tvFullname);
            tvEmail = itemView.findViewById(R.id.tvEmail);
        }
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Lab5User user = users.get(position);
        holder.tvUsername.setText("Username: " + user.getUsername());
        holder.tvFullname.setText("Fullname: " + user.getFullname());
        holder.tvEmail.setText("Email: " + user.getEmail());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}