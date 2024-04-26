package com.example.les_prak3.profileitem;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.les_prak3.ProfileActivity;
import com.example.les_prak3.R;
import com.example.les_prak3.StoryActivity;
import com.example.les_prak3.model.ProfileItem;
import com.example.les_prak3.postitem.PostListAdapter;

import java.util.ArrayList;

public class ProfileListAdapter extends RecyclerView.Adapter<ProfileItemViewHolder> {
    private ArrayList<ProfileItem> profileList;

    public ProfileListAdapter(){this.profileList=new ArrayList<ProfileItem>();}

    public void setProfileList(ArrayList<ProfileItem> profileList) {
        this.profileList = profileList;
    }

    @NonNull
    @Override
    public ProfileItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_item,parent,false);

        return new ProfileItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileItemViewHolder holder, int position) {
        ProfileItem profileItem = this.profileList.get(position);
        holder.drawableLogo.setImageResource(profileItem.getDrawableLogo());
        holder.usernameText.setText(profileItem.getUsername());
        holder.followers.setText(profileItem.getFollowers());
        holder.following.setText(profileItem.getFollowing());
        holder.imagePost.setImageResource(profileItem.getImagePost());

    }


    @Override
    public int getItemCount() {
        return this.profileList.size();
    }
}
