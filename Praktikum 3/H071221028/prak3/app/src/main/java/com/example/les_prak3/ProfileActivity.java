package com.example.les_prak3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.les_prak3.model.ProfileItem;
import com.example.les_prak3.postitem.PostListAdapter;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageView IV_Profile = findViewById(R.id.story_user_image);
        TextView TV_username = findViewById(R.id.tv_username);
        TextView TV_Followers = findViewById(R.id.angka_followers);
        TextView TV_Following = findViewById(R.id.angka_tv_following);
        ImageView IV_Postingan = findViewById(R.id.iv_post);

        ProfileList profileList = new ProfileList();

        Intent intent = getIntent();

        IV_Profile.setOnClickListener(v -> {
            String username = intent.getStringExtra("USERNAME");
            if (username != null) {
                ProfileItem profileItem = profileList.getProfileItemByUsername(username);
                Intent storyIntent = new Intent(ProfileActivity.this, StoryActivity.class);
                storyIntent.putExtra("USERNAME", username);
                startActivity(storyIntent);
            }
        });

        IV_Postingan.setOnClickListener(v -> {
            String username = intent.getStringExtra("USERNAME");
            if (username != null) {

                ProfileItem profileItem = profileList.getProfileItemByUsername(username);
                Intent storyIntent = new Intent(ProfileActivity.this, PostinganActivity.class);
                storyIntent.putExtra("USERNAME", username);
                startActivity(storyIntent);
            }
        });

        if (intent != null) {
            String username = intent.getStringExtra("USERNAME");
            if (username != null) {
                ProfileItem profileItem = profileList.getProfileItemByUsername(username);
                IV_Profile.setImageResource(profileItem.getDrawableLogo());
                TV_username.setText(profileItem.getUsername());
                TV_Followers.setText(profileItem.getFollowers());
                TV_Following.setText(profileItem.getFollowing());
                IV_Postingan.setImageResource(profileItem.getImagePost());
            }
        }
    }
}
