package com.robined.dashlanehomeproject.data.fork.interactor;


import com.robined.dashlanehomeproject.data.fork.entities.Fork;
import io.reactivex.disposables.Disposable;
import java.util.List;

public interface ForkInteractor {
    void getForkList(String repo, CharSequence searchQuery, OnForkListFetchedListener listener);

    interface OnForkListFetchedListener {
        void onSubscribe(Disposable disposable);
        void onForkListFetchedSuccess(List<Fork> forkList);
        void onForkListFetchedError();
    }
}
