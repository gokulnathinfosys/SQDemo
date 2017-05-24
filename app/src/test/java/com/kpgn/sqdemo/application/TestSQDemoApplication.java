package com.kpgn.sqdemo.application;

import android.app.Application;

import dagger.ObjectGraph;

public class TestSQDemoApplication extends SQDemoApplication {

    @Override
    protected Object[] getModules() {
        Object[] objects = {new TestSQDemoModule(this)};
        return objects;
    }
}
