package com.example.myapplication;

import static android.app.Activity.RESULT_OK;

import static com.example.myapplication.Source.datas;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PostFragment extends Fragment {
    private static final int PICK_IMAGE_REQUEST = 100;
    private TextView textViewName;
    private TextView textViewNickname;
    private TextView textViewContent;
    private ImageView imageViewImage;
    private ImageView imageViewImage2;
    private Boolean cekImage = false;
    private Boolean cekImage2 = false;

    private Uri uriImage;
    private Uri uriImage2;
    private Button btnPost;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post, container, false);
        textViewName = view.findViewById(R.id.editTextName);
        textViewNickname = view.findViewById(R.id.editTextNickname);
        textViewContent = view.findViewById(R.id.editTextContent);
        imageViewImage = view.findViewById(R.id.imageViewImage);
        imageViewImage2 = view.findViewById(R.id.imageViewImage2);
        btnPost = view.findViewById(R.id.btnPost);

        imageViewImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toGalery = new Intent(Intent.ACTION_PICK);
                toGalery.setType("image/*");
                intentLaunch.launch(toGalery);
            }
        });
        imageViewImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toGalery2 = new Intent(Intent.ACTION_PICK);
                toGalery2.setType("image/*");
                intentLaunch2.launch(toGalery2);
            }
        });

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = textViewName.getText().toString().trim();
                String nickname = textViewNickname.getText().toString().trim();
                String content = textViewContent.getText().toString().trim();

                if (name.isEmpty()){
                    textViewName.setError("Masukkan nama terlebih dahulu");
                } else if (nickname.isEmpty()) {
                    textViewNickname.setError("Masukkan nickname terlebih dahulu");
                } else if (content.isEmpty()) {
                    textViewContent.setError("Masukkan content terlebih dahulu");
                } else if (cekImage == false){
                    Toast.makeText(getActivity(), "Pilih Gambar profil terlebih dahulu", Toast.LENGTH_SHORT).show();
                } else if (cekImage2 == false){
                    Toast.makeText(getActivity(), "Pilih Gambar postingan terlebih dahulu", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Post Success", Toast.LENGTH_SHORT).show();
                    ArrayList<Data> datas = new ArrayList<>();
//                    datas.add(new Data(name, nickname, content, 0,0, uriImage, uriImage2));
                    datas.add(new Data(name, nickname, content, uriImage, uriImage2));

                    HomeFragment homeFragment = new HomeFragment();
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("datas", datas);
                    homeFragment.setArguments(bundle);

                    FragmentManager fragmentManager = getParentFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.frameLayout, homeFragment, HomeFragment.class.getSimpleName())
                            .addToBackStack(null).commit();
                }
            }
        });
        return view;
    }
    ActivityResultLauncher<Intent> intentLaunch = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if(result.getResultCode() == RESULT_OK && result.getData() != null) {
                    uriImage = result.getData().getData();
                    imageViewImage.setImageURI(uriImage);
                    cekImage = true;
                }
            });
    ActivityResultLauncher<Intent> intentLaunch2 = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if(result.getResultCode() == RESULT_OK && result.getData() != null) {
                    uriImage2 = result.getData().getData();
                    imageViewImage2.setImageURI(uriImage2);
                    cekImage2 = true;
                }
            });
}

