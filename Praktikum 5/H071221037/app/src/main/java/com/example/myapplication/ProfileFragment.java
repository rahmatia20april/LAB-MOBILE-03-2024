package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileFragment extends Fragment {
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_NICKNAME = "extra_nickname";
    public static final String EXTRA_PROFILE = "extra_profile";
    private ImageView imageView;
    private TextView textViewName;
    private TextView textViewNickname;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        imageView = view.findViewById(R.id.imageViewImage);
        textViewName = view.findViewById(R.id.textViewName);
        textViewNickname = view.findViewById(R.id.textViewNickname);

        if (getArguments() != null) {
            imageView.setImageResource(getArguments().getInt(EXTRA_PROFILE));
            textViewName.setText(getArguments().getString(EXTRA_NAME));
            textViewNickname.setText(getArguments().getString(EXTRA_NICKNAME));

        }
        return view;

    }
}