package com.example.les_prak3.model;

import android.graphics.drawable.Drawable;

public class StoryItem {
    private String username;
   private int drawableLogo,drawableSnap;
    public StoryItem(int drawbleLogo, int drawbleSnap, String username){
        this.username = username;
        this.drawableSnap = drawbleSnap;
        this.drawableLogo = drawbleLogo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getDrawableLogo() {
        return drawableLogo;
    }

    public void setDrawableLogo(int drawableLogo) {
        this.drawableLogo = drawableLogo;
    }

    public int getDrawableSnap() {
        return drawableSnap;
    }

    public void setDrawableSnap(int drawableSnap) {
        this.drawableSnap = drawableSnap;
    }






}
