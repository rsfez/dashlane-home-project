package com.robined.dashlanehomeproject;


import android.app.Activity;
import android.app.Application;
import com.robined.dashlanehomeproject.injection.app.DaggerDashlaneHomeProjectComponent;
import com.squareup.leakcanary.LeakCanary;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import javax.inject.Inject;

public class DashlaneHomeProject extends Application implements HasActivityInjector {

    @Inject DispatchingAndroidInjector<Activity> mAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);

        DaggerDashlaneHomeProjectComponent.create().inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return mAndroidInjector;
    }
}
