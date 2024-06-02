package com.example.myapplication;

import static com.example.myapplication.Source.datas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.rv_post);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        Adapter adapter = new Adapter(Source.datas);
        recyclerView.setAdapter(adapter);


        if(getArguments() != null) {
            ArrayList<Data> receivedData = getArguments().getParcelableArrayList("datas");
            if(receivedData != null) {
                Source.datas.addAll(0, receivedData);
                adapter.notifyDataSetChanged();
            }
        }
        SearchFragment searchFragment = new SearchFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("datas", Source.datas);
        searchFragment.setArguments(bundle);
        return view;
    }
}