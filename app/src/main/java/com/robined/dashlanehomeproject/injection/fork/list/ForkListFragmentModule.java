package com.robined.dashlanehomeproject.injection.fork.list;


import android.app.Fragment;
import com.robined.dashlanehomeproject.data.fork.interactor.ForkInteractor;
import com.robined.dashlanehomeproject.data.fork.interactor.ForkInteractorImpl;
import com.robined.dashlanehomeproject.data.fork.network.ForkService;
import com.robined.dashlanehomeproject.injection.base.BaseFragmentModule;
import com.robined.dashlanehomeproject.injection.scopes.PerFragment;
import com.robined.dashlanehomeproject.ui.fork.list.ForkListFragment;
import com.robined.dashlanehomeproject.ui.fork.list.ForkListPresenterImpl;
import com.robined.dashlanehomeproject.ui.fork.list.contracts.ForkListPresenter;
import com.robined.dashlanehomeproject.ui.fork.list.contracts.ForkListView;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import retrofit2.Retrofit;

@Module(includes = BaseFragmentModule.class)
public abstract class ForkListFragmentModule {
    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    @PerFragment
    abstract Fragment fragment(ForkListFragment forkListFragment);

    @PerFragment
    @Provides
    static ForkListView provideForkListView(ForkListFragment forkListFragment) {
        return forkListFragment;
    }

    @PerFragment
    @Provides
    static ForkInteractor provideForkInteractor(ForkInteractorImpl forkInteractor) {
        return forkInteractor;
    }

    @PerFragment
    @Provides
    static ForkListPresenter provideForkPresenter(ForkListPresenterImpl forkPresenter) {
        return forkPresenter;
    }

    @PerFragment
    @Provides
    static ForkService provideForkService(Retrofit retrofit) {
        return retrofit.create(ForkService.class);
    }
}
