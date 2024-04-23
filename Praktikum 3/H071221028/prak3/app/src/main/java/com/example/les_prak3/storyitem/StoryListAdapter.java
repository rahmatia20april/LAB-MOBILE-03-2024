package com.example.les_prak3.storyitem;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.les_prak3.R;
import com.example.les_prak3.StoryActivity;
import com.example.les_prak3.model.StoryItem;

import java.util.ArrayList;

public class StoryListAdapter extends RecyclerView.Adapter<StoryItemViewHolder> {
    private ArrayList<StoryItem> storyList;
    public StoryListAdapter(){this.storyList=new ArrayList<StoryItem>();}
    public  void  setStoryList(ArrayList<StoryItem> storyList){this.storyList=storyList;}
    @NonNull
    @Override
    public StoryItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sory_item,parent,false);
        return new StoryItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryItemViewHolder holder, int position) {
        StoryItem storyItem = this.storyList.get(position);
        holder.usenameText.setText(storyItem.getUsername());
        holder.storyImage.setImageResource(storyItem.getDrawableLogo());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(holder.itemView.getContext(), StoryActivity.class);
                    intent.putExtra("USERNAME", storyItem.getUsername());
                    holder.itemView.getContext().startActivity(intent);
                }
            });
        }


    @Override
    public int getItemCount() {
        return this.storyList.size();
    }
}
