package com.robined.dashlanehomeproject.injection.fork.list;


import android.app.Activity;
import com.robined.dashlanehomeproject.injection.base.BaseActivityModule;
import com.robined.dashlanehomeproject.injection.scopes.PerActivity;
import com.robined.dashlanehomeproject.injection.scopes.PerFragment;
import com.robined.dashlanehomeproject.injection.utils.PicassoModule;
import com.robined.dashlanehomeproject.ui.fork.list.ForkListActivity;
import com.robined.dashlanehomeproject.ui.fork.list.ForkListFragment;
import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(includes = BaseActivityModule.class)
public abstract class ForkListActivityModule {
    @PerFragment
    @ContributesAndroidInjector(modules = {ForkListFragmentModule.class, PicassoModule.class})
    abstract ForkListFragment forkListFragmentInjector();

    @Binds
    @PerActivity
    abstract Activity activity(ForkListActivity forkListActivity);
}
