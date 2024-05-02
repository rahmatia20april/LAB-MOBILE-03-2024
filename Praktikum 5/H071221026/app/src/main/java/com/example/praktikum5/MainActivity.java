package com.example.praktikum5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.praktikum5.HomeFragment;

public class MainActivity extends AppCompatActivity {
    public ImageView iv_home;
    public ImageView iv_post;
    public ImageView iv_search;
    public ImageView iv_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_home = findViewById(R.id.IV_Home);
        iv_post = findViewById(R.id.IV_Post);
        iv_search = findViewById(R.id.IV_Search);
        iv_profile = findViewById(R.id.IV_Profile);

        FragmentManager fragmentManager = getSupportFragmentManager();

        HomeFragment homeFragment = new HomeFragment();
        PostinganFragment postinganFragment = new PostinganFragment();
        SearchFragment searchFragment = new SearchFragment();
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

            iv_home.setBackground(getResources().getDrawable(R.drawable.bgnav));
            iv_post.setBackground(getResources().getDrawable(R.drawable.navbar));
            iv_search.setBackground(getResources().getDrawable(R.drawable.navbar));
            iv_profile.setBackground(getResources().getDrawable(R.drawable.navbar));
        });

        iv_post.setOnClickListener(v -> {
            Fragment fragment2 = fragmentManager.findFragmentByTag(PostinganFragment.class.getSimpleName());
            if (!(fragment2 instanceof PostinganFragment)){
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container, postinganFragment, PostinganFragment.class.getSimpleName())
                        .commit();
            }

            iv_home.setBackground(getResources().getDrawable(R.drawable.navbar));
            iv_post.setBackground(getResources().getDrawable(R.drawable.bgnav));
            iv_search.setBackground(getResources().getDrawable(R.drawable.navbar));
            iv_profile.setBackground(getResources().getDrawable(R.drawable.navbar));

        });

        iv_search.setOnClickListener(v -> {
            Fragment fragment3 = fragmentManager.findFragmentByTag(SearchFragment.class.getSimpleName());
            if (!(fragment3 instanceof SearchFragment)){
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container, searchFragment, SearchFragment.class.getSimpleName())
                        .commit();
            }

            iv_home.setBackground(getResources().getDrawable(R.drawable.navbar));
            iv_post.setBackground(getResources().getDrawable(R.drawable.navbar));
            iv_search.setBackground(getResources().getDrawable(R.drawable.bgnav));
            iv_profile.setBackground(getResources().getDrawable(R.drawable.navbar));

        });

        iv_profile.setOnClickListener(v -> {
            Fragment fragment4 = fragmentManager.findFragmentByTag(ProfileFragment.class.getSimpleName());
            if (!(fragment4 instanceof ProfileFragment)){
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container, profileFragment, ProfileFragment.class.getSimpleName())
                        .commit();
            }

            iv_home.setBackground(getResources().getDrawable(R.drawable.navbar));
            iv_post.setBackground(getResources().getDrawable(R.drawable.navbar));
            iv_search.setBackground(getResources().getDrawable(R.drawable.navbar));
            iv_profile.setBackground(getResources().getDrawable(R.drawable.bgnav));

        });
    }
}