package com.robined.dashlanehomeproject.injection.base;


import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;
import javax.inject.Inject;
import javax.inject.Named;

public class BaseAppCompatActivity extends AppCompatActivity implements HasFragmentInjector {

    @Inject
    @Named(BaseActivityModule.ACTIVITY_FRAGMENT_MANAGER)
    protected FragmentManager mFragmentManager;

    @Inject
    DispatchingAndroidInjector<Fragment> mFragmentInjector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public AndroidInjector<Fragment> fragmentInjector() {
        return mFragmentInjector;
    }

    protected final void replaceFragment(@IdRes int containerViewId,
                                         Fragment fragment,
                                         String tag) {
        mFragmentManager.beginTransaction()
                .replace(containerViewId, fragment, tag).commit();
    }
}
