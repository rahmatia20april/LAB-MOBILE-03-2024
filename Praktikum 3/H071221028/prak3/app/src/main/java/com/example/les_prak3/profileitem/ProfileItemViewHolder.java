package com.example.les_prak3.profileitem;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.les_prak3.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileItemViewHolder extends RecyclerView.ViewHolder {

    CircleImageView drawableLogo;
    TextView usernameText, followers, following;
    ImageView imagePost;
    public ProfileItemViewHolder(@NonNull View itemView) {
        super(itemView);
        this.drawableLogo = itemView.findViewById(R.id.story_user_image);
        this.usernameText = itemView.findViewById(R.id.tv_username);
        this.followers = itemView.findViewById(R.id.angka_followers);
        this.following = itemView.findViewById(R.id.angka_tv_following);
        this.imagePost = itemView.findViewById(R.id.iv_post);
    }
}
