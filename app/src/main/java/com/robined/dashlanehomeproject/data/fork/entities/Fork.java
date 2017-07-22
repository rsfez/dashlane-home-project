package com.robined.dashlanehomeproject.data.fork.entities;


import java.util.Date;
import org.parceler.Parcel;

@Parcel
public class Fork {
    public String full_name;
    public String description;
    public Date created_at;
    public ForkOwner owner;
}
