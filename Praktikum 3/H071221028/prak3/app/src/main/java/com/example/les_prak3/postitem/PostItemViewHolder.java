package com.example.les_prak3.postitem;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.les_prak3.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostItemViewHolder extends RecyclerView.ViewHolder {
    TextView usernameText, description;
    CircleImageView userImage;
    ImageView image;

    public PostItemViewHolder(@NonNull View itemView) {
        super(itemView);
        this.userImage = itemView.findViewById(R.id.post_user_image);
        this.image = itemView.findViewById(R.id.post_image);
        this.usernameText = itemView.findViewById(R.id.post_username_tv);
        this.description = itemView.findViewById(R.id.post_description);
    }
}


