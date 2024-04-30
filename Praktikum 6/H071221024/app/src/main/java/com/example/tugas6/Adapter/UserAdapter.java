package com.example.tugas6.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tugas6.Activity.ProfileActivity;
import com.example.tugas6.Model.User;
import com.example.tugas6.R;
import com.example.tugas6.Response.UserResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    public List<User> userList;
    public Context context;
    public UserAdapter(List<User> userList, Context context){
        this.userList = userList;
        this.context = context;
    }
    @androidx.annotation.NonNull
    public UserViewHolder onCreateViewHolder(ViewGroup parent,
                                             int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view);
    }
    public void onBindViewHolder(UserViewHolder holder, int
            position) {
        User user = userList.get(position);
        holder.bind(user, context);
    }
    public int getItemCount() {
        return userList.size();
    }
    public static class UserViewHolder extends RecyclerView.ViewHolder {
        private final ImageView avatarImageView;
        private final TextView nameTextView;
        private final TextView emailTextView;
//        private final LinearLayout layoutItem;
        public UserViewHolder(View itemView) {
            super(itemView);
            avatarImageView = itemView.findViewById(R.id.avatarImageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            emailTextView = itemView.findViewById(R.id.emailTextView);
//            layoutItem = itemView.findViewById(R.id.layoutItem);
        }
        @SuppressLint("SetTextI18n")
        public void bind(User user, Context context) {
            Picasso.get().load(user.getAvatar()).into(avatarImageView);
            nameTextView.setText(user.getFirst_name() + " " + user.getLast_name());
            emailTextView.setText(user.getEmail());

            itemView.setOnClickListener( v -> {
                Intent intent = new Intent(context, ProfileActivity.class);
                intent.putExtra("id", user.getId());
                context.startActivity(intent);
            });
        }
    }

}
