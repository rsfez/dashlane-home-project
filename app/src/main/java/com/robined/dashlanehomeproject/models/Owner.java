package com.robined.dashlanehomeproject.models;


public class Owner {
    public String login;
    public String avatar_url;

    @Override
    public String toString() {
        return "Owner{" +
                "login='" + login + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                '}';
    }
}
