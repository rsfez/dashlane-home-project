package com.robined.dashlanehomeproject;


import com.robined.dashlanehomeproject.ForkInteractor.OnForkListFetchedListener;
import com.robined.dashlanehomeproject.models.Fork;
import com.robined.dashlanehomeproject.ui.views.ForkListView;
import com.robined.dashlanehomeproject.ui.views.ForkRowView;
import java.util.ArrayList;
import java.util.List;

public class ForkPresenterImpl implements ForkPresenter, OnForkListFetchedListener {
    private final ForkInteractor mForkInteractor;
    private final ForkListView mForkListView;
    private final List<Fork> mForkList;

    public ForkPresenterImpl(ForkInteractor forkInteractor, ForkListView forkListView) {
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
