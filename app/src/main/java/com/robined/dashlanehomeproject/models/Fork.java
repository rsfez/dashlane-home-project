package com.robined.dashlanehomeproject.models;


public class Fork {
    String name;
    public Owner owner;

    @Override
    public String toString() {
        return "Fork{" +
                "name='" + name + '\'' +
                ", owner=" + owner +
                '}';
    }
}
