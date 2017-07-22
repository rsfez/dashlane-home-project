package com.robined.dashlanehomeproject.data.fork.entities;


import java.util.Date;
import org.parceler.Parcel;

@Parcel
public class Fork {
    String full_name;
    String description;
    Date created_at;
    public ForkOwner owner;
}
