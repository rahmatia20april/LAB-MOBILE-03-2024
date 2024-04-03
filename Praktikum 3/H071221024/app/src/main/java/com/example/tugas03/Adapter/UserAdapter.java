package com.example.tugas03.Adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugas03.Model.Post;
import com.example.tugas03.Model.Story;
import com.example.tugas03.Model.User;
import com.example.tugas03.PostActvity;
import com.example.tugas03.R;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.viewHolder> {
    private final ArrayList<User> users;
    private final ArrayList<Post> posts;
    private final ArrayList<Story> stories;
    private Context context;
    private int userId;

    public UserAdapter(Context context, ArrayList<User> users, ArrayList<Post> posts, ArrayList<Story> stories, int userId) {
        this.users = users;
        this.posts = posts;
        this.stories = stories;
        this.context = context;
        this.userId = userId;
    }

    @NonNull
    @Override
    public UserAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_item, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.viewHolder holder, int position) {
        ArrayList<Post> postsByUser = new ArrayList<>();
        for (Post post: posts) {
            if(post.getUserId() == userId){
                postsByUser.add(post);
            }
        }
        Post postByUser = postsByUser.get(position);
        holder.setData(postByUser, position);
    }

    @Override
    public int getItemCount() {
        int count = 0;
        for (Post post: posts) {
            if(post.getUserId() == userId){
                count += 1;
            }
        }
        return count;
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        private final ImageView imagePost;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imagePost = itemView.findViewById(R.id.imagePost);
        }
        public void setData(Post post, Integer position){
            imagePost.setImageResource(post.getPostPic());
            imagePost.setOnClickListener(v -> {
                Intent intent = new Intent(context, PostActvity.class);
                intent.putExtra("idUser", post.getUserId());
                intent.putExtra("idPost", post.getId());
                intent.putExtra("users", users);
                intent.putExtra("posts", posts);
                intent.putExtra("stories", stories);
                context.startActivity(intent);
            });
        }
    }
}
