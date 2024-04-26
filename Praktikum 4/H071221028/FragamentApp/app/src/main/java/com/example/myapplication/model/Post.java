package com.example.myapplication.model;

public class Post {
    private String name, username;
    private String content;
    private int profileDrawableResourceId;



    public Post(String name, String username, String content, int profileDrawableResourceId) {
        this.name= name;
        this.username= username;
        this.content = content;
        this.profileDrawableResourceId = profileDrawableResourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getProfileDrawableResourceId() {
        return profileDrawableResourceId;
    }

    public void setProfileDrawableResourceId(int profileDrawableResourceId) {
        this.profileDrawableResourceId = profileDrawableResourceId;
    }
}


    //jika == drawwable maka nanti image ditampilakn pakai postdrawableresourceid, jaka == uri nanti image yang ditampilkan dari uri



