package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter2 extends RecyclerView.Adapter<Adapter2.ViewHolder> {
    private final ArrayList<Data> datas;

    private OnItemClickListener itemClickListener;

    public Adapter2(ArrayList<Data> datas){
        this.datas = datas;
    }
    @NonNull
    @Override
    public Adapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item2, parent, false);
        return new ViewHolder(view2);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter2.ViewHolder holder, int position) {
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

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageViewName;
        private final TextView textViewName;
        private final ImageView imageViewPost;
        private final TextView textViewDescription;

        public ViewHolder (@NonNull View itemView) {
            super(itemView);
            imageViewName = itemView.findViewById(R.id.imageViewName);
            textViewName = itemView.findViewById(R.id.textViewName);
            imageViewPost = itemView.findViewById(R.id.imageViewPost);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            textViewName.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION && itemClickListener != null){
                    itemClickListener.onItemClick(datas.get(position));
                }
            });
            imageViewName.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION && itemClickListener != null) {
                    itemClickListener.onItemClick(datas.get(position));
                }
            });
        }
        public void setData (Data data) {
            imageViewName.setImageResource(data.getImage_profile());
            textViewName.setText(data.getName());
            imageViewPost.setImageResource(data.getImage_post());
            textViewDescription.setText(data.getDescription());
        }
    }
    public interface OnItemClickListener {
        void onItemClick(Data data);
    }

}
