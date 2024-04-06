package com.example.myapplication;

import static java.lang.System.in;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Data implements Parcelable {

    private String name;
    private String description;
    private Integer followers;
    private Integer following;
    private Integer image_profile;
    private Integer image_post;
    private Integer image_Story;

    public Data(String name, String description, Integer followers, Integer following, Integer image_profile, Integer image_post, Integer image_Story) {
        this.name = name;
        this.description = description;
        this.followers = followers;
        this.following = following;
        this.image_profile = image_profile;
        this.image_post = image_post;
        this.image_Story = image_Story;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    public Integer getFollowing() {
        return following;
    }

    public void setFollowing(Integer following) {
        this.following = following;
    }

    public Integer getImage_profile() {
        return image_profile;
    }

    public void setImage_profile(Integer image_profile) {
        this.image_profile = image_profile;
    }

    public Integer getImage_post() {
        return image_post;
    }

    public void setImage_post(Integer image_post) {
        this.image_post = image_post;
    }

    public Integer getImage_Story() {
        return image_Story;
    }

    public void setImage_Story(Integer image_Story) {
        this.image_Story = image_Story;
    }

    protected Data (Parcel in) {
        name = in.readString();
        description = in.readString();
        followers = in.readInt();
        following = in.readInt();
        if(in.readByte() == 0) {
            image_profile = null;
        }else {
            image_profile = in.readInt();
        }
        if(in.readByte() == 0) {
            image_post = null ;
        } else {
            image_post = in.readInt();
        }
        if (in.readByte() == 0) {
            image_Story = null;
        }else {
            image_Story = in.readInt();
        }
    }

    public static final Creator <Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeInt(followers);
        parcel.writeInt(following);
        if(image_profile == null ){
            parcel.writeByte((byte) 0);
        }else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(image_profile);
        }
        if (image_post == null){
            parcel.writeByte((byte) 0);
        }else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(image_post);
        }
        if (image_Story == null){
            parcel.writeByte((byte) 0);
        }else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(image_Story);
        }
    }
}
