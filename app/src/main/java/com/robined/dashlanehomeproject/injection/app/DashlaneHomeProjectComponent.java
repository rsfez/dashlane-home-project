package com.robined.dashlanehomeproject.injection.app;


import com.robined.dashlanehomeproject.injection.PicassoModule;
import com.robined.dashlanehomeproject.injection.fork.details.ForkDetailsComponent;
import com.robined.dashlanehomeproject.injection.fork.details.ForkDetailsModule;
import com.robined.dashlanehomeproject.injection.fork.list.ForkListComponent;
import com.robined.dashlanehomeproject.injection.fork.list.ForkListModule;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = DashlaneHomeProjectModule.class)
public interface DashlaneHomeProjectComponent {
    ForkListComponent plus(ForkListModule forkListModule, PicassoModule picassoModule);
    ForkDetailsComponent plus(ForkDetailsModule forkDetailsModule, PicassoModule picassoModule);
}
