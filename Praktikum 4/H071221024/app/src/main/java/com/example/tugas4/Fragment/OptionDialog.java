package com.example.tugas4.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.tugas4.Activity.MainActivity;
import com.example.tugas4.Data.DataSource;
import com.example.tugas4.Model.Post;
import com.example.tugas4.R;

public class OptionDialog extends DialogFragment {

    private Button btnCancel, btnDelete;
    private int userId;

    public OptionDialog(int userId){
        this.userId = userId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_option_dialog, container, false);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnCancel = view.findViewById(R.id.btn_cancel);
        btnDelete = view.findViewById(R.id.btn_delete);

        btnCancel.setOnClickListener( v -> {
            getDialog().cancel();
        });
        btnDelete.setOnClickListener( v -> {
            DataSource.posts.removeIf(post -> post.getUserId() == userId);
            Toast.makeText(MainActivity.context, "Data berhasil dihapus", Toast.LENGTH_SHORT).show();
            AllPostFragment.postAdapter.notifyDataSetChanged();
//            AllPostFragment.postAdapter.onCreateViewHolder();
            getDialog().dismiss();
//            AllPostFragment allPostFragment = new AllPostFragment(MainActivity.context);
//            allPostFragment.onViewCreated();
        });
    }

}