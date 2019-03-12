package hobby.siva.smsapplication;

import android.app.Application;

import hobby.siva.smsapplication.di.AppComponent;
import hobby.siva.smsapplication.di.AppModule;
import hobby.siva.smsapplication.di.DaggerAppComponent;
import hobby.siva.smsapplication.di.DataModule;

/*
 * Copyright (c) 2019 Blue Jeans Network, Inc. All rights reserved.
 * Created by sarumugam on 12/03/19
 */
public class SMSApplication extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder()
                .dataModule(new DataModule())
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}