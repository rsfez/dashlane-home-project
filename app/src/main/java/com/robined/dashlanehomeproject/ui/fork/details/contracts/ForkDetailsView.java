package com.robined.dashlanehomeproject.ui.fork.details.contracts;


import java.util.Date;

public interface ForkDetailsView {
    void setOwnerName(String ownerName);
    void displayPictureFromUrl(String avatarUrl);
    void setForkFullName(String forkFullName);
    void setCreationDate(Date creationDate);
    void setDescription(String description);
}
