package hobby.siva.smsapplication.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hobby.siva.smsapplication.SMSApplication;

/*
 * Copyright (c) 2019 Blue Jeans Network, Inc. All rights reserved.
 * Created by sarumugam on 13/03/19
 */
@Module
public class AppModule {

    private SMSApplication mApplication;

    public AppModule(SMSApplication application) {
        this.mApplication = application;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return mApplication;
    }
}