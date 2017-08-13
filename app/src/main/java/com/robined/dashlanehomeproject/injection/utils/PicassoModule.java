package com.robined.dashlanehomeproject.injection.utils;


import android.content.Context;
import com.squareup.picasso.Picasso;
import dagger.Module;
import dagger.Provides;

@Module
public class PicassoModule {
    @Provides
    Picasso providePicasso(Context context) {
        return new Picasso.Builder(context).build();
    }
}
