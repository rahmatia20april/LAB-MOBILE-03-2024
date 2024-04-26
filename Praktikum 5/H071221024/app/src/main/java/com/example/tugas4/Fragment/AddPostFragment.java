package com.example.tugas4.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.tugas4.Activity.MainActivity;
import com.example.tugas4.Data.DataSource;
import com.example.tugas4.Model.Post;
import com.example.tugas4.R;
import com.google.android.material.textfield.TextInputEditText;

public class AddPostFragment extends Fragment {

    public TextInputEditText content;
    ImageButton imgButton;
    Button btnPost;
    String contentText;

    public Uri imagePost;
    Intent galleryIntent;

    private ActivityResultLauncher<Intent> galleryLauncher;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_post, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        content = view.findViewById(R.id.content);
        imgButton = view.findViewById(R.id.imageButton);
        btnPost = view.findViewById(R.id.btn_post);

        if (imagePost != null){
            Glide.with(this).load(imagePost).into(imgButton);
        }

        imgButton.setOnClickListener(v -> {
            galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            galleryLauncher.launch(galleryIntent);
//            galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
//            galleryIntent.setType("image/*");
//            galleryLauncher.launch(galleryIntent);
        });

        galleryLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if(result.getResultCode() == Activity.RESULT_OK && result.getData() != null){
                        imagePost = result.getData().getData();
                        Glide.with(this).load(imagePost).into(imgButton);
                    }
                });

        btnPost.setOnClickListener(v -> {
            contentText = content.getText().toString().trim();
            Post post = new Post(imagePost, contentText, 7);
            if (contentText.isEmpty()){
                Toast.makeText(MainActivity.context, "Anda belum mengisi konten!", Toast.LENGTH_SHORT).show();
                return;
            } else if (post.getImagePostUpload() == null){
                Toast.makeText(MainActivity.context, "Anda belum mengupload gambar!", Toast.LENGTH_SHORT).show();
                return;
            } else if (contentText.isEmpty() && post.getImagePostUpload() == null){
                Toast.makeText(MainActivity.context, "Anda belum mengisi konten!", Toast.LENGTH_SHORT).show();
                return;
            } else {
                DataSource.posts.add(0, post);
                content.setText(null);
                imagePost = null;
                Toast.makeText(MainActivity.context, "Post Berhasil Ditambahkan!", Toast.LENGTH_SHORT).show();
            }
            AllPostFragment allPostFragment = new AllPostFragment(MainActivity.context);
            FragmentManager fragmentManager = getParentFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_layout, allPostFragment, AllPostFragment.class.getSimpleName())
                    .commit();
            MainActivity mainActivity = (MainActivity) getActivity();
            mainActivity.home_iv.setImageResource(R.drawable.home_active);
            mainActivity.home_tv.setTextColor(Color.parseColor("#5C12E0"));

            mainActivity.post_iv.setImageResource(R.drawable.add);
            mainActivity.post_tv.setTextColor(Color.parseColor("#808080"));

            mainActivity.profile_iv.setImageResource(R.drawable.profile);
            mainActivity.profile_tv.setTextColor(Color.parseColor("#808080"));
        });
    }
}