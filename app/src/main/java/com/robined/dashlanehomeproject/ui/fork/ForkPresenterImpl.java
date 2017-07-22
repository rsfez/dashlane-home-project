package com.robined.dashlanehomeproject.ui.fork;


import com.robined.dashlanehomeproject.data.fork.entities.Fork;
import com.robined.dashlanehomeproject.data.fork.interactor.ForkInteractor;
import com.robined.dashlanehomeproject.data.fork.interactor.ForkInteractor.OnForkListFetchedListener;
import com.robined.dashlanehomeproject.ui.fork.contracts.ForkListView;
import com.robined.dashlanehomeproject.ui.fork.contracts.ForkPresenter;
import com.robined.dashlanehomeproject.ui.fork.contracts.ForkRowView;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class ForkPresenterImpl implements ForkPresenter, OnForkListFetchedListener {
    private final ForkInteractor mForkInteractor;
    private final ForkListView mForkListView;
    private final List<Fork> mForkList;

    @Inject ForkPresenterImpl(ForkInteractor forkInteractor, ForkListView forkListView) {
        mForkInteractor = forkInteractor;
        mForkListView = forkListView;
        mForkList = new ArrayList<>();
    }

    @Override
    public void getForkList() {
        mForkInteractor.getForkList("DefinitelyTyped", this);
    }

    @Override
    public int getForkCount() {
        return mForkList.size();
    }

    @Override
    public void onBindForkViewHolderAtPosition(int position, ForkRowView forkRowView) {
        Fork fork = mForkList.get(position);
        forkRowView.setOwnerName(fork.owner.login);
        forkRowView.displayPictureFromUrl(fork.owner.avatar_url);
    }

    @Override
    public void onForkListFetchedSuccess(List<Fork> forkList) {
        mForkList.clear();
        mForkList.addAll(forkList);
        mForkListView.refreshData();
    }

    @Override
    public void onForkListFetchedError() {

    }
}
