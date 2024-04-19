package com.example.praktikum4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.security.PublicKey;

public class MainActivity extends AppCompatActivity {
    public ImageView iv_home;
    public ImageView iv_posting;
    public ImageView iv_profile;
    public TextView tv_home;
    public TextView tv_post;
    public TextView tv_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        iv_home = findViewById(R.id.IV_Home);
        iv_posting = findViewById(R.id.IV_Post);
        iv_profile = findViewById(R.id.IV_Profile);
        tv_home = findViewById(R.id.TV_home);
        tv_post = findViewById(R.id.TV_post);
        tv_profile = findViewById(R.id.TV_profile);


        FragmentManager fragmentManager = getSupportFragmentManager();

        HomeFragment homeFragment = new HomeFragment();
        PostinganFragment postinganFragment = new PostinganFragment();
        ProfileFragment profileFragment = new ProfileFragment();

        Fragment fragment = fragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());

        if (!(fragment instanceof HomeFragment)){
            fragmentManager
                    .beginTransaction()
                    .add(R.id.frame_container, homeFragment)
                    .commit();
        }



        iv_home.setOnClickListener(v -> {
            Fragment fragment1 = fragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());
            if (!(fragment1 instanceof HomeFragment)){
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container, homeFragment, HomeFragment.class.getSimpleName())
                        .commit();
            }

            iv_home.setBackgroundColor(Color.parseColor("#E33DFF"));
            tv_home.setTextColor(Color.parseColor("#E33DFF"));

            iv_posting.setBackgroundColor(Color.parseColor("#A6A6A6"));
            tv_post.setTextColor(Color.parseColor("#A6A6A6"));

            iv_profile.setBackgroundColor(Color.parseColor("#A6A6A6"));
            tv_profile.setTextColor(Color.parseColor("#A6A6A6"));
        });

        iv_posting.setOnClickListener(v -> {
            Fragment fragment2 = fragmentManager.findFragmentByTag(PostinganFragment.class.getSimpleName());
            if (!(fragment2 instanceof PostinganFragment)){
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container, postinganFragment, PostinganFragment.class.getSimpleName())
                        .commit();
            }

            iv_posting.setBackgroundColor(Color.parseColor("#E33DFF"));
            tv_post.setTextColor(Color.parseColor("#E33DFF"));

            iv_home.setBackgroundColor(Color.parseColor("#A6A6A6"));
            tv_home.setTextColor(Color.parseColor("#A6A6A6"));

            iv_profile.setBackgroundColor(Color.parseColor("#A6A6A6"));
            tv_profile.setTextColor(Color.parseColor("#A6A6A6"));

        });

        iv_profile.setOnClickListener(v -> {
            Fragment fragment3 = fragmentManager.findFragmentByTag(ProfileFragment.class.getSimpleName());
            if (!(fragment3 instanceof ProfileFragment)){
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container, profileFragment, ProfileFragment.class.getSimpleName())
                        .commit();
            }

            iv_profile.setBackgroundColor(Color.parseColor("#E33DFF"));
            tv_profile.setTextColor(Color.parseColor("#E33DFF"));

            iv_posting.setBackgroundColor(Color.parseColor("#A6A6A6"));
            tv_post.setTextColor(Color.parseColor("#A6A6A6"));

            iv_home.setBackgroundColor(Color.parseColor("#A6A6A6"));
            tv_home.setTextColor(Color.parseColor("#A6A6A6"));

        });

    }

}