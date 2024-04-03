package com.example.tugas03.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugas03.Data.DataSource;
import com.example.tugas03.Model.Post;
import com.example.tugas03.Model.Story;
import com.example.tugas03.Model.User;
import com.example.tugas03.R;
import com.example.tugas03.StoryActivity;
import com.example.tugas03.UserActivity;

import java.util.ArrayList;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {
    private final ArrayList<User> users;
    private final ArrayList<Post> posts;
    private final ArrayList<Story> stories;
    private Context context;

    public StoryAdapter(Context context, ArrayList<User> users, ArrayList<Post> posts, ArrayList<Story> stories) {
        this.context = context;
        this.users = users;
        this.posts = posts;
        this.stories = stories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.story_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = users.get(position);
        holder.setData(user);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView ivImage;
        private final TextView tvUsername;

        public ViewHolder(View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.story_image);
            tvUsername = itemView.findViewById(R.id.story_text);
        }

        public void setData(User user){
            ivImage.setImageResource(user.getProfilePic());
            tvUsername.setText(user.getUsername());
//            if(user.getUsername().length() > 8){
//                String modifiedUsername = user.getUsername().substring(0,6) + "...";
//                tvUsername.setText(modifiedUsername);
//            } else {
//                tvUsername.setText(user.getUsername());
//            }
            ivImage.setOnClickListener(v -> {
                Intent intent = new Intent(context, StoryActivity.class);
                intent.putExtra("idUser", user.getId());
                intent.putExtra("users", users);
                intent.putExtra("posts", posts);
                intent.putExtra("stories", stories);
                context.startActivity(intent);
            });
            tvUsername.setOnClickListener(v -> {
                Intent intent = new Intent(context, UserActivity.class);
                intent.putExtra("users",  users);
                intent.putExtra("posts", posts);
                intent.putExtra("stories", stories);
                intent.putExtra("idUser", user.getId());
                context.startActivity(intent);
            });
        }
    }
}
