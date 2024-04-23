package com.example.les_prak3;

import com.example.les_prak3.model.ProfileItem;
import com.example.les_prak3.model.StoryItem;

import java.util.ArrayList;

public class ProfileList {
    private ArrayList<ProfileItem> itemss;

    public ProfileList (){
        itemss = new ArrayList<>(); // inisialisasi langsung di konstruktor
        itemss.add(new ProfileItem("audi","12","31",R.drawable.audi_logo, R.drawable.audi_post));
        itemss.add(new ProfileItem("jaguar","13","32",R.drawable.jaguar_logo, R.drawable.jaguar_post));
        itemss.add(new ProfileItem("tesla","12","31",R.drawable.tesla_logo, R.drawable.tesla_post));
        itemss.add(new ProfileItem("bmw","12","31",R.drawable.bmw_logo, R.drawable.bmw_post));
        itemss.add(new ProfileItem("mazda","12","31",R.drawable.mazda_logo, R.drawable.mazda_post));
        itemss.add(new ProfileItem("volvo","11","31",R.drawable.volvo_logo, R.drawable.volvo_post));
        itemss.add(new ProfileItem("mustang","12","31",R.drawable.mustang_logo, R.drawable.mustang_post));
        itemss.add(new ProfileItem("mercy","12","31",R.drawable.mercy_logo, R.drawable.mercy_post));
        itemss.add(new ProfileItem("porsche","12","31",R.drawable.porsche_logo, R.drawable.porsche_post));
        itemss.add(new ProfileItem("bentley","12","31",R.drawable.bentley_logo, R.drawable.bentley_post));
    }

    public ArrayList<ProfileItem> getItems(){
        return this.itemss;
    }

    public ProfileItem getProfileItemByUsername(String username){
        for (ProfileItem item: itemss){
            if (item.getUsername().equals(username)){
                return item;
            }
        }
        return null;
    }
}
