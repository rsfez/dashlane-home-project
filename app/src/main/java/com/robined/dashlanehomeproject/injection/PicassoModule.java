package com.robined.dashlanehomeproject.injection;


import android.content.Context;
import com.robined.dashlanehomeproject.injection.app.DashlaneHomeProjectModule;
import com.squareup.picasso.Picasso;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module(includes = DashlaneHomeProjectModule.class)
public class PicassoModule {
    @Provides
    @Singleton
    Picasso providePicasso(Context context) {
        return new Picasso.Builder(context).build();
    }
}
