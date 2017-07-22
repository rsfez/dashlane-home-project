package com.robined.dashlanehomeproject.ui.fork.details.contracts;


public interface ForkDetailsView {
    void setOwnerName(String ownerName);
    void displayPictureFromUrl(String avatarUrl);
    void setForkFullName(String forkFullName);
    void setCreationDate(String readableCreationDate);
    void setDescription(String description);
}
