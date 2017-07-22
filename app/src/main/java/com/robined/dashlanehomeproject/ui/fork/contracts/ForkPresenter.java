package com.robined.dashlanehomeproject.ui.fork.contracts;


public interface ForkPresenter {
    void getForkList();
    int getForkCount();
    void onBindForkViewHolderAtPosition(int position, ForkRowView forkRowView);
}
