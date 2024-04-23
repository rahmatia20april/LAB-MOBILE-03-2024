package com.example.tugas4.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tugas4.Activity.MainActivity;
import com.example.tugas4.Adapter.PostAdapter;
import com.example.tugas4.Data.DataSource;
import com.example.tugas4.R;

public class AllPostFragment extends Fragment {

    private Context context;
//    TextView viewNone;
    public static PostAdapter postAdapter;

    public AllPostFragment(Context context){
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_post, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rvPost = view.findViewById(R.id.rv_post);
        rvPost.setHasFixedSize(true);
        postAdapter = new PostAdapter(getChildFragmentManager(), context, DataSource.posts, DataSource.profiles);
        rvPost.setAdapter(postAdapter);
    }
}