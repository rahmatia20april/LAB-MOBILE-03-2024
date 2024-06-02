package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter1 extends RecyclerView.Adapter<Adapter1.ViewHolder> {
    private final ArrayList<Data> datas;
    private OnItemClickListener itemClickListener;

    public Adapter1(ArrayList<Data> data) {
        this.datas = data;
    }

    @NonNull
    @Override
    public Adapter1.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter1.ViewHolder holder, int position) {
        Data data = datas.get(position);
        holder.setData(data);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        itemClickListener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView tv_name;
        private final ImageView tv_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_image = itemView.findViewById(R.id.tv_image);
            tv_image.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION && itemClickListener != null ) {
                    itemClickListener.onItemClick(datas.get(position));

                }
            });
        }
        public void setData(Data data) {
            tv_name.setText(data.getName());
            tv_image.setImageResource(data.getImage_profile());
        }

    }
    public interface OnItemClickListener {
        void onItemClick(Data data);
    }
}
