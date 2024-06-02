package com.example.tugas4.Model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class Post implements Parcelable {
    private Uri imagePostUpload;
    private int imagePost;
    private String content;
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Uri getImagePostUpload() {
        return imagePostUpload;
    }

    public void setImagePostUpload(Uri imagePostUpload) {
        this.imagePostUpload = imagePostUpload;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImagePost() {
        return imagePost;
    }

    public void setImagePost(int imagePostUpload) {
        this.imagePost = imagePost;
    }

    public Post(Uri imagePostUpload, String content, int userId){
        this.imagePostUpload = imagePostUpload;
        this.content = content;
        this.userId = userId;
    }

    public Post(int imagePost, String content, int userId){
        this.imagePost = imagePost;
        this.content = content;
        this.userId = userId;
    }

    protected Post(Parcel in) {
        imagePostUpload = in.readParcelable(Uri.class.getClassLoader());
        imagePost = in.readInt();
        content = in.readString();
        userId = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(imagePostUpload, flags);
        dest.writeInt(imagePost);
        dest.writeString(content);
        dest.writeInt(userId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Post> CREATOR = new Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };

}
