package com.example.les_prak3;

import com.example.les_prak3.model.PostItem;
import com.example.les_prak3.model.ProfileItem;
import com.example.les_prak3.model.StoryItem;

import java.util.ArrayList;

public class PostItemList {
    private ArrayList<PostItem> items;

    public PostItemList() {
        items = new ArrayList<>();
        items.add(new PostItem(R.drawable.audi_logo, R.drawable.audi_post, "audi", "This is audi"));
        items.add(new PostItem(R.drawable.bmw_logo, R.drawable.bmw_post,"bmw", "This is BMW"));
        items.add(new PostItem(R.drawable.tesla_logo, R.drawable.tesla_post,"tesla", "This is tesla"));
        items.add(new PostItem(R.drawable.bentley_logo, R.drawable.bentley_post,"bentley", "This is bentley"));
        items.add(new PostItem(R.drawable.mazda_logo, R.drawable.mazda_post,"mazda", "This is mazda"));
        items.add(new PostItem(R.drawable.jaguar_logo, R.drawable.jaguar_post,"jaguar", "This is jaguar"));
        items.add(new PostItem(R.drawable.jaguar_logo, R.drawable.jaguar_post,"jaguar", "This is jaguar"));
        items.add(new PostItem(R.drawable.jaguar_logo, R.drawable.jaguar_post,"jaguar", "This is jaguar"));
        items.add(new PostItem(R.drawable.jaguar_logo, R.drawable.jaguar_post,"jaguar", "This is jaguar"));
        items.add(new PostItem(R.drawable.jaguar_logo, R.drawable.jaguar_post,"jaguar", "This is jaguar"));
        items.add(new PostItem(R.drawable.jaguar_logo, R.drawable.jaguar_post,"jaguar", "This is jaguar"));
    }

    public ArrayList<PostItem> getItems(){
        return this.items;
    }

    public PostItem getPostItemByUsername(String username) {
        for (PostItem item : items) {
            if (item.getUsername().equals(username)) {
                return item;
            }
        }
        return null;
    }
}


