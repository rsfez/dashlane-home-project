package com.robined.dashlanehomeproject.injection.fork;


import android.content.Context;
import com.robined.dashlanehomeproject.data.fork.interactor.ForkInteractor;
import com.robined.dashlanehomeproject.data.fork.interactor.ForkInteractorImpl;
import com.robined.dashlanehomeproject.data.fork.network.ForkService;
import com.robined.dashlanehomeproject.ui.fork.ForkListPresenterImpl;
import com.robined.dashlanehomeproject.ui.fork.contracts.ForkListPresenter;
import com.robined.dashlanehomeproject.ui.fork.contracts.ForkListView;
import com.squareup.picasso.Picasso;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import retrofit2.Retrofit;

@Module
public class ForkModule {
    private final ForkListView mForkListView;

    public ForkModule(ForkListView forkListView) {
        mForkListView = forkListView;
    }

    @Provides
    ForkListView provideForkListView() {
        return mForkListView;
    }

    @Provides
    ForkInteractor provideForkInteractor(ForkInteractorImpl forkInteractor) {
        return forkInteractor;
    }

    @Provides
    ForkListPresenter provideForkPresenter(ForkListPresenterImpl forkPresenter) {
        return forkPresenter;
    }

    @Provides
    @Singleton
    ForkService provideForkService(Retrofit retrofit) {
        return retrofit.create(ForkService.class);
    }

    @Provides
    @Singleton
    Picasso providePicasso(Context context) {
        return new Picasso.Builder(context).build();
    }
}
