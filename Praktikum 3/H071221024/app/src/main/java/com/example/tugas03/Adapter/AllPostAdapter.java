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

import com.example.tugas03.Model.Post;
import com.example.tugas03.Model.Story;
import com.example.tugas03.Model.User;
import com.example.tugas03.R;
import com.example.tugas03.StoryActivity;
import com.example.tugas03.UserActivity;

import java.util.ArrayList;
import java.util.Objects;

public class AllPostAdapter extends RecyclerView.Adapter<AllPostAdapter.ViewHolder>{
    private final ArrayList<User> users;
    private final ArrayList<Post> posts;
    private final ArrayList<Story> stories;
    private Context context;

    public AllPostAdapter(Context context, ArrayList<User> users, ArrayList<Post> posts, ArrayList<Story> stories) {
        this.context = context;
        this.users = users;
        this.posts = posts;
        this.stories = stories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.allpost_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.setData(post);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView ivProfile, ivPost;
        private final TextView tvUsername, tvPostDesc;

        public ViewHolder(View itemView) {
            super(itemView);
            ivProfile = itemView.findViewById(R.id.iv_profile);
            ivPost = itemView.findViewById(R.id.iv_post);
            tvPostDesc = itemView.findViewById(R.id.tv_postdesc);
            tvUsername = itemView.findViewById(R.id.tv_username);
        }

        public void setData(Post post){
            Integer foreignKey = post.getUserId();
            for (User user: users) {
                if(Objects.equals(foreignKey, user.getId())){
                    ivProfile.setImageResource(user.getProfilePic());
                    tvUsername.setText(user.getUsername());
                }
            }
            ivPost.setImageResource(post.getPostPic());
            tvPostDesc.setText(post.getPostDesc());

            ivProfile.setOnClickListener(v -> {
                Intent intent = new Intent(context, StoryActivity.class);
                intent.putExtra("idUser", post.getUserId());
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
                intent.putExtra("idUser", post.getUserId());
                context.startActivity(intent);
            });
        }
    }


}
