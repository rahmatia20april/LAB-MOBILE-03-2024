package com.example.les_prak3.storyitem;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.les_prak3.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class StoryItemViewHolder extends RecyclerView.ViewHolder {
    TextView usenameText;
    CircleImageView storyImage;
    public StoryItemViewHolder(@NonNull View itemView) {
        super(itemView);
        this.usenameText = itemView.findViewById(R.id.tv_username);
        this.storyImage = itemView.findViewById(R.id.story_user_image);
    }
}
