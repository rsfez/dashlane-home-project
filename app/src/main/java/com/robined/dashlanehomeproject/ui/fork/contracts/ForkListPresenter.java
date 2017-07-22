package com.robined.dashlanehomeproject.ui.fork.contracts;


import android.os.Parcelable;

public interface ForkListPresenter {
    void getForkList();
    int getForkCount();
    void onBindForkViewHolderAtPosition(int position, ForkRowView forkRowView);
    Parcelable getForkAtPositionAsParcelable(int adapterPosition);
}
