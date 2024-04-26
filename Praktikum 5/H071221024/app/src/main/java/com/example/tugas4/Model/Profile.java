package com.example.tugas4.Model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class Profile implements Parcelable {
    private int id;
    private int imageProfile;
    private String fullname;
    private String username;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getImageProfile() {
        return imageProfile;
    }

    public void setImageProfile(int imageProfileUpload) {
        this.imageProfile = imageProfileUpload;
    }

    public Profile(int id, int imageProfile, String fullname, String username){
        this.id = id;
        this.imageProfile = imageProfile;
        this.fullname = fullname;
        this.username = username;
    }

    protected Profile(Parcel in) {
        id = in.readInt();
        imageProfile = in.readInt();
        fullname = in.readString();
        username = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(imageProfile);
        dest.writeString(fullname);
        dest.writeString(username);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Profile> CREATOR = new Creator<Profile>() {
        @Override
        public Profile createFromParcel(Parcel in) {
            return new Profile(in);
        }

        @Override
        public Profile[] newArray(int size) {
            return new Profile[size];
        }
    };
}
