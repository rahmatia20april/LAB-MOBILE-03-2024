package com.example.les_prak3.postitem;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.les_prak3.ProfileActivity;
import com.example.les_prak3.R;
import com.example.les_prak3.StoryActivity;
import com.example.les_prak3.model.PostItem;

import java.util.ArrayList;

public class PostListAdapter extends RecyclerView.Adapter<PostItemViewHolder> {
    private ArrayList<PostItem> postList;

    public PostListAdapter() { this.postList = new ArrayList<PostItem>(); }

    public void setPostList(ArrayList<PostItem> items) { this.postList = items; }

    @NonNull
    @Override
    public PostItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);

        return new PostItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostItemViewHolder holder, int position) {
        PostItem postItem = this.postList.get(position);
        holder.description.setText(postItem.getDescription());
        holder.userImage.setImageResource(postItem.getDrawableLogo());
        holder.image.setImageResource(postItem.getDrawablePost());
        holder.usernameText.setText(postItem.getUsername());
        holder.usernameText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), ProfileActivity.class);
                intent.putExtra("USERNAME", postItem.getUsername());
                holder.itemView.getContext().startActivity(intent);
            }
        });
        holder.userImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), StoryActivity.class);
                intent.putExtra("USERNAME", postItem.getUsername());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.postList.size();
    }
}

