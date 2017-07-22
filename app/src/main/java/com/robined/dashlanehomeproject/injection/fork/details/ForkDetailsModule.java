package com.robined.dashlanehomeproject.injection.fork.details;


import com.robined.dashlanehomeproject.ui.fork.details.ForkDetailsPresenterImpl;
import com.robined.dashlanehomeproject.ui.fork.details.contracts.ForkDetailsPresenter;
import com.robined.dashlanehomeproject.ui.fork.details.contracts.ForkDetailsView;
import dagger.Module;
import dagger.Provides;

@Module
public class ForkDetailsModule {
    private final ForkDetailsView mForkDetailsView;

    public ForkDetailsModule(ForkDetailsView forkDetailsView) {
        mForkDetailsView = forkDetailsView;
    }

    @Provides
    ForkDetailsView provideForkDetailsView() {
        return mForkDetailsView;
    }

    @Provides
    ForkDetailsPresenter provideForkDetailsPresenter(ForkDetailsPresenterImpl forkDetailsPresenter) {
        return forkDetailsPresenter;
    }
}
