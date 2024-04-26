package com.example.tugas4.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tugas4.Activity.ProfileActivity;
import com.example.tugas4.Fragment.AllPostFragment;
import com.example.tugas4.Fragment.OptionDialog;
import com.example.tugas4.Model.Post;
import com.example.tugas4.Model.Profile;
import com.example.tugas4.R;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private final ArrayList<Post> posts;
    private final ArrayList<Profile> profiles;
    private Context context;
    private FragmentManager fragmentManager;

    public PostAdapter(FragmentManager fragmentManager, Context context, ArrayList<Post> posts, ArrayList<Profile> profiles){
        this.fragmentManager = fragmentManager;
        this.context = context;
        this.posts = posts;
        this.profiles = profiles;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.setData(post, profiles);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private final ImageView profilePic, postPic;
        private final TextView fullname, username, content;
        private final LinearLayout nameLayout;
        private final ImageButton deleteBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profilePic = itemView.findViewById(R.id.profilePic);
            postPic = itemView.findViewById(R.id.postPic);
            fullname = itemView.findViewById(R.id.fullname);
            username = itemView.findViewById(R.id.username);
            content = itemView.findViewById(R.id.content);
            deleteBtn = itemView.findViewById(R.id.deleteBtn);
            nameLayout = itemView.findViewById(R.id.nameLayout);
        }
        public void setData(Post post, ArrayList<Profile> profiles){
            for (Profile profile : profiles) {
                if (post.getUserId() == profile.getId()){
                    profilePic.setImageResource(profile.getImageProfile());
                    fullname.setText(profile.getFullname());
                    username.setText(profile.getUsername());
                }
            }
            content.setText(post.getContent());
            if (post.getImagePostUpload() != null){
                Glide.with(itemView).load(post.getImagePostUpload()).into(postPic);
            } else {
                postPic.setImageResource(post.getImagePost());
            }
            profilePic.setOnClickListener(v -> {
                Intent intent = new Intent(context, ProfileActivity.class);
                for (Profile profile: profiles) {
                    if (post.getUserId() == profile.getId()){
                        intent.putExtra("profilePic", profile.getImageProfile());
                        intent.putExtra("fullname", profile.getFullname());
                        intent.putExtra("username", profile.getUsername());
                    }
                }
                context.startActivity(intent);
            });
            nameLayout.setOnClickListener(v -> {
                Intent intent = new Intent(context, ProfileActivity.class);
                for (Profile profile: profiles) {
                    if (post.getUserId() == profile.getId()){
                        intent.putExtra("profilePic", profile.getImageProfile());
                        intent.putExtra("fullname", profile.getFullname());
                        intent.putExtra("username", profile.getUsername());
                    }
                }
                context.startActivity(intent);
            });
            deleteBtn.setOnClickListener( v -> {
                OptionDialog optionDialog = new OptionDialog(post.getUserId());
                optionDialog.show(fragmentManager,
                        OptionDialog.class.getSimpleName());
            });
        }
    }
}
