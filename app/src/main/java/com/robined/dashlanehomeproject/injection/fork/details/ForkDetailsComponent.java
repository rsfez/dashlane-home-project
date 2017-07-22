package com.robined.dashlanehomeproject.injection.fork.details;


import com.robined.dashlanehomeproject.injection.PicassoModule;
import com.robined.dashlanehomeproject.ui.fork.details.ForkDetailsActivity;
import dagger.Subcomponent;
import javax.inject.Singleton;

@Singleton
@Subcomponent(modules = {ForkDetailsModule.class, PicassoModule.class})
public interface ForkDetailsComponent {
    void inject(ForkDetailsActivity activity);
}
