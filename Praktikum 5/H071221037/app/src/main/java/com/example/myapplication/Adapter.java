package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private final ArrayList<Data> datas;

    public Adapter(ArrayList<Data> data) {
        this.datas = data;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Data data = datas.get(position);
        holder.setData(data);
        holder.idProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), MainActivity2.class);
                intent.putExtra(MainActivity2.PARCEL_DATA, data);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewName;
        private final TextView textViewNickname;
        private final TextView textViewContent;
        private final ImageView imageViewImage;
        private final ImageView imageViewImage2;
        private Button btnDelete;
        private RelativeLayout idProfile;
        private Uri uriImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewNickname = itemView.findViewById(R.id.textViewNickname);
            textViewContent = itemView.findViewById(R.id.textViewContent);
            imageViewImage = itemView.findViewById(R.id.imageViewImage);
            imageViewImage2 = itemView.findViewById(R.id.imageViewImage2);
            idProfile = itemView.findViewById(R.id.idProfile);

        }
        public void setData(Data data) {
            textViewName.setText(data.getName());
            textViewNickname.setText(data.getNickname());
            textViewContent.setText(data.getContent());
            if (data.getUriImage() != null) {
                imageViewImage.setImageURI(data.getUriImage());
                imageViewImage2.setImageURI(data.getUriImage2());
            } else {
                imageViewImage.setImageResource(data.getImage());
                imageViewImage2.setImageResource(data.getImage2());
            }
        }
    }
}
