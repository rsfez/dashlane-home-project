package com.robined.dashlanehomeproject.ui.fork.list.contracts;


import android.os.Parcelable;

public interface ForkListPresenter {
    void getForkList();
    void searchFork(CharSequence query);
    int getForkCount();
    void onBindForkViewHolderAtPosition(int position, ForkRowView forkRowView);
    Parcelable getForkAtPositionAsParcelable(int adapterPosition);
    void unsubscribe();
}