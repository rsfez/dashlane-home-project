package com.robined.dashlanehomeproject.injection.fork;


import com.robined.dashlanehomeproject.ui.fork.ForkListActivity;
import com.robined.dashlanehomeproject.ui.fork.ForkListFragment;
import dagger.Subcomponent;
import javax.inject.Singleton;

@Singleton
@Subcomponent(modules = ForkModule.class)
public interface ForkComponent {
    void inject(ForkListActivity forkListActivity);
    void inject(ForkListFragment forkListFragment);
}
