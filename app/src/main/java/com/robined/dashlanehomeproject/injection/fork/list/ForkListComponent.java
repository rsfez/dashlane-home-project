package com.robined.dashlanehomeproject.injection.fork.list;


import com.robined.dashlanehomeproject.injection.utils.PicassoModule;
import com.robined.dashlanehomeproject.ui.fork.list.ForkListFragment;
import dagger.Subcomponent;
import javax.inject.Singleton;

@Singleton
@Subcomponent(modules = {ForkListModule.class, PicassoModule.class})
public interface ForkListComponent {
    void inject(ForkListFragment forkListFragment);
}
