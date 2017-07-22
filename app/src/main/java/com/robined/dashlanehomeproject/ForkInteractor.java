package com.robined.dashlanehomeproject;


import java.util.List;

public interface ForkInteractor {
    void getForkList(String repo, OnForkListFetchedListener listener);

    interface OnForkListFetchedListener {
        void onForkListFetchedSuccess(List<Fork> forkList);
        void onForkListFetchedError();
    }
}
