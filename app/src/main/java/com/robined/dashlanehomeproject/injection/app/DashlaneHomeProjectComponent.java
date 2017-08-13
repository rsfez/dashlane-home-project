package com.robined.dashlanehomeproject.injection.app;


import com.robined.dashlanehomeproject.DashlaneHomeProject;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = DashlaneHomeProjectModule.class)
public interface DashlaneHomeProjectComponent {
    void inject(DashlaneHomeProject dashlaneHomeProject);
}
