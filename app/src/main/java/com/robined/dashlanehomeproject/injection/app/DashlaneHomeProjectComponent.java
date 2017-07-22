package com.robined.dashlanehomeproject.injection.app;


import com.robined.dashlanehomeproject.injection.fork.list.ForkListComponent;
import com.robined.dashlanehomeproject.injection.fork.list.ForkListModule;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = DashlaneHomeProjectModule.class)
public interface DashlaneHomeProjectComponent {
    ForkListComponent plus(ForkListModule forkListModule);
}
