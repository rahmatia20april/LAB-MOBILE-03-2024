package com.example.praktikum4;

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

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class PostinganFragment extends Fragment {

    private Uri selectedImageUri;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_postingan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        ImageView iv_foto = view.findViewById(R.id.iv_gambar);
        EditText ET_konten = view.findViewById(R.id.et_konten);
        Button btn_posting = view.findViewById(R.id.btn_posting);

        ActivityResultLauncher<Intent> launcherIntentGallery = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            selectedImageUri = data.getData();
                            if (selectedImageUri != null) {
                                iv_foto.setImageURI(selectedImageUri);
                            }
                        }
                    }
                }
        );

        iv_foto.setOnClickListener(v -> {
            Intent openGallery = new Intent(Intent.ACTION_PICK);
            openGallery.setType("image/*");
            launcherIntentGallery.launch(openGallery);
        });

        btn_posting.setOnClickListener(btn ->{
            String konten = ET_konten.getText().toString();

            if (konten.isEmpty()) {
                Toast.makeText(getActivity(), "Isi konten terlebih dahulu", Toast.LENGTH_SHORT).show();
            } else if (selectedImageUri != null) {
                Postingan postingan = new Postingan("Sokugeki no Souma", "Souma", konten, R.drawable.souma_profile, selectedImageUri);
                Bundle bundle = new Bundle();
                bundle.putParcelable(HomeFragment.EXTRA_POSTINGAN, postingan);

                HomeFragment homeFragment = new HomeFragment();
                homeFragment.setArguments(bundle);

                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_container, homeFragment)
                        .addToBackStack(null)
                        .commit();

                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.iv_home.setBackgroundColor(Color.parseColor("#E33DFF"));
                mainActivity.tv_home.setTextColor(Color.parseColor("#E33DFF"));

                mainActivity.iv_posting.setBackgroundColor(Color.parseColor("#A6A6A6"));
                mainActivity.tv_post.setTextColor(Color.parseColor("#A6A6A6"));

                mainActivity.iv_profile.setBackgroundColor(Color.parseColor("#A6A6A6"));
                mainActivity.tv_profile.setTextColor(Color.parseColor("#A6A6A6"));
            } else {
                // Jika gambar tidak dipilih
                Toast.makeText(getActivity(), "Pilih gambar terlebih dahulu", Toast.LENGTH_SHORT).show();
            }
        });
    }
}