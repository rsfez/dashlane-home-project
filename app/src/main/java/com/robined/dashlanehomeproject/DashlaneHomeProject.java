package com.robined.dashlanehomeproject;


import android.app.Application;
import com.squareup.leakcanary.LeakCanary;

public class DashlaneHomeProject extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}
