package com.robined.dashlanehomeproject.injection.app;


import android.content.Context;
import com.robined.dashlanehomeproject.DashlaneHomeProject;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class DashlaneHomeProjectModule {
    private final DashlaneHomeProject mDashlaneHomeProject;

    public DashlaneHomeProjectModule(DashlaneHomeProject dashlaneHomeProject) {
        mDashlaneHomeProject = dashlaneHomeProject;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        return new Retrofit.Builder().baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();
    }

    @Provides
    @Singleton Context provideApplicationContext() {
        return mDashlaneHomeProject.getApplicationContext();
    }
}
