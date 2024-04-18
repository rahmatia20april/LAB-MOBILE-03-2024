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
    private Boolean cekImage = false;
    private Uri uriImage;
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
        btnPost = view.findViewById(R.id.btnPost);

        imageViewImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toGalery = new Intent(Intent.ACTION_PICK);
                toGalery.setType("image/*");
                intentLaunch.launch(toGalery);
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
                    Toast.makeText(getActivity(), "Pilih Gambar terlebih dahulu", Toast.LENGTH_SHORT).show();
                } else {
                    ArrayList<Data> datas = new ArrayList<>();
                    datas.add(new Data(name, nickname, content, 0, uriImage));

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
}
