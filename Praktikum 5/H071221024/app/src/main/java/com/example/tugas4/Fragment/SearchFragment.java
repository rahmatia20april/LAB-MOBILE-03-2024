package com.example.tugas4.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SearchView;

import com.example.tugas4.Adapter.SearchAdapter;
import com.example.tugas4.Data.DataSource;
import com.example.tugas4.R;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SearchFragment extends Fragment {

    private SearchView searchView;
    public static SearchAdapter searchAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        searchView = view.findViewById(R.id.search_view);

        Handler handler = new Handler(Looper.getMainLooper());
        ExecutorService executor = Executors.newSingleThreadExecutor();
        LinearLayout linearLayout = view.findViewById(R.id.list_view);
        LinearLayout progressLayout = view.findViewById(R.id.progress_layout);

        RecyclerView listrv = view.findViewById(R.id.list_rv);
        listrv.setHasFixedSize(true);
        searchAdapter = new SearchAdapter();
        listrv.setAdapter(searchAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                handler.removeCallbacksAndMessages(null);
                linearLayout.setVisibility(View.GONE);
                progressLayout.setVisibility(View.VISIBLE);
                handler.postDelayed(() -> {
                    progressLayout.setVisibility(View.GONE);
                    linearLayout.setVisibility(View.VISIBLE);
                    searchAdapter.getFilter().filter(newText);
                }, 1000);
                return false;
            }
        });

    }
}
