package com.example.les_prak3;

import com.example.les_prak3.model.StoryItem;

import java.util.ArrayList;

public class StoryItemList {
    private ArrayList<StoryItem> items;

    public StoryItemList(){
        items= new ArrayList<>();
        items.add(new StoryItem(R.drawable.audi_logo, R.drawable.audi_snap,"audi"));
        items.add(new StoryItem(R.drawable.jaguar_logo, R.drawable.jaguar_snap,"JAGUAR"));
        items.add(new StoryItem(R.drawable.tesla_logo, R.drawable.tesla_snap,"TESLA"));
        items.add(new StoryItem(R.drawable.bmw_logo, R.drawable.bmw_snap,"BMW"));
        items.add(new StoryItem(R.drawable.mazda_logo,R.drawable.mazda_snap, "MAZDA"));
        items.add(new StoryItem(R.drawable.volvo_logo, R.drawable.volvo_snap,"VOLVO"));

    }
    public ArrayList<StoryItem> getItems(){
        return this.items;
    }

    public StoryItem getStoryItemByUsername(String username){
        for (StoryItem item: items){
            if (item.getUsername().equals(username)){
                return item;
            }
        }

        return null;
    }
}
