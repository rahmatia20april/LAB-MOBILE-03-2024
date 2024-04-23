package com.example.myapplication;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Data implements Parcelable {
    private String name;
    private String nickname;
    private String content;
    private Integer image;
    private Integer image2;
    private Uri uriImage;
    private Uri uriImage2;

    public Data(String name, String nickname, String content, Integer image, Integer image2 ,Uri uriImage, Uri uriImage2) {
        this.name = name;
        this.nickname = nickname;
        this.content = content;
        this.image = image;
        this.image2 = image2;
        this.uriImage = uriImage;
        this.uriImage2 = uriImage2;
    }

    public Data (String name, String nickname, String content ,Uri uriImage, Uri uriImage2) {
        this.name = name;
        this.nickname = nickname;
        this.uriImage = uriImage;
        this.uriImage2 = uriImage2;
    }

    protected Data(Parcel in) {
        name = in.readString();
        nickname = in.readString();
        content = in.readString();
        if (in.readByte() == 0) {
            image = null;
        } else {
            image = in.readInt();
        }
        if (in.readByte() == 0) {
            image2 = null;
        } else {
            image2 = in.readInt();
        }
        uriImage = in.readParcelable(Uri.class.getClassLoader());
        uriImage2 = in.readParcelable(Uri.class.getClassLoader());
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getImage() {
        return image;
    }
    public void setImage(Integer image) {
        this.image = image;
    }
    public Integer getImage2() {
        return image2;
    }
    public void setImage2(Integer image2) {
        this.image2 = image2;
    }
    public Uri getUriImage() {
        return uriImage;
    }

    public void setUriImage(Uri uriImage) {
        this.uriImage = uriImage;
    }
    public Uri getUriImage2() {
        return uriImage2;
    }

    public void setUriImage2(Uri uriImage2) {
        this.uriImage2 = uriImage2;
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
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

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(nickname);
        dest.writeString(content);
        if (image == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(image);
        }
        if (image2 == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(image2);
        }
        dest.writeParcelable(uriImage, flags);
        dest.writeParcelable(uriImage2, flags);
    }
}
