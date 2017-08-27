package com.robined.dashlanehomeproject.data.fork.interactor;


import com.robined.dashlanehomeproject.data.fork.entities.Fork;
import com.robined.dashlanehomeproject.data.fork.network.ForkService;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import java.util.List;
import javax.inject.Inject;

public class ForkInteractorImpl implements ForkInteractor, Observer<List<Fork>> {
    private final ForkService mForkService;
    private OnForkListFetchedListener mListener;

    @Inject ForkInteractorImpl(ForkService forkService) {
        mForkService = forkService;
    }

    @Override
    public void getForkList(String repo, OnForkListFetchedListener listener) {
        mListener = listener;
        mForkService.getForkList(repo).observeOn(AndroidSchedulers.mainThread()).subscribe(this);
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        mListener.onSubscribe(d);
    }

    @Override
    public void onNext(@NonNull List<Fork> forkList) {
        if(forkList != null) {
            mListener.onForkListFetchedSuccess(forkList);
        } else {
            mListener.onForkListFetchedError();
        }
    }

    @Override
    public void onError(@NonNull Throwable e) {
        mListener.onForkListFetchedError();
    }

    @Override
    public void onComplete() {}
}
