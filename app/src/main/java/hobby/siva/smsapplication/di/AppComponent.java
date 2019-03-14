package hobby.siva.smsapplication.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import hobby.siva.smsapplication.SMSApplication;
import hobby.siva.smsapplication.model.SMSModel;

/*
 * Copyright (c) 2019 Blue Jeans Network, Inc. All rights reserved.
 * Created by sarumugam on 13/03/19
 */
@Singleton
@Component(modules = { AppModule.class, DataModule.class })
public interface AppComponent {

    void inject(SMSApplication application);

    SMSModel getSMSModel();

    Application getApplication();

}