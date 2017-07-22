package com.robined.dashlanehomeproject;


import com.robined.dashlanehomeproject.ui.views.ForkRowView;

public interface ForkPresenter {
    void getForkList();
    int getForkCount();
    void onBindForkViewHolderAtPosition(int position, ForkRowView forkRowView);
}
