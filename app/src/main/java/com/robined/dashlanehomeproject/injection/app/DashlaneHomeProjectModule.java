package com.robined.dashlanehomeproject.injection.app;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.robined.dashlanehomeproject.injection.fork.details.ForkDetailsActivityModule;
import com.robined.dashlanehomeproject.injection.fork.list.ForkListActivityModule;
import com.robined.dashlanehomeproject.injection.scopes.PerActivity;
import com.robined.dashlanehomeproject.ui.fork.details.ForkDetailsActivity;
import com.robined.dashlanehomeproject.ui.fork.list.ForkListActivity;
import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;
import javax.inject.Singleton;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

@Module(includes = AndroidInjectionModule.class)
abstract class DashlaneHomeProjectModule {
    @PerActivity
    @ContributesAndroidInjector(modules = ForkListActivityModule.class)
    abstract ForkListActivity forkListActivityInjector();

    @PerActivity
    @ContributesAndroidInjector(modules = ForkDetailsActivityModule.class)
    abstract ForkDetailsActivity forkDetailsActivityInjector();

    @Provides
    @Singleton
    static Retrofit provideRetrofit() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        return new Retrofit.Builder().baseUrl("https://api.github.com/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create(gson)).build();
    }
}
