package com.kpgn.sqdemo.application;

import android.content.Context;

import com.kpgn.sqdemo.activity.MainActivity;
import com.kpgn.sqdemo.utility.DateTimeUtil;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        injects = {
                Context.class,
                SQDemoApplication.class,
                MainActivity.class,
                DateTimeUtil.class,
        }
)
public class SQDemoModule {

    private Context context;

    public SQDemoModule(Context context) {
        this.context = context;
    }

    @SuppressWarnings("unused")
    @Provides
    @Singleton
    public Context providesContext() {
        return context;
    }

    @SuppressWarnings("unused")
    @Provides
    @Singleton
    public DateTimeUtil providesDateTimeUtil() {
        return new DateTimeUtil();
    }

}
