package com.robined.dashlanehomeproject.ui.fork.list.contracts;


import android.os.Parcelable;

public interface ForkListPresenter {
    void getForkList();
    int getForkCount();
    void onBindForkViewHolderAtPosition(int position, ForkRowView forkRowView);
    Parcelable getForkAtPositionAsParcelable(int adapterPosition);
    void unsubscribe();
}