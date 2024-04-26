package com.example.praktikum4;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class HomeFragment extends Fragment {

    public static final String EXTRA_POSTINGAN= "extra_postingan";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rvPostingan = view.findViewById(R.id.rv_post);
        rvPostingan.setHasFixedSize(true);
        PostinganAdapter postinganAdapter = new PostinganAdapter(DataSource.postingans);
        rvPostingan.setAdapter(postinganAdapter);


        Bundle bundle = getArguments();
        if (bundle != null) {
            Postingan postingan = bundle.getParcelable(EXTRA_POSTINGAN);
            if (postingan != null) {
                DataSource.postingans.add(0, postingan);
                postinganAdapter.notifyDataSetChanged();
            }
        }

    }
}