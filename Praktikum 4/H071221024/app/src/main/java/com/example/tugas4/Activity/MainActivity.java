package com.example.tugas4.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tugas4.Fragment.AddPostFragment;
import com.example.tugas4.Fragment.AllPostFragment;
import com.example.tugas4.Fragment.ProfileFragment;
import com.example.tugas4.R;

public class MainActivity extends AppCompatActivity {

    public LinearLayout home, addPost, profile;
    public ImageView home_iv, post_iv, profile_iv;
    public TextView home_tv;
    public TextView post_tv;
    public TextView profile_tv;

    @SuppressLint("StaticFieldLeak")
    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        FragmentManager fragmentManager = getSupportFragmentManager();
        AllPostFragment allPostFragment = new AllPostFragment(context);
        AddPostFragment addPostFragment = new AddPostFragment();
        Fragment fragmentAddPost = fragmentManager.findFragmentByTag(AddPostFragment.class.getSimpleName());
        ProfileFragment profileFragment = new ProfileFragment();
        Fragment fragmentProfile = fragmentManager.findFragmentByTag(ProfileFragment.class.getSimpleName());

        Fragment fragmentHome = fragmentManager.findFragmentByTag(AllPostFragment.class.getSimpleName());
        if (!(fragmentHome instanceof AllPostFragment)){
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_layout, allPostFragment, AllPostFragment.class.getSimpleName())
                    .commit();
        }

        home = findViewById(R.id.homeFragment);
        addPost = findViewById(R.id.addPostFragment);
        profile = findViewById(R.id.profileFragment);

        home_iv = findViewById(R.id.home_iv);
        post_iv = findViewById(R.id.post_iv);
        profile_iv = findViewById(R.id.profile_iv);

        home_tv = findViewById(R.id.home_tv);
        post_tv = findViewById(R.id.post_tv);
        profile_tv = findViewById(R.id.profile_tv);

        home.setOnClickListener( v -> {

            home_iv.setImageResource(R.drawable.home_active);
            home_tv.setTextColor(Color.parseColor("#5C12E0"));

            post_iv.setImageResource(R.drawable.add);
            post_tv.setTextColor(Color.parseColor("#808080"));

            profile_iv.setImageResource(R.drawable.profile);
            profile_tv.setTextColor(Color.parseColor("#808080"));

            if (!(fragmentHome instanceof AllPostFragment)){
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_layout, allPostFragment, AllPostFragment.class.getSimpleName())
                        .commit();
            }
        });

        addPost.setOnClickListener( v -> {
            home_iv.setImageResource(R.drawable.home);
            home_tv.setTextColor(Color.parseColor("#808080"));

            post_iv.setImageResource(R.drawable.add_active);
            post_tv.setTextColor(Color.parseColor("#5C12E0"));

            profile_iv.setImageResource(R.drawable.profile);
            profile_tv.setTextColor(Color.parseColor("#808080"));
            if (!(fragmentAddPost instanceof AddPostFragment)){
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_layout, addPostFragment, AddPostFragment.class.getSimpleName())
                        .commit();
            }
        });
        profile.setOnClickListener( v -> {

            home_iv.setImageResource(R.drawable.home);
            home_tv.setTextColor(Color.parseColor("#808080"));

            post_iv.setImageResource(R.drawable.add);
            post_tv.setTextColor(Color.parseColor("#808080"));

            profile_iv.setImageResource(R.drawable.profile_active);
            profile_tv.setTextColor(Color.parseColor("#5C12E0"));
            if(!(fragmentProfile instanceof ProfileFragment)){
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_layout, profileFragment, ProfileFragment.class.getSimpleName())
                        .commit();
            }
        });
    }
}