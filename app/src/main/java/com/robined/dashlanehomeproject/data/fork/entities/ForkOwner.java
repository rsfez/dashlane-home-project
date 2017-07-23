package com.robined.dashlanehomeproject.data.fork.entities;


import com.google.gson.annotations.SerializedName;
import org.parceler.Parcel;

@Parcel
public class ForkOwner {
    @SerializedName("login") public String mLogin;
    @SerializedName("avatar_url") public String mAvatarUrl;
}
