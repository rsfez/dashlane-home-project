package com.robined.dashlanehomeproject.data.fork.interactor;


import com.robined.dashlanehomeproject.data.fork.entities.Fork;
import java.util.List;

public interface ForkInteractor {
    void getForkList(String repo, OnForkListFetchedListener listener);

    interface OnForkListFetchedListener {
        void onForkListFetchedSuccess(List<Fork> forkList);
        void onForkListFetchedError();
    }
}
