package com.robined.dashlanehomeproject.injection.fork.details;


import android.app.Activity;
import com.robined.dashlanehomeproject.injection.base.BaseActivityModule;
import com.robined.dashlanehomeproject.injection.scopes.PerActivity;
import com.robined.dashlanehomeproject.injection.utils.PicassoModule;
import com.robined.dashlanehomeproject.ui.fork.details.ForkDetailsActivity;
import com.robined.dashlanehomeproject.ui.fork.details.ForkDetailsPresenterImpl;
import com.robined.dashlanehomeproject.ui.fork.details.contracts.ForkDetailsPresenter;
import com.robined.dashlanehomeproject.ui.fork.details.contracts.ForkDetailsView;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module(includes = {BaseActivityModule.class, PicassoModule.class})
public abstract class ForkDetailsActivityModule {
    @Binds
    @PerActivity
    abstract Activity activity(ForkDetailsActivity forkDetailsActivity);

    @Provides
    static ForkDetailsView provideForkDetailsView(ForkDetailsActivity forkDetailsActivity) {
        return forkDetailsActivity;
    }

    @Provides
    static ForkDetailsPresenter provideForkDetailsPresenter(ForkDetailsPresenterImpl forkDetailsPresenter) {
        return forkDetailsPresenter;
    }

}
