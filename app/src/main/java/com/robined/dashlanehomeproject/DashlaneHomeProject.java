package com.robined.dashlanehomeproject;


import android.app.Application;
import com.robined.dashlanehomeproject.injection.app.DaggerDashlaneHomeProjectComponent;
import com.robined.dashlanehomeproject.injection.app.DashlaneHomeProjectComponent;
import com.robined.dashlanehomeproject.injection.app.DashlaneHomeProjectModule;
import com.squareup.leakcanary.LeakCanary;

public class DashlaneHomeProject extends Application {

    private DashlaneHomeProjectComponent mDashlaneHomeProjectComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);

        mDashlaneHomeProjectComponent = DaggerDashlaneHomeProjectComponent.builder()
                .dashlaneHomeProjectModule(new DashlaneHomeProjectModule(this)).build();
    }

    public DashlaneHomeProjectComponent getDashlaneHomeProjectComponent() {
        return mDashlaneHomeProjectComponent;
    }
}
