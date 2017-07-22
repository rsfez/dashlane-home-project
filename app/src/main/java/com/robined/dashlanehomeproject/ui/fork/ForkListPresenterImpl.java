package com.robined.dashlanehomeproject.ui.fork;


import android.os.Parcelable;
import com.robined.dashlanehomeproject.data.fork.entities.Fork;
import com.robined.dashlanehomeproject.data.fork.interactor.ForkInteractor;
import com.robined.dashlanehomeproject.data.fork.interactor.ForkInteractor.OnForkListFetchedListener;
import com.robined.dashlanehomeproject.ui.fork.contracts.ForkListPresenter;
import com.robined.dashlanehomeproject.ui.fork.contracts.ForkListView;
import com.robined.dashlanehomeproject.ui.fork.contracts.ForkRowView;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.parceler.Parcels;

public class ForkListPresenterImpl implements ForkListPresenter, OnForkListFetchedListener {
    private final ForkInteractor mForkInteractor;
    private final ForkListView mForkListView;
    private final List<Fork> mForkList;

    @Inject
    ForkListPresenterImpl(ForkInteractor forkInteractor, ForkListView forkListView) {
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
    public Parcelable getForkAtPositionAsParcelable(int adapterPosition) {
        return Parcels.wrap(mForkList.get(adapterPosition));
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
