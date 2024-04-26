package com.example.tugas4.Adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugas4.Activity.MainActivity;
import com.example.tugas4.Activity.ProfileActivity;
import com.example.tugas4.Data.DataSource;
import com.example.tugas4.Fragment.SearchFragment;
import com.example.tugas4.Model.Profile;
import com.example.tugas4.R;

import java.util.ArrayList;
import java.util.List;


public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    private ArrayList<Profile> searchProfiles;

    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Profile profile = searchProfiles.get(position);
        holder.setData(profile);
    }

    @Override
    public int getItemCount() {
        if (searchProfiles == null){
            return 0;
        }
        return searchProfiles.size();
    }

    public Filter getFilter() {
        return userFilter;
    }

    private final Filter userFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            searchProfiles = DataSource.generateDummyProfiles();
            List<Profile> filteredList = new ArrayList<>();

            if (constraint.length() != 0) {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Profile profile : searchProfiles) {
                    if (profile.getUsername().toLowerCase().contains(filterPattern) ||
                            profile.getFullname().toLowerCase().contains(filterPattern)) {
                        filteredList.add(profile);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @SuppressLint("NotifyDataSetChanged")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            searchProfiles.clear();
            searchProfiles.addAll((List) results.values);
            SearchFragment.searchAdapter.notifyDataSetChanged();
        }
    };

    public class ViewHolder extends RecyclerView.ViewHolder{
        private final ImageView image_list;
        private final TextView fullname_list, username_list;
        private final LinearLayout listView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image_list = itemView.findViewById(R.id.image_list);
            fullname_list = itemView.findViewById(R.id.fullname_list);
            username_list = itemView.findViewById(R.id.username_list);
            listView = itemView.findViewById(R.id.list_view);
        }

        public void setData(Profile profile){
            image_list.setImageResource(profile.getImageProfile());
            fullname_list.setText(profile.getFullname());
            username_list.setText(profile.getUsername());
            listView.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.context, ProfileActivity.class);
                for (Profile profileCopy: searchProfiles) {
                    if (profile.getId() == profileCopy.getId()){
                        intent.putExtra("profilePic", profile.getImageProfile());
                        intent.putExtra("fullname", profile.getFullname());
                        intent.putExtra("username", profile.getUsername());
                    }
                }
                MainActivity.context.startActivity(intent);
            });
        };
    }
}
