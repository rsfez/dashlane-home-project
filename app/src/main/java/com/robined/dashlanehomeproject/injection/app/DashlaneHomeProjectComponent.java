package com.robined.dashlanehomeproject.injection.app;


import com.robined.dashlanehomeproject.injection.fork.ForkComponent;
import com.robined.dashlanehomeproject.injection.fork.ForkModule;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = DashlaneHomeProjectModule.class)
public interface DashlaneHomeProjectComponent {
    ForkComponent plus(ForkModule forkModule);
}
