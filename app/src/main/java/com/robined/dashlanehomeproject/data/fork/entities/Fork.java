package com.robined.dashlanehomeproject.data.fork.entities;


import com.google.gson.annotations.SerializedName;
import java.util.Date;
import org.parceler.Parcel;

@Parcel
public class Fork {
    @SerializedName("full_name") public String mFullName;
    @SerializedName("description") public String mDescription;
    @SerializedName("created_at") public Date mCreatedAt;
    @SerializedName("owner") public ForkOwner mOwner;
}
