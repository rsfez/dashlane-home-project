package com.robined.dashlanehomeproject.ui.fork.list;


import android.os.Parcelable;
import com.robined.dashlanehomeproject.data.fork.entities.Fork;
import com.robined.dashlanehomeproject.data.fork.interactor.ForkInteractor;
import com.robined.dashlanehomeproject.data.fork.interactor.ForkInteractor.OnForkListFetchedListener;
import com.robined.dashlanehomeproject.ui.fork.list.contracts.ForkListPresenter;
import com.robined.dashlanehomeproject.ui.fork.list.contracts.ForkListView;
import com.robined.dashlanehomeproject.ui.fork.list.contracts.ForkRowView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.parceler.Parcels;

public class ForkListPresenterImpl implements ForkListPresenter, OnForkListFetchedListener {
    private final ForkInteractor mForkInteractor;
    private final ForkListView mForkListView;
    final CompositeDisposable mCompositeDisposable;
    final List<Fork> mForkList;

    @Inject
    ForkListPresenterImpl(ForkInteractor forkInteractor, ForkListView forkListView) {
        mForkInteractor = forkInteractor;
        mForkListView = forkListView;
        mCompositeDisposable = new CompositeDisposable();
        mForkList = new ArrayList<>();
    }

    @Override
    public void getForkList() {
        mForkListView.setLoadingState(true);
        mForkInteractor.getForkList("DefinitelyTyped", this);
    }

    @Override
    public int getForkCount() {
        return mForkList.size();
    }

    @Override
    public void onBindForkViewHolderAtPosition(int position, ForkRowView forkRowView) {
        Fork fork = mForkList.get(position);
        forkRowView.setOwnerName(fork.mOwner.mLogin);
        forkRowView.displayPictureFromUrl(fork.mOwner.mAvatarUrl);
    }

    @Override
    public Parcelable getForkAtPositionAsParcelable(int adapterPosition) {
        return Parcels.wrap(mForkList.get(adapterPosition));
    }

    @Override
    public void unsubscribe() {
        mCompositeDisposable.dispose();
    }

    @Override
    public void onSubscribe(Disposable disposable) {
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void onForkListFetchedSuccess(List<Fork> forkList) {
        mForkList.clear();
        mForkList.addAll(forkList);
        mForkListView.onDataReady();
        mForkListView.setLoadingState(false);
    }

    @Override
    public void onForkListFetchedError() {
        mForkListView.showError();
        mForkListView.setLoadingState(false);
    }
}
