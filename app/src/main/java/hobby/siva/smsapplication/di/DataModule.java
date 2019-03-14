package hobby.siva.smsapplication.di;

import dagger.Module;
import dagger.Provides;
import hobby.siva.smsapplication.model.SMSModel;

/*
 * Copyright (c) 2019 Blue Jeans Network, Inc. All rights reserved.
 * Created by sarumugam on 13/03/19
 */
@Module
public class DataModule {

    @Provides
    public SMSModel provideSMSModule() {
        return new SMSModel();
    }

}