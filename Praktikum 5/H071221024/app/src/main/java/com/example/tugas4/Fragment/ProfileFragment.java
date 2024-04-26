package com.example.tugas4.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tugas4.Data.DataSource;
import com.example.tugas4.Model.Profile;
import com.example.tugas4.R;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {

    ImageView profilePic;
    TextView fullname, username;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<Profile> profiles = DataSource.profiles;
//        System.out.println(profiles.get(0).getFullname());
        Profile profile = profiles.get(6);

        profilePic = view.findViewById(R.id.profilePic);
        fullname = view.findViewById(R.id.fullname);
        username = view.findViewById(R.id.username);

        profilePic.setImageResource(profile.getImageProfile());
        fullname.setText(profile.getFullname());
        username.setText(profile.getUsername());
    }
}