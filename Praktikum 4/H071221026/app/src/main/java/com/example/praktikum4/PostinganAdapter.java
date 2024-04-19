package com.example.praktikum4;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostinganAdapter extends RecyclerView.Adapter<PostinganAdapter.ViewHolder> {

    private ArrayList<Postingan> postingans;

    public PostinganAdapter(ArrayList<Postingan> postingans) {
        this.postingans = postingans;
    }

    @NonNull
    @Override
    public PostinganAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.postingan, parent, false);
        return new PostinganAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostinganAdapter.ViewHolder holder, int position) {

        Postingan postingan1 = postingans.get(position);

        holder.tv_username.setText(postingan1.getUsername());
        holder.tv_name.setText(postingan1.getName());
        holder.ivProfile.setImageResource(postingan1.getFotoProfile());
        holder.ivFeed.setImageResource(postingan1.getFotoPostingan());
        holder.IVFeed.setImageURI(postingan1.getSelectedImageUri());
        holder.tv_caption.setText(postingan1.getDesc());

        holder.ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.context, ProfileActivity.class);
                intent.putExtra("postingan", postingan1);
                holder.context.startActivity(intent);
            }
        });

        holder.tv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.context, ProfileActivity.class);
                intent.putExtra("postingan", postingan1);
                holder.context.startActivity(intent);
            }
        });
        holder.tv_username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.context, ProfileActivity.class);
                intent.putExtra("postingan", postingan1);
                holder.context.startActivity(intent);
            }
        });

        holder.ivDelete.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(holder.context);
            builder.setTitle("Konfirmasi");
            builder.setMessage("Apakah Anda yakin ingin menghapus postingan ini?");
            builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    int adapterPosition = holder.getAdapterPosition();
                    if (adapterPosition != RecyclerView.NO_POSITION) {
                        postingans.remove(adapterPosition);
                        notifyItemRemoved(adapterPosition);
                    }
                }
            });
            builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.create().show();
        });

    }

    @Override
    public int getItemCount() {
        return postingans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivFeed, ivProfile, ivDelete, IVFeed;
        TextView tv_caption, tv_username, tv_name;
        Context context;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFeed = itemView.findViewById(R.id.IV_Postingan);
            IVFeed = itemView.findViewById(R.id.IV_Postingan);
            ivProfile = itemView.findViewById(R.id.IV_Profile);
            ivDelete = itemView.findViewById(R.id.IV_Delete);
            tv_caption = itemView.findViewById(R.id.TV_Desc);
            tv_username = itemView.findViewById(R.id.TV_username);
            tv_name = itemView.findViewById(R.id.TV_name);
            context = itemView.getContext();
        }
    }
}
