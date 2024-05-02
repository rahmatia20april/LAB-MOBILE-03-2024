package com.example.myapplication;

import static com.example.myapplication.Source.datas;
import static com.example.myapplication.Source2.dataSearch;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.myapplication.Data;

import java.util.ArrayList;

public class SearchFragment extends Fragment {
    private Adapter2 adapter2;
    private SearchView searchView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        ProgressBar progressBar = view.findViewById(R.id.progressBar);
//        RecyclerView recyclerView = view.findViewById(R.id.rv_search);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
//        adapter2 = new Adapter2(dataSearch);
//        Handler handler = new Handler(Looper.getMainLooper());
//        progressBar.setVisibility(View.GONE);
//        searchView = view.findViewById(R.id.searchView);
//        searchView.clearFocus();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
////                Toast.makeText(getActivity(), "dwdwd", Toast.LENGTH_SHORT).show();
//                dataSearch.clear();
////
//                if (newText.isEmpty()){
//                    progressBar.setVisibility(View.GONE);
//                } else {
////                    Toast.makeText(getActivity(), "wdwda", Toast.LENGTH_SHORT).show();
//                    progressBar.setVisibility(View.VISIBLE);
//                    recyclerView.setVisibility(View.GONE);
//                    for (Data item : datas){
//                        String name = item.getName().toLowerCase();
//                        String nickname = item.getNickname().toLowerCase();
//                        if (name.contains(newText.toLowerCase()) || nickname.contains(newText.toLowerCase())) {
//                            dataSearch.add(item);
//                        }
//                    }
//                }
//                recyclerView.setAdapter(adapter2);
//
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            Thread.sleep(1000);
//                            handler.post(new Runnable() {
//                                @Override
//                                public void run() {
//                                    recyclerView.setVisibility(View.VISIBLE);
//                                    progressBar.setVisibility(View.GONE);
//                                }
//                            });
//                        }catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
//                }).start();
//                return true;
//            }
//        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        ProgressBar progressBar = view.findViewById(R.id.progressBar);
        RecyclerView recyclerView = view.findViewById(R.id.rv_search);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        adapter2 = new Adapter2(dataSearch);
        Handler handler = new Handler(Looper.getMainLooper());
        progressBar.setVisibility(View.GONE);
        searchView = view.findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
//                Toast.makeText(getActivity(), "dwdwd", Toast.LENGTH_SHORT).show();
                dataSearch.clear();
//
                if (newText.isEmpty()){
                    progressBar.setVisibility(View.GONE);
                } else {
//                    Toast.makeText(getActivity(), "wdwda", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);
                    for (Data item : datas){
                        String name = item.getName().toLowerCase();
                        String nickname = item.getNickname().toLowerCase();
                        if (name.contains(newText.toLowerCase()) || nickname.contains(newText.toLowerCase())) {
                            dataSearch.add(item);
                        }
                    }
                }
                recyclerView.setAdapter(adapter2);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    recyclerView.setVisibility(View.VISIBLE);
                                    progressBar.setVisibility(View.GONE);
                                }
                            });
                        }catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }).start();
                return true;
            }
        });
        return view;
    }
}
