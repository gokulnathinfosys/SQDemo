package com.kpgn.sqdemo.application;

import android.app.Application;

import dagger.ObjectGraph;

public class SQDemoApplication extends Application {

    public static ObjectGraph objectGraph;
    public static SQDemoApplication sqDemoApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        sqDemoApplication = this;
        objectGraph = ObjectGraph.create(getModules());
    }

    protected Object[] getModules() {
        Object[] objects = {new SQDemoModule(this)};
        return objects;
    }

    public static void inject(Object o) {
        objectGraph.inject(o);
    }

    public static <T> T get(Class<T> tClass) {
        return objectGraph.get(tClass);
    }
}
