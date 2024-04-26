package com.example.les_prak3.model;


import android.graphics.drawable.Drawable;

public class PostItem {
    private String username, description;
    private int drawableLogo, drawablePost;

    public PostItem(int drawableLogo, int drawablePost, String username, String description) {
        this.username = username;
        this.description = description;
        this.drawablePost = drawablePost;
        this.drawableLogo = drawableLogo;
    }
    public int getDrawableLogo() {
        return drawableLogo;
    }
    public void setDrawableLogo(int drawableLogo) {
        this.drawableLogo = drawableLogo;
    }
    public int getDrawablePost() {
        return drawablePost;
    }
    public void setDrawablePost(int drawablePost) {
        this.drawablePost = drawablePost;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
