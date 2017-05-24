package com.kpgn.sqdemo.application;

import android.content.Context;

import com.kpgn.sqdemo.activity.MainActivity;
import com.kpgn.sqdemo.activity.MainActivityTest;
import com.kpgn.sqdemo.utility.DateTimeUtil;
import com.kpgn.sqdemo.utility.DateTimeUtilTest;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        injects = {
                Context.class,
                SQDemoApplication.class,
                TestSQDemoApplication.class,
                MainActivity.class,
                MainActivityTest.class,
                DateTimeUtil.class,
                DateTimeUtilTest.class,
        }
)
public class TestSQDemoModule {

    private Context context;

    public TestSQDemoModule(Context context) {
        this.context = context;
    }

    @SuppressWarnings("unused")
    @Provides
    @Singleton
    public Context providesContext() {
        return context;
    }

    @Provides
    @Singleton
    public DateTimeUtil providesDateTimeUtil() {
        return new DateTimeUtil();
    }

}
