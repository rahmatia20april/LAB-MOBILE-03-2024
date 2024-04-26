package com.example.les_prak3.model;

public class ProfileItem {
    private String username, followers, following;
    private int drawableLogo, imagePost;

    public ProfileItem(String username, String followers, String following, int drawableLogo, int imagePost) {
        this.username = username;
        this.followers = followers;
        this.following = following;
        this.drawableLogo = drawableLogo;
        this.imagePost = imagePost;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public int getDrawableLogo() {
        return drawableLogo;
    }

    public void setDrawableLogo(int drawableLogo) {
        this.drawableLogo = drawableLogo;
    }

    public int getImagePost() {
        return imagePost;
    }

    public void setImagePost(int imagePost) {
        this.imagePost = imagePost;
    }
}
