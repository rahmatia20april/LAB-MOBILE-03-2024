package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter2 extends RecyclerView.Adapter<Adapter2.ViewHolder> {
    private final ArrayList<Data> dataSearch;

    public Adapter2(ArrayList<Data> dataSearch) {
        this.dataSearch = dataSearch;
    }

    @NonNull
    @Override
    public Adapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_list2, parent, false);
        return new Adapter2.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Data datasearch = dataSearch.get(position);
        holder.setData(datasearch);
        holder.idProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), MainActivity2.class);
                intent.putExtra(MainActivity2.PARCEL_DATA, datasearch);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return dataSearch.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewName;
        private final TextView textViewNickname;
        private final ImageView imageViewImage;
        private RelativeLayout idProfile;
        private Uri uriImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewNickname = itemView.findViewById(R.id.textViewNickname);
            imageViewImage = itemView.findViewById(R.id.imageViewImage);
            idProfile = itemView.findViewById(R.id.idProfile);

        }
        public void setData(Data data) {
            textViewName.setText(data.getName());
            textViewNickname.setText(data.getNickname());
            if (data.getUriImage() != null) {
                imageViewImage.setImageURI(data.getUriImage());
            } else {
                imageViewImage.setImageResource(data.getImage());
            }
        }
    }
}
